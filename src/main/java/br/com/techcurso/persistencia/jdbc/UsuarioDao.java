package br.com.techcurso.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("Usuário alterado com sucess!");
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
	public void salvar(Usuario usu) {
		if (usu.getId()!= null && usu.getId()>0) {
			alterar(usu);
		}
		else {
			cadastrar(usu);
		}		
	}
	/**
	 * Busca de um registro no banco de dados pelo id do usuário
	 * @param id é um inteiro que representa o número do id do usuário
	 * @return um objeto usuário quando encontra ou null quando não encontra
	 */
	public Usuario buscaporid(int id) {
		Connection con = ConectionFactory.getConnection();
		String sql ="Select * from usuario where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				return usu;
			}
			
		} catch(SQLException e){
			e.printStackTrace();		
		}
		return null;
	}
	
	/**
	 * Realiza a busca de todos os registros da tabela usuário
	 * @return lista de objetos usuário, contendo 0 elementos ou n elementos quando encontrar
	 */
	public List<Usuario> buscaportodos() {
		Connection con = ConectionFactory.getConnection();
		String sql ="Select * from usuario";
		List<Usuario> lista_usuario = new ArrayList<Usuario>();
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				lista_usuario.add(usu);
			}			
			
			
		} catch(SQLException e){
			e.printStackTrace();		
		}
		return lista_usuario;
	}
	public Usuario autenticar(Usuario usu) {
		Connection con = ConectionFactory.getConnection();
		String sql ="Select * from usuario where login=? and senha=?";
		
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
					
			preparador.setString(1, usu.getLogin());
			preparador.setString(2, usu.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				return usuario;
			}			
			
			
		} catch(SQLException e){
			e.printStackTrace();		
		}
		return null;
	}
}
