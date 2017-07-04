package org.dev.commerce.bank.controller;

import org.dev.commerce.bank.service.MoneyTransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mt", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoneyTransferController {

	public static final Logger logger = LoggerFactory.getLogger(MoneyTransferController.class);

	private final MoneyTransferService moneyTransferService;

	@Autowired
	public MoneyTransferController(MoneyTransferService moneyTransferService) {
		this.moneyTransferService = moneyTransferService;
	}
}