package org.dev.commerce.bank.service;

import java.io.IOException;

import org.dev.commerce.bank.model.Account;
import org.springframework.data.domain.Sort.Direction;

public interface MoneyTransferService {

	Iterable<Account> findAll(int page, int count, Direction direction, String sortProperty);

	Account save(Account detail);

	Account findOne(String id);

	void delete(String id);

	Account update(String id, Account account) throws IOException;

}
