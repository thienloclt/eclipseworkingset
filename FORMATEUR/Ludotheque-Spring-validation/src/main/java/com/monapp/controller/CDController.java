package com.monapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monapp.dao.ArtisteDao;
import com.monapp.dao.CdDao;
import com.monapp.metier.Artiste;
import com.monapp.metier.CD;

@Controller
@RequestMapping("/cd")
public class CDController {

	@Autowired
	CdDao cdDao;
	
	@Autowired
	ArtisteDao artisteDao;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddNewArtistForm(Model model) {
		model.addAttribute("action","Ajouter");		

		CD cd = new CD();		
		List<Artiste> artistList = artisteDao.findAll();
		model.addAttribute("cd",cd);
		model.addAttribute("artistList", artistList);
		
		return "cd/addCd";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddNewArtistForm(@ModelAttribute("cd") CD cd
			) {
		if(cd.getId() <= 0) {
			cdDao.save(cd);			
		}else {
			cdDao.update(cd);
		}
		
		return "redirect:/cd/list";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String getAddNewArtistForm(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("action","Editer");		
		List<Artiste> artistList = artisteDao.findAll();
		model.addAttribute("artistList", artistList);

		CD a = cdDao.findByPrimaryKey(id);
		if(a == null) {
			return "redirect:/error";
		}
		model.addAttribute("cd",a);
		return "cd/addCd";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getCDDetail(Model model, @PathVariable("id") int id) {
		
		CD a = cdDao.findByPrimaryKey(id);
		
		model.addAttribute("cd",a);
		return "cd/showCd";
	}

	@RequestMapping(value="/list")
	public String listCd(Model model) {
		model.addAttribute("action","Liste");		
		
		model.addAttribute("listeCds",cdDao.findAll());
		return "cd/listCd";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteCD(Model model, @PathVariable("id") int id) {
		CD a = cdDao.findByPrimaryKey(id);
		cdDao.delete(a);
		
		return "redirect:/cd/list";

	}
}
