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

@WebServlet("/updateRegistration")
public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int id=Integer.parseInt(request.getParameter("id"));
			
			DBServiceImpl service=new DBServiceImpl();
			service.connectDb();
			
			ResultSet result=service.getRegistraionById(id);
			String userId="";
			String name=null;
			String emailId=null;
			String mobile=null;
			if(result.next()) {
				userId=result.getString(1);
				name=result.getString(2);
				emailId=result.getString(3);
				mobile=result.getString(4);
			}
			request.setAttribute("id", userId);
			request.setAttribute("name", name);
			request.setAttribute("emailId", emailId);
			request.setAttribute("mobile", mobile);
			
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/UpdateRegistration.jsp");
			rd.forward(request, response);
	}
		catch (Exception e) {
			e.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session=request.getSession(false);
			String email=session.getAttribute("email").toString();
			
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String emailId = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			DBServiceImpl service=new DBServiceImpl();
			service.connectDb();
			
			service.UpdateRegisteration(id, name, emailId, mobile);
			
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

}
