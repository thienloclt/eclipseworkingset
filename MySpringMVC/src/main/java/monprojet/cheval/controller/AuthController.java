package monprojet.cheval.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import monprojet.cheval.dao.LoginDao;
import monprojet.cheval.model.Login;
import monprojet.cheval.validator.LoginValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	LoginDao loginDao;

	@RequestMapping("/")
	public String greeting(Model model) {

		return "other/index";
	}

	@RequestMapping("/logout")
	public String logout(Model model, HttpSession httpSession) {

		Login loggedUser = (Login) httpSession.getAttribute("login");

		if (loggedUser != null) {
			httpSession.invalidate();
		}
		return greeting(model);
	}

	@RequestMapping("/login")
	public String login(Model model, HttpSession httpSession) {

		Login loggedUser = (Login) httpSession.getAttribute("login");
		if (loggedUser != null) {
			return greeting(model);
		}
		else {
			model.addAttribute("authObj", new Login());
			return "other/auth";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitLogin(@Valid @ModelAttribute("authObj") Login login, BindingResult bindingResult, Model model, HttpSession httpSession) {

		if (bindingResult.hasErrors()) {
			return "other/auth";
		} else {
			Login login_obj = loginDao.findByNamePass(login.getLogin(), login.getpasswrd());
			if (login_obj != null) {
				httpSession.setAttribute("login", login_obj);
				return greeting(model);
			} 
			else {
				bindingResult.rejectValue("login", "error.user", "Username or Password invalid");
				return "other/auth";
			}
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginValidator());
	}
}