package com.mvc_mini_project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc_mini_project.service.DBServiceImpl;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegistrationController() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBServiceImpl dbi=new DBServiceImpl();
		dbi.connectDb();
		HttpSession session=request.getSession(false);
		String cuemail=session.getAttribute("email").toString();
		ResultSet result= dbi.getUserByEmail(cuemail);
		String userid="";
		try {
			if (result.next()) {  
				userid= result.getString(1);
			}
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			dbi.registerUser(name, email, mobile, userid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("message", "Registration successful");
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
		rd.forward(request, response);
	}

}
