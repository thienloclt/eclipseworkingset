package com.monsite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.Application;
import ecommerce.dao.CategorieDao;
import ecommerce.dao.ProduitDao;
import ecommerce.model.Categorie;
import ecommerce.model.Login;
import ecommerce.model.Produit;
import ecommerce.model.Role;

/**
 * Servlet implementation class Produit
 */
@WebServlet("/produit")
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduitDao produitDao;
	CategorieDao categorieDao;
    @Override
    public void init() throws ServletException {
	    	super.init();
    		produitDao = Application.getInstance().getProduitDao();    	
    		categorieDao = Application.getInstance().getCategorieDao();    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Login authLogged = (Login) request.getSession().getAttribute("login");
			
			switch(action) {
				case "add":
					if(authLogged != null  && authLogged.getRole() == Role.ADMIN)
						add(request, response);						
					else
						response.sendRedirect("index");
					break;
				case "edit":
					if(authLogged != null  && authLogged.getRole() == Role.ADMIN)
						edit(request, response);
					else
						response.sendRedirect("index");
					break;
				case "delete":
					if(authLogged != null  && authLogged.getRole() == Role.ADMIN)
						delete(request, response);
					else
						response.sendRedirect("index");
					break;
				case "list":
					if(authLogged != null  && (authLogged.getRole() == Role.ADMIN || authLogged.getRole() == Role.USER ))
						list(request, response);
					else
						response.sendRedirect("index");
					break;
				case "detail":
					if(authLogged != null  && (authLogged.getRole() == Role.ADMIN || authLogged.getRole() == Role.USER )) 
						detail(request, response);
					else
						response.sendRedirect("index");
					break;
			}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("produit", new Produit());
		request.setAttribute("categories", categorieDao.findAll());
		request.getRequestDispatcher("produit/addform.jsp").forward(request, response);
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		
		Produit produit = produitDao.find(Long.parseLong(id));
		request.setAttribute("produit", produit);
		request.getRequestDispatcher("produit/detail.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produit> produits;
		
		produits = produitDao.findAll();
		request.setAttribute("produits", produits);
		request.getRequestDispatcher("produit/list.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		
		Produit produit = produitDao.find(Long.parseLong(id));
		if(produit != null) {
			Application.getInstance().getProduitDao().delete(produit);		
		}
		response.sendRedirect("produit?action=list");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idProduct = Long.parseLong(request.getParameter("id"));
		Produit produit = produitDao.find(idProduct);
		
		if(produit == null) {
			response.sendRedirect("produit?action=list");
		}
		
		request.setAttribute("produit", produit);
		request.setAttribute("categories", categorieDao.findAll());
		
		request.getRequestDispatcher("produit/addform.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String name = request.getParameter("nom");
			double prix = Double.valueOf(request.getParameter("prix"));
			String description = request.getParameter("description");
			int stock = Integer.parseInt(request.getParameter("stock"));
			long categorie_id = Long.parseLong(request.getParameter("categorie"));

		

		Produit produit;
		String id = request.getParameter("id");
		if(request.getParameter("id") != null) {
			produit = produitDao.find(Long.parseLong(id));
 		}else {
			produit = new Produit();
		}
		
		Categorie categorie = categorieDao.find(categorie_id);
		if(categorie == null) {
			response.sendRedirect("produit?action=list");
		}
		
		produit.setNom(name);
		produit.setDescription(description);
		produit.setStock(stock);
		produit.setPrix(prix);
		produit.setCategorie(categorie);
		
		if(produit.getId() != null) {
			produitDao.update(produit);
		}else {
			produitDao.create(produit);
		}
		response.sendRedirect("produit?action=list");
		} catch(Exception e) {
			request.setAttribute("error", "Un erreur est survenue");
			request.getRequestDispatcher("produit/addform.jsp").forward(request, response);
			return;
		}
	}
}
