package monprojet.cheval.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import monprojet.cheval.dao.CentreEquestreDao;
import monprojet.cheval.dao.ChevalDao;
import monprojet.cheval.dao.RegistreDao;
import monprojet.cheval.model.Cheval;
import monprojet.cheval.validator.ChevalValidator;

@Controller
@RequestMapping("/cheval")
public class ChevalController {
	
	@Autowired
	ChevalDao chevalDao;
	
	@Autowired
	CentreEquestreDao centreEquestreDao;
	
	@Autowired
	RegistreDao registreDao;

	@RequestMapping("/")
	public String greeting(Model model) {

		return listCheval(model);
	}

	@RequestMapping("/list")
	public String listCheval(Model model) {
		
		List<Cheval> chevals = chevalDao.findAll();
		model.addAttribute("chevals", chevals);
		return "cheval/chevallist";
	}

	@RequestMapping("/detail/{id}")
	public String detailCheval(@PathVariable("id") Long id, Model model) {

		model.addAttribute("cheval", chevalDao.find(id));
		return "cheval/chevaldetail";
	}

	@RequestMapping("/del/{id}")
	public String delCheval(@PathVariable("id") Long id, Model model) {
		
		chevalDao.delete(chevalDao.find(id));
		return listCheval(model);
	}

	@RequestMapping("/edit/{id}")
	public String editCheval(@PathVariable("id") Long id, Model model) {

		model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("chevalObj", chevalDao.find(id));
		return "cheval/chevaladd";
	}

	@RequestMapping("/add")
	public String addCheval(Model model) {
		
		model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("chevalObj", new Cheval());
		return "cheval/chevaladd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitCheval(@Valid @ModelAttribute("chevalObj") Cheval cheval, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("centreEquestres", centreEquestreDao.findAll());
			return "cheval/chevaladd";
		}
		else {
			if(cheval.getId() == null)
				chevalDao.create(cheval);
			else
				chevalDao.update(cheval);
			
			return listCheval(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// register the ChevalValidator used to validate objects of type Cheval
		binder.setValidator(new ChevalValidator());
	}
}