package br.com.engenhariareversa.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.engenhariareversa.dao.UsuarioDAO;
import br.com.engenhariareversa.domain.Usuario;

public class UsuarioDAOTest {

	@Ignore
	@Test
	public void salvar() {
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario us1 = new Usuario();

		us1.setCpf("12345678912");
		us1.setEmail("fabricio4@gmail.com");
		us1.setEndereco("rua do topografo, 68");
		us1.setNome("Fabricio");
		us1.setSenha("123456");	

		dao.salvar(us1);

	}

	@Ignore
	@Test	
	public void litar() {

		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.listar();

		for (Usuario usuario : usuarios) {
			System.out.println(usuario.toString());
		}
	}
	
	@Ignore
	@Test
	public void buscarPorId() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarPorId(4L);
		System.out.println(usuario.toString());
	}

	@Ignore
	@Test
	public void excluir() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarPorId(4L);

		if (usuario == null) {
			dao.excluir(usuario);
		}
	}
		
	@Test
	public void editar() {
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario us1 = dao.buscarPorId(1L);
		
		us1.setCpf("12345678912");
		us1.setEmail("fabricio1@gmail.com");
		us1.setEndereco("rua do topografo, 68");
		us1.setNome("Fabricio");
		us1.setSenha("123456");		

		dao.editar(us1);

	}
}
