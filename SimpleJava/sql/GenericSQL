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
public class GenericSQL {
	
	@SuppressWarnings("unused")
	private Statement st;
	private String usern=null;
	private Connection connection;
	
	/**
	 * Please know that this requires the MySQL JDBC Driver.\n
	 * From here you can create a user library including... \n
	 * Usernames, Emails, Passwords, Gender, and Age for each user
	 * 
	 * @param ip The IP Address to the SQL Database
	 * @param username The Username to the SQL Database
	 * @param password The Password of the SQL Database
	 * @param databaseName The Name of The Database
	 */
	public GenericSQL(String ip, String username, String password, String databaseName){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+databaseName+"?user="+username+"&password="+password);
			
			st = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			
			System.err.println("\n\nPlease note that this requires the MySQL JDBC Driver!");
		}
	}
	
	public void deleteUser(String username){
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Accounts WHERE username='"  + username + "';");
			ResultSet result = statement.executeQuery();
			
			if(!result.next()){
				System.err.println("Error!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getCurrentUser(){
		return usern;
	}
	
	public void setCurrentUser(String username){
		usern = username;
	}
	
	public boolean containsUser(String username){
        try {
            PreparedStatement statement = connection.prepareStatement("select password from Accounts where username='" + username + "'");
            ResultSet result = statement.executeQuery();
           
            if (result.next()) {
                    return true;
            } else {
                    return false;
            }
        } catch (Exception e) {
        		e.printStackTrace();
        		return false;
        }
	}
	
	public boolean containsEmail(String email){
		try {
            PreparedStatement statement = connection.prepareStatement("select username from Accounts where email='" + email + "'");
            ResultSet result = statement.executeQuery();
           
            if (result.next()) {
                    return true;
            } else {
                    return false;
            }
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
   
    public String getPassword(String username) {
        try {
                PreparedStatement statement = connection.prepareStatement("select password from Accounts where username='" + username + "'");
                ResultSet result = statement.executeQuery();
               
                if (result.next()) {
                        return result.getString("password");
                } else {
                        return "[[Invalid Username]]";
                }
        } catch (Exception e) {
                e.printStackTrace();
                return "[[Failed to connect]]";
        }
    }
   
    public String getGender(String username) {
        try {
                PreparedStatement statement = connection.prepareStatement("select gender from Accounts where username='" + username + "'");
                ResultSet result = statement.executeQuery();
               
                if (result.next()) {
                        return result.getString("gender");
                } else {
                        return "[[Invalid Username]]";
                }
        } catch (Exception e) {
                e.printStackTrace();
                return "[[Failed to connect]]";
        }
    }
    
    public String getAge(String username) {
        try {
                PreparedStatement statement = connection.prepareStatement("select age from Accounts where username='" + username + "'");
                ResultSet result = statement.executeQuery();
               
                if (result.next()) {
                        return result.getString("age");
                } else {
                        return "[[Invalid Username]]";
                }
        } catch (Exception e) {
                e.printStackTrace();
                return "[[Failed to connect]]";
        }
    }
    
    public String getEmail(String username) {
        try {
                PreparedStatement statement = connection.prepareStatement("select email from Accounts where username='" + username + "'");
                ResultSet result = statement.executeQuery();
               
                if (result.next()) {
                        return result.getString("email");
                } else {
                        return "[[Invalid Username]]";
                }
        } catch (Exception e) {
                e.printStackTrace();
                return "[[Failed to connect]]";
        }
    }
    
    
    
    public void createUser(String username, String name, String password, String gender, int age, String email) {
        try {
                PreparedStatement statement = connection.prepareStatement("insert into Accounts (name, username, password, gender, age, email)\nvalues ('" +name + "', '" +username + "', '" + password + "', '" + gender + "', '" + age + "', '" + email + "');");
                statement.executeUpdate();
                statement.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
	
}
