package org.dev.commerce.bank.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.dev.commerce.bank.model.Account;
import org.dev.commerce.bank.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountRegistrationController {

	public static final Logger logger = LoggerFactory.getLogger(AccountRegistrationController.class);

	private final AccountService accountService;

	@Autowired
	public AccountRegistrationController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Account> findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "count", defaultValue = "10", required = false) int count,
			@RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
			@RequestParam(value = "sort", defaultValue = "accountName", required = false) String sortProperty) {
		return accountService.findAll(page, count, direction, sortProperty);
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
	public HttpEntity<?> find(@PathVariable String id) {
		Account detail = accountService.findOne(id);
		if (detail == null) {
			logger.error("Account with id {} not found.", id);
			return new ResponseEntity<AccountServiceException>(
					new AccountServiceException("Account with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Account>(detail, HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public Account create(@RequestBody @Valid Account detail) {
		return accountService.save(detail);
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
	public HttpEntity<?> updateCab(@PathVariable String id, @Valid @RequestBody Account account) throws IOException {
		Account updated = accountService.update(id, account);// request.getReader());
		if (updated == null) {
			logger.error("Account with id {} not found.", id);
			return new ResponseEntity<AccountServiceException>(
					new AccountServiceException("Account with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Account>(updated, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
	public HttpEntity<?> delete(@PathVariable String id) {
		accountService.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
		messageBundle.setBasename("classpath:messages/error");
		messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	static class AccountServiceException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private String errorMessage;

		public AccountServiceException(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		@Override
		public StackTraceElement[] getStackTrace() {
			// logger.error(Arrays.toString(super.getStackTrace()));
			return null;
		}
	}

}