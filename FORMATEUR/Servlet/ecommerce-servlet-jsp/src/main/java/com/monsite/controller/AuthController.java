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
@WebServlet("/auth")
public class AuthController extends HttpServlet {
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
		action = (action==null ? "login": action);
			switch(action) {
				case "login":
					login(request, response);
					break;
				case "logout":
					logout(request, response);
					break;
				default:
					login(request, response);
			}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		Login loggedUser = (Login) request.getSession().getAttribute("login");
		
		if(loggedUser != null) {
			response.sendRedirect("index");
		}else {
			request.getRequestDispatcher("auth/auth.jsp").forward(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		Login loggedUser = (Login) request.getSession().getAttribute("login");
		
		if(loggedUser != null) {
			request.getSession().invalidate();
		}
		response.sendRedirect("index");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
	
			Login login_obj = loginDao.findByLoginAndPassword(login, password);
			
			if(login_obj != null) {
				request.getSession().setAttribute("login", login_obj);
				response.sendRedirect("index");
			}else {
				request.setAttribute("error", "Un erreur est survenue");
				request.getRequestDispatcher("auth/auth.jsp").forward(request, response);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
