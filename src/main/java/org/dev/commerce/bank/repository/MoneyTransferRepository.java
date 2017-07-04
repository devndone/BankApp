package org.dev.commerce.bank.repository;

import java.util.List;

import org.dev.commerce.bank.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyTransferRepository extends PagingAndSortingRepository<Account, String> {

	@Query("select a from Account a where UPPER(a.accountStatus) like UPPER(?1) or "
			+ "UPPER(a.description) like UPPER(?1)")
	public List<Account> search(String term);

}
