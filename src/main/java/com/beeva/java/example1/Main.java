package com.beeva.java.example1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

public class Main {

	public static void main(String[] args) {
		
		//System.out.print("Hola mi nombre es " + args[0] );
		
		String url="jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "toor";
		String query= "Select * from empleado";
		
		try(Connection connection  = DriverManager.getConnection(url, userName, password);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				){
			while(rs.next()){
				System.out.println("*************");
				// Se puede especificar el nombre de campo de la tabla y el tipo de dato, pero de ser uno
				System.out.println("id: " + rs.getInt("id"));
				System.out.println("firstName: " + rs.getString("first_name"));
				System.out.println("lastNAme: " + rs.getString("last_name"));
				System.out.println("age" + rs.getString("age"));
				
			}
			

		}catch(SQLException sql){
			sql.printStackTrace();
		}
				

	}

}
