package com.monsite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String loginAdmin = "admin";
	String pass = "abcd";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Je récupère le paramètre action de mon URL...
		String action = request.getParameter("action");
		
		// Et en fonction de sa valeur...
		if(action != null && action.equals("login")) {
			// Je forward vers la jsp du formulaire de login.
			request.getRequestDispatcher("loginform.jsp").forward(request, response);	
		}else if(action != null && action.equals("logout")){
			// Je tue la session courante.
			request.getSession().invalidate();
			// et je redirige vers l'accueil
			response.sendRedirect("accueil?logout=1");
		}else {
			response.sendRedirect("accueil");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Je récupère les valeurs du formulaire
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		
		// Je compare avec les variables de classe:
		if(this.loginAdmin.equals(login) && this.pass.equals(pass)) {
			// J'ajoute le login à la session
			request.getSession().setAttribute("login", login);
			// Je redirige vers l'acceuil
			response.sendRedirect("accueil");
		}else {
			// Je passe une variable "error" à ma JSP
			request.setAttribute("error", "Identifiants incorrects");
			// et je forward
			request.getRequestDispatcher("loginform.jsp").forward(request, response);	
		}
	}

}
