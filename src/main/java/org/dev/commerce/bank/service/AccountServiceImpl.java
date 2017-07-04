package org.dev.commerce.bank.service;

import java.io.IOException;

import org.dev.commerce.bank.model.Account;
import org.dev.commerce.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	private final AccountRepository AccountRepository;

	@Autowired
	public AccountServiceImpl(AccountRepository AccountRepository) {
		this.AccountRepository = AccountRepository;
	}

	@Override
	public Iterable<Account> findAll(int page, int count, Direction direction, String sortProperty) {
		Page<Account> result = AccountRepository
				.findAll(new PageRequest(page, count, new Sort(direction, sortProperty)));
		return result.getContent();
	}

	@Override
	public Account save(Account detail) {
		return AccountRepository.save(detail);
	}

	@Override
	public Account findOne(String id) {
		return AccountRepository.findOne(id);
	}

	@Override
	public void delete(String id) {
		Account existing = findOne(id);
		if (existing == null) {
			return;
		}
		AccountRepository.delete(existing);
	}

	@Override
	public Account update(String id, Account Account) throws IOException {
		Account existing = findOne(id);
		if (existing == null) {
			return null;
		}
		existing = Account;
		return AccountRepository.save(existing);
	}

}
