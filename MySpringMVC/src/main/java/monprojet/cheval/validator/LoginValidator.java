package monprojet.cheval.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import monprojet.cheval.model.Login;

public class LoginValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Login.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login_rong", "abcdef");
		// search ten_rong in properties files, if not will show string """
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwrd", "passwrd_rong", "abcdef");
	}
}