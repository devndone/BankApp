package org.dev.commerce.bank.validator;

import org.dev.commerce.bank.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BankValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Account detail = (Account) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountName", "", "error.accountName.notnull");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountStatus", "", "error.accountStatus.notnull");
//		if (detail.getAccountStatus().length() != 11) {
//			errors.rejectValue("accountStatus", "", "error.accountStatus.size");
//		}
	}
	
}
