package com.mvc_mini_project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.mvc_mini_project.service.DBServiceImpl;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		DBServiceImpl log1=new DBServiceImpl();
		log1.connectDb();
		if(log1.login(email, password)) {
			HttpSession session=request.getSession(true);
			session.setAttribute("email", email);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
			rd.forward(request, response);
			
			
		}else {
			request.setAttribute("error", "Invalid email/password");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		log1.closeDb();
	}

}
