package org.dev.commerce.bank.repository;

import org.dev.commerce.bank.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, String> {

}
