package com.mvc_mini_project.service;

import java.sql.ResultSet;

public interface DBService {
	void connectDb();
	void closeDb();
	boolean login(String email,String password);
	ResultSet getUserByEmail(String email);
	void registerUser(String name,String email,String mobile,String userId);
	ResultSet getRegistraionsByUserId(String userId);
	void deleteRegistraionsByEmail(String email);
}
