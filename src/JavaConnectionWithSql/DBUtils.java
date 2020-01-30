/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaConnectionWithSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ajist
 */
    public class DBUtils {
	
	private static Connection conn;
	private static Statement stm;
	
	private static  String username;
	private static  String pass;

	
	public static Connection getConn() {
		return conn;
	}

	public static Statement getStm() {
		return stm;
	}
	
	
	public static boolean createConnection(){
		boolean b=true;
		
		String url="jdbc:mysql://localhost:3306/privateschoolproject?useSSL=false";
		
		
		try{
			conn= DriverManager.getConnection(url,username, pass);
			
			
		}catch(SQLException ex){
			System.out.println("Sql exc");
			b=false;
		}
		return b;
		
	}

	public static String getUsername() {
		return username;
	}

	public static String getPass() {
		return pass;
	}

	public static void setUsername(String username) {
		DBUtils.username = username;
	}

	public static void setPass(String pass) {
		DBUtils.pass = pass;
	}
	
	
	
	
	
	
	
	
	
}
