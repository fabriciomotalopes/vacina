package br.com.engenhariareversa.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.engenhariareversa.dao.UsuarioDAO;
import br.com.engenhariareversa.domain.Usuario;
import br.com.engenhariareversa.util.FacesUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuarioCadastrar;
	private List<Usuario> usuarios;
	private List<Usuario> usuariosFilter;
	
	private String acao = "Novo";
	private Long codigo;

	public Usuario getUsuarioCadastrar() {
		return usuarioCadastrar;
	}

	public void setUsuarioCadastrar(Usuario usuarioCadastrar) {
		this.usuarioCadastrar = usuarioCadastrar;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosFilter() {
		return usuariosFilter;
	}

	public void setUsuariosFilter(List<Usuario> usuariosFilter) {
		this.usuariosFilter = usuariosFilter;
	}
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void salvar() {

		try {

			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuarioCadastrar);

			usuarioCadastrar = new Usuario();

			FacesUtil.adicionarMsgInfo("Usuário Cadastrado com Sucesso!");

		} catch (RuntimeException ex) {

			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar Cadastrar um Usuário: " + ex.getMessage());

		}

	}
	
	public void editar() {

		try {

			UsuarioDAO dao = new UsuarioDAO();
			dao.editar(usuarioCadastrar);

			usuarioCadastrar = new Usuario();

			FacesUtil.adicionarMsgInfo("Usuário Editado com Sucesso!");

		} catch (RuntimeException ex) {

			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar Editar um Usuário: " + ex.getMessage());

		}

	}

	public void listar() {

		try {

			UsuarioDAO dao = new UsuarioDAO();
			usuarios = dao.listar();

		} catch (RuntimeException ex) {

			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar listar os Usuário: " + ex.getMessage());

		}
	}

	public void carregarCadastro() {
		try {
			
			if (codigo != null) {				
				UsuarioDAO dao = new UsuarioDAO();
				usuarioCadastrar = dao.buscarPorId(codigo);
				
			}else {
				usuarioCadastrar = new Usuario();
			}

		} catch (RuntimeException ex) {

			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar obter os dados do Usuário: " + ex.getMessage());

		}
	}
	
	public String excluir() {

		try {

			UsuarioDAO dao = new UsuarioDAO();
			dao.excluir(usuarioCadastrar);

			FacesUtil.adicionarMsgInfo("Usuário Removido com Sucesso!");

		} catch (RuntimeException ex) {

			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar Remover um Usuário: " + ex.getMessage());

		}
		return "/usuarioListar.xhtml?faces-redirect=true";
	}

}
