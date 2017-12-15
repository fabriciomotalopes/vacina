package br.com.engenhariareversa.util;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

@SuppressWarnings("serial")
public class AutenticacaoPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		String paginaAtual = uiViewRoot.getViewId();

		boolean ehPaginaAutenticacao = paginaAtual.contains("index.xhtml");
		
		System.out.println(ehPaginaAutenticacao);

//		if (!ehPaginaAutenticacao) {
//			ExternalContext externalContext = facesContext.getExternalContext();
//			Map<String, Object> mapa = externalContext.getSessionMap();
//			AutenticacaoBean autenticacaoBean = (AutenticacaoBean) mapa.get("autenticacaoBean");
//
//			Usuario usuario = autenticacaoBean.getUsuarioLogado();
//			
//			if (usuario.getCpf() == null) {
//				
//				javax.faces.application.Application application = facesContext.getApplication();
//				NavigationHandler navigationHandler = application.getNavigationHandler();
//				navigationHandler.handleNavigation(facesContext, null, "index.xhtml?faces-redirect=true");
//			
//			}
//
//		}

	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
