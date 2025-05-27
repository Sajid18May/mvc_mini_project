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

import com.mvc_mini_project.service.DBServiceImpl;


@WebServlet("/deleteRegistration")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBServiceImpl service=new DBServiceImpl();
			service.connectDb();
			String regEmail = request.getParameter("regEmail").toString();
			service.deleteRegistraionsByEmail(regEmail);
			
			HttpSession session=request.getSession(false);
			String email=session.getAttribute("email").toString();
			
			ResultSet result=service.getUserByEmail(email);
			String userId="";
			if(result.next()) {
				userId=result.getString(1);
			}
			ResultSet registrations=service.getRegistraionsByUserId(userId);
			request.setAttribute("regiatrations", registrations);
			
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/RegistrationList.jsp");
			rd.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
