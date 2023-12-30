package com.crudjspjava_2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava_2.bean.Usuario;

public class UsuarioDao {
	
	public static Connection getConnection() {
		//aula 01
		Connection conn = null;
		
		try {
			//passando o driver de conexao
			Class.forName("com.mysql.cj.jdbc.Drive");
			//passando o endereço de conexao -- usuario -- senha
			conn = DriverManager.getConnection("jdbc:mysql//localhost:3306/crusjspjava_2" , "root", "admin");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return conn;
		
	}
	
	//aula 02 - metodo para listar os usuarios
	public static List<Usuario> getAllUsuarios(){
		
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			
			// 1 - conectando
			Connection conn = getConnection();
			PreparedStatement ps  = conn.prepareStatement("select  * from usuario2");
			ResultSet rs = ps.executeQuery();
			
			// 2 - listando os atributos
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
				
				// 3 - adicionando o usuario na lista 
				list.add(usuario);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
		
	}

}
