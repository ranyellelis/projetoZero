package br.com.ranyel.projetozero.perfil.ui;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ranyel.projetozero.domain.Perfil;
import br.com.ranyel.projetozero.perfil.service.PerfilService;
import br.com.ranyel.projetozero.utils.FacesUtil;

@Named
@ConversationScoped
public class PerfilBean implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Conversation conversation;

	@Inject
	private Logger log;

	@Inject
	private PerfilService perfilService;

	private Perfil perfil = new Perfil();
	private List<Perfil> perfilList;
	
	@PostConstruct
	public void init(){
		beginConversation();
	}

	/**
	 * Inicia uma conversação longa.
	 */
	private void beginConversation() {
		if (conversation.isTransient()) {
			conversation.begin();
			log.log(Level.INFO, "Conversação iniciada - ID:" + conversation.getId());
		}
	}

	/**
	 * Finaliza uma conversação longa.
	 */
	private void endConversation() {
		if (!conversation.isTransient()) {
			conversation.end();
			log.log(Level.INFO, "Conversação encerrada - ID:" + conversation.getId());
		}
	}
	/*
	 * Salva um perfil.
	 */
	public void salvarPerfil() {
		try {
			perfilService.salvar(perfil);
			if(perfil.getId() != null) {
				FacesUtil.addInfoMessage("Alteração realizada com sucesso");
			} else {
				FacesUtil.addInfoMessage("Perfil cadastrado com sucesso");
			}
		} catch (Exception e) {
			log.log(Level.SEVERE,
					"Erro ao salvar novo perfil: " + e.getMessage());
			FacesUtil.addErrorMessage("Erro ao salvar novo perfil");
		}
		setPerfil(new Perfil());
		setPerfilList(null);
	}
	
	/**
	 * Pesquisar um perfil.
	 */
	public void pesquisarPerfil() {
		beginConversation();
		try {
			setPerfilList(perfilService.pesquisarTodosPerfis());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			FacesUtil.addErrorMessage("Erro ao pesquisar perfil");
		}
	}
	
	/**
	 * Editar um perfil.
	 * @param perfil perfil.
	 */
	public void editarPerfil(Perfil perfil) {
		try {
			setPerfil(perfil);
			setPerfilList(null);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			FacesUtil.addErrorMessage("Erro ao preparar perfil para edição");
		}
	}
	
	/**
	 * Excluir um perfil.
	 * @param perfil perfil.
	 */
	public void excluirPerfil(Perfil perfil) {
		try {
			perfilService.excluirPerfil(perfil);
			getPerfilList().remove(perfil);
			FacesUtil.addInfoMessage("Perfil excluído com sucesso");
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			FacesUtil.addErrorMessage("Erro ao excluir perfil");
		}
	}
	
	/**
	 * @return string voltar.
	 */
	public String voltar(){
		return "/pages/index.xhtml";
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfilList() {
		return perfilList;
	}

	public void setPerfilList(List<Perfil> perfilList) {
		this.perfilList = perfilList;
	}

	public Conversation getConversation() {
		return conversation;
	}
}