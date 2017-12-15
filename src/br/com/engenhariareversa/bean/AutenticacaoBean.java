package br.com.engenhariareversa.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.engenhariareversa.dao.UsuarioDAO;
import br.com.engenhariareversa.domain.Usuario;
import br.com.engenhariareversa.util.FacesUtil;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	
	private Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		if(usuarioLogado == null){
			usuarioLogado = new Usuario();
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public String autenticar(){
		try {
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado = usuarioDAO.autenticar(usuarioLogado.getCpf(), usuarioLogado.getSenha());
			
			if(usuarioLogado == null){
				FacesUtil.adicionarMsgErro("CPF e/ou senha inválidos.");
				return null;
			}else{
				FacesUtil.adicionarMsgInfo("Usuário autenticado com sucesso.");
				return "/principal.xhtml?faces-redirect=true";
			}
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar autenticar no sistema: " + ex.getMessage());
			return null;
		}
	}
	
	public String sair(){
		usuarioLogado = null;	
		return "/index.xhtml?faces-redirect=true";
	}
	
	

}
