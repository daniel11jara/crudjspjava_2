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
			Class.forName("com.mysql.cj.jdbc.Driver");
			//passando o endereço de conexao -- usuario -- senha
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjspjava_2" , "root", "admin");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return conn;
		
	}
	
	
	//aula 06 - salvar usuario
	public static int salvarUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into usuario2 (nome, password, email, sexo, pais) values (?, ?, ?, ?, ?)");
			
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}

	
	
	//aula 04 - metodo para pegar o ID
	public static Usuario getRegistroById(int id) {
		
		Usuario usuario = null;
		
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from usuario2 where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return usuario;
	}
	
	//aula 02 - metodo para listar os usuarios - viewusuario.jsp
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
	
	//aula 05 - atualizando usuario - editform.jsp
	public static int updateUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con  = getConnection();
			PreparedStatement ps = con.prepareStatement("update usuario2 set nome = ?, password = ?, email= ?, sexo=?, pais=?, where id=?");
			//ResultSet rs = ps.executeQuery();
			
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			ps.setInt(6, u.getId());
			
			status = ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}

}
