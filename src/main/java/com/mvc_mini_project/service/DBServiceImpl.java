package com.mvc_mini_project.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBServiceImpl implements DBService {
	public Connection con;
	public Statement stmt;
	@Override
	public void connectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jan_db","root","PASS");
			stmt=con.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeDb() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public boolean login(String email,String password) {
		try {
			ResultSet result= stmt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet getUserByEmail(String email) {
		try {
			ResultSet result=stmt.executeQuery("select * from login where email='"+email+"'");
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void registerUser(String name, String email, String mobile, String userId) {
		try {
			stmt.executeUpdate("insert into registration (name,email,mobile,userId) values ('"+name+"','"+email+"','"+mobile+"','"+userId+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet getRegistraionsByUserId(String userId) {
		try {
			ResultSet result=stmt.executeQuery("select * from registration where userid='"+userId+"'");
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteRegistraionsByEmail(String email) {
		try {
			stmt.executeUpdate("delete from registration where email='"+email+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
