package com.crudjspjava_2.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UsuarioDao {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			//passando o driver de conexao
			Class.forName("com.mysql.jdbc.Drive");
			//passando o endereço de conexao -- usuario -- senha
			conn = DriverManager.getConnection("jdbc:mysql//localhost:3306/crusjspjava_2" , "root", "admin");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return conn;
		
	}

}
