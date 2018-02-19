package com.monapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monapp.dao.ArtisteDao;
import com.monapp.metier.Artiste;
import com.monapp.metier.validator.ArtisteValidator;

@Controller
@RequestMapping("/artiste")
public class ArtisteController {
	
	@Autowired
	ArtisteDao artisteDao;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddNewArtistForm(Model model) {
		model.addAttribute("action","Ajouter");		

		Artiste a = new Artiste();
		
		model.addAttribute("artiste",a);
		return "artiste/addArtiste";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddNewArtistForm(@ModelAttribute("artiste") Artiste artiste) {
	
		if(artiste.getId() <= 0) {
			artisteDao.save(artiste);			
		}else {
			artisteDao.update(artiste);
		}
		return "redirect:/artiste/list";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String getAddNewArtistForm(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("action","Editer");		

		Artiste a = artisteDao.findByPrimaryKey(id);
		if(a == null) {
			return "redirect:/error";
		}
		model.addAttribute("artiste",a);
		return "artiste/addArtiste";
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getArtisteDetail(Model model, @PathVariable("id") int id) {
		Artiste a = artisteDao.findByPrimaryKey(id);
		
		model.addAttribute("artisteFromDb",a);
		return "artiste/showArtiste";
	}

	
	@RequestMapping(value="/list")
	public String listArtist(Model model) {		
		List<Artiste> listArt = artisteDao.findAll();
		model.addAttribute("listeArtistes", listArt);
		return "artiste/listArtiste";
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteArtiste(Model model, @PathVariable("id") int id) {
		Artiste a = artisteDao.findByPrimaryKey(id);
		artisteDao.delete(a);
		
		return "redirect:/artiste/list";

	}
	
}
