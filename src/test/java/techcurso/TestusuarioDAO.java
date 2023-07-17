package techcurso;

import java.util.List;

import br.com.techcurso.entidade.Usuario;
import br.com.techcurso.persistencia.jdbc.UsuarioDao;

public class TestusuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testCadastrar();
		testAutenticar("joao","12345s");
	}
	public static void testCadastrar() {
		
		//Criando o usuário
		Usuario usu = new Usuario();
		
		usu.setNome("Joao Lucas");
		usu.setLogin("joao");
		usu.setSenha("1235s");
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
	
	public static void testSalvar() {
		Usuario usu = new Usuario();
		usu.setNome("Carminha Lucia Lima");
		usu.setLogin("carminha_l");
		usu.setSenha("123");
		usu.setId(4);
		UsuarioDao usuDao = new UsuarioDao();
		
		usuDao.salvar(usu);
	}
	public static void testBuscarId(int id) {
		Usuario usu = new Usuario();
		
		UsuarioDao usuDao = new UsuarioDao();
		usu = usuDao.buscaporid(id);
		if (usu != null) {
			System.out.println(usu);
		} else {
			System.out.println("usuário não encontrado");
		}
		
	}
	public static void testBuscarTodos() {
		UsuarioDao usuDao = new UsuarioDao();
		List<Usuario> usu = usuDao.buscaportodos();
		
		for (Usuario u: usu) {
			System.out.println(u);
		}
		
	}
	public static void testAutenticar(String login, String senha) {
		UsuarioDao usuDao = new UsuarioDao();
		
		Usuario usu =  new Usuario();
		
		usu.setLogin(login);
		usu.setSenha(senha);
		
		if (usuDao.autenticar(usu)==null) {
			System.out.println("Usuário não encontrado");
		}
		else {
			System.out.println("Usuário Autenticado");
		}
	}
	
}
