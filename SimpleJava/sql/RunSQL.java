package com.leftindust.SimpleJava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * Copyright (c) 2015 Daniel Shirvani
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * @author Daniel Shirvani
 * @version 1.0
 * 
 */
public class RunSQL {
	
	@SuppressWarnings("unused")
	private Statement st;
	private Connection connection;
	
	/**
	 * Please know that this requires the MySQL JDBC Driver.\n
	 * From here you can run SQL commands to your database from Java
	 * 
	 * @param ip The IP Address to the SQL Database
	 * @param username The Username to the SQL Database
	 * @param password The Password of the SQL Database
	 * @param databaseName The Name of The Database
	 */
	public RunSQL(String ip, String username, String password, String databaseName){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+databaseName+"?user="+username+"&password="+password);
			
			st = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			
			System.err.println("\n\nPlease note that this requires the MySQL JDBC Driver!");
		}
	}
	
	public ResultSet runSQL(String command){
		try {
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();
			
			if(!result.next()){
				System.err.println("No Result!");
			}
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}


