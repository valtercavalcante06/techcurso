package techcurso;

import br.com.techcurso.entidade.Usuario;
import br.com.techcurso.persistencia.jdbc.UsuarioDao;

public class TestusuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testCadastrar();
		testDeletar();
	}
	public static void testCadastrar() {
		
		//Criando o usuário
		Usuario usu = new Usuario();
		
		usu.setNome("Joao Lucas");
		usu.setLogin("joao");
		usu.setSenha("1235");
		//Inserindo as informações no banco
		UsuarioDao usuDao = new UsuarioDao();
		
		usuDao.cadastrar(usu);
	}
	
	public static void testAlterar() {
		Usuario usu = new Usuario();
		usu.setId(3);
		usu.setNome("João Lucas Caldas Cavalcante");
		usu.setLogin("jlucas");
		usu.setSenha("123344");
		
		UsuarioDao usuDao = new UsuarioDao();
		
		usuDao.alterar(usu);
	}
	public static void testDeletar() {
		Usuario usu = new Usuario();
		usu.setId(3);
		UsuarioDao usuDao = new UsuarioDao();
		
		usuDao.deletar(usu);
	}
	
}
