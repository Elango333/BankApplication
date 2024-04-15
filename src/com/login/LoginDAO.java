package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.utils.ConstantFile;
import com.utils.DatabaseConnection;

public class LoginDAO {
	  private DatabaseConnection connection = DatabaseConnection.getInstance();
	  private Connection conn = connection.getConnection();

	  // Encrypt the password
	  public String hashPassword(String plainTextPassword) {
	    return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	  }

	  // Decrypt the password
	  public boolean checkPassword(String plainTextPassword, String hashedPassword) {
	    return BCrypt.checkpw(plainTextPassword, hashedPassword);
	  }

	  // Store User register details to DB
	  boolean storeRegisterDetails(String username, String password, String mobileNum) {
	    boolean IsAccountCreated = false;
	    try {
	      PreparedStatement statement = conn.prepareStatement(ConstantFile.insert_query_for_register);
	      statement.setString(1, username);
	      statement.setString(2, hashPassword(password));
	      statement.setString(3, mobileNum);
	      int rowsAffected = statement.executeUpdate();

	      if (rowsAffected > 0) {
	        IsAccountCreated = true;
	      } else {
	        IsAccountCreated = false;
	      }

	    } catch (SQLException e) {
	      System.out.println("SQL Exception occurred in storeRegisterDetails method");
	      e.printStackTrace();
	    }
	    return IsAccountCreated;
	  }

	  //Check username & password ---> For login
	 public int IsIdExistsForLogin(String name, String password) {
	    int SessionId = 0;
	    try (PreparedStatement stmnt = conn.prepareStatement(ConstantFile.select_query_for_isAccountAlreadyExists)) {
	      stmnt.setString(1, name);
	      ResultSet resultSet = stmnt.executeQuery();
	      if (resultSet.next()) {
	        String hashedPasswordFromDB = resultSet.getString("Password");
	        if (checkPassword(password, hashedPasswordFromDB)) {
	          PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_sessionID);
	          statement.setString(1, name);
	          ResultSet rs = statement.executeQuery();
	          if(rs.next()) {
	        	  SessionId = rs.getInt(1);
	          }
	        } 
	      }
	    } catch (SQLException e) {
	      System.out.println("Error executing SQL query in IsIdExistsForLogin method");
	      e.printStackTrace();
	    }
	    return SessionId;
	  }
}
