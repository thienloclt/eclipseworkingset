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
import ecommerce.dao.LoginDao;
import ecommerce.dao.LoginDao;
import ecommerce.model.Categorie;
import ecommerce.model.Login;
import ecommerce.model.Login;
import ecommerce.model.Role;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao loginDao;
    @Override
    public void init() throws ServletException {
	    	super.init();
	    	loginDao = Application.getInstance().getLoginDao();    	
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
					if(authLogged != null  && authLogged.getRole() == Role.ADMIN)
						list(request, response);
					else
						response.sendRedirect("index");
					break;
				case "detail":
					if(authLogged != null  && authLogged.getRole() == Role.ADMIN)
						detail(request, response);
					else
						response.sendRedirect("index");
					break;

			}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("login", new Login());
		request.setAttribute("roles", Role.values());
		request.getRequestDispatcher("login/addform.jsp").forward(request, response);
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		
		Login login = loginDao.find(Long.parseLong(id));
		request.setAttribute("login",login);
		request.getRequestDispatcher("login/detail.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Login> logins;
		
		logins = loginDao.findAll();
		request.setAttribute("logins", logins);
		request.getRequestDispatcher("login/list.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		
		Login login = loginDao.find(Long.parseLong(id));
		if(login != null) {
			Application.getInstance().getLoginDao().delete(login);		
		}
		response.sendRedirect("login?action=list");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idProduct = Long.parseLong(request.getParameter("id"));
		Login login = loginDao.find(idProduct);
		
		if(login == null) {
			response.sendRedirect("login?action=list");
		}
		
		request.setAttribute("login", login);
		request.setAttribute("roles", Role.values());
		
		request.getRequestDispatcher("login/addform.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Login authLogged = (Login) request.getSession().getAttribute("login");

			if(authLogged == null || authLogged.getRole() != Role.ADMIN) {
				response.sendRedirect("index");
			}

			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			

		Login login_obj;
		String id = request.getParameter("id");
		if(request.getParameter("id") != null) {
			login_obj = loginDao.find(Long.parseLong(id));
 		}else {
 			login_obj = new Login();
		}
		
		Role role_enum = Role.valueOf(role);
		if(role_enum == null) {
			response.sendRedirect("login?action=list");
		}
		
		login_obj.setLogin(login);
		login_obj.setMotDePasse(password);
		login_obj.setRole(role_enum);;
		
		if(login_obj.getId() != null) {
			loginDao.update(login_obj);
		}else {
			loginDao.create(login_obj);
		}
		response.sendRedirect("login?action=list");
		} catch(Exception e) {
			request.setAttribute("error", "Un erreur est survenue");
			request.getRequestDispatcher("login/addform.jsp").forward(request, response);
			return;
		}
	}
}
