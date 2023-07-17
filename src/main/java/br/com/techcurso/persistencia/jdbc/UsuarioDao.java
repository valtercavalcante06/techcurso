package br.com.techcurso.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.techcurso.entidade.Usuario;

public class UsuarioDao {

	public void cadastrar(Usuario usu) {
		Connection con = ConectionFactory.getConnection();
		// TODO Auto-generated method stub
		String sql ="insert into usuario (nome, login, senha) values (?,?,?)";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.execute();
			System.out.println("Cadastrado com sucesso");
		} catch(SQLException e){
			e.printStackTrace();	
		}
		
	}

	public void alterar(Usuario usu) {
		Connection con = ConectionFactory.getConnection();
		// TODO Auto-generated method stub
		String sql ="update usuario set nome=?, login=?, senha=? where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			
			preparador.execute();
			System.out.println("Cadastro realizado com sucesso!");
		} catch(SQLException e){
			e.printStackTrace();		
			
		}
		
	}

	public void deletar(Usuario usu) {
		Connection con = ConectionFactory.getConnection();
		// TODO Auto-generated method stub
		String sql ="Delete from usuario where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
				
			preparador.setInt(1, usu.getId());
			preparador.execute();
			System.out.println("Cadastro excluído com sucesso!");
			
		} catch(SQLException e){
			e.printStackTrace();		
		}
		
	}

}
