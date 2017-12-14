package br.com.engenhariareversa.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.engenhariareversa.dao.UsuarioDAO;
import br.com.engenhariareversa.domain.Usuario;
import br.com.engenhariareversa.util.FacesUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	
	private Usuario usuarioCadastrar;

	public Usuario getUsuarioCadastrar() {
		if(usuarioCadastrar == null){
			usuarioCadastrar = new Usuario();
		}
		return usuarioCadastrar;
	}

	public void setUsuarioCadastrar(Usuario usuarioCadastrar) {
		this.usuarioCadastrar = usuarioCadastrar;
	}
	
	public void salvar(){
		
		try{
			
			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuarioCadastrar);
			
			usuarioCadastrar = new Usuario();
			
			FacesUtil.adicionarMsgInfo("Usuário Cadastrado com Sucesso!");
		
		}catch (RuntimeException ex) {
			
			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar Cadastrar um Usuário: "+ ex.getMessage());
		
		}
		
	}
	
	public void listar(){
		
	}
	

}
