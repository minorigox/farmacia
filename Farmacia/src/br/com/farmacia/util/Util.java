package br.com.farmacia.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {
	
	public static void adicionarMensagemSucesso (String msgs) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msgs, msgs);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, fm);
	}
	
	public static void adicionarMensagemErro (String msgs) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgs, msgs);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, fm);
	}

}
