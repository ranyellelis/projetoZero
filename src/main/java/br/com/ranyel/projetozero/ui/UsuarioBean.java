package br.com.ranyel.projetozero.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import br.com.ranyel.projetozero.domain.Perfil;
import br.com.ranyel.projetozero.domain.Usuario;
import br.com.ranyel.projetozero.service.UsuarioService;
import br.com.ranyel.projetozero.utils.FacesUtil;

@Named
@ConversationScoped
public class UsuarioBean implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Conversation conversation;

	@Inject
	private Logger log;

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarioList;
	private DualListModel<Perfil> perfis;
	
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

	/**
	 * Salva um usuário.
	 */
	public void salvarUsuario() {
		try {
			usuarioService.salvar(usuario);
			if(usuario.getId() != null) {
				FacesUtil.addInfoMessage("Alteração realizada com sucesso");
			} else {
				FacesUtil.addInfoMessage("Usuário cadastrado com sucesso");
			}
		} catch (Exception e) {
			log.log(Level.SEVERE,
					"Erro ao salvar novo usuário: " + e.getMessage());
			FacesUtil.addErrorMessage("Erro ao salvar novo usuário");
		}
		setUsuario(new Usuario());
		setPerfis(null);
	}
	
	/**
	 * Pesquisar um usuário.
	 */
	public void pesquisarUsuario() {
		beginConversation();
		try {
			setUsuarioList(usuarioService.pesquisarTodosUsuarios());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			FacesUtil.addErrorMessage("Erro ao pesquisar usuário");
		}
	}
	
	/**
	 * Editar um usuário.
	 * @param usuario usuário.
	 */
	public void editarUsuario(Usuario usuario) {
		try {
			setUsuario(usuario);
			setPerfis(null);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			FacesUtil.addErrorMessage("Erro ao preparar usuário para edição");
		}
	}
	
	/**
	 * Excluir um usuário.
	 * @param usuario usuário.
	 */
	public void excluirUsuario(Usuario usuario) {
		try {
			usuarioService.excluirUsuario(usuario);
			getUsuarioList().remove(usuario);
			FacesUtil.addInfoMessage("Usuário excluído com sucesso");
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			FacesUtil.addErrorMessage("Erro ao excluir usuário");
		}
	}

	/**
	 * Busca todos os perfis disponíveis.
	 * @return lista de perfis.
	 */
	public List<Perfil> getPerfisDisponiveis() {
		try {
			return usuarioService.pesquisarTodosPerfis();
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		return Collections.emptyList();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	/**
	 * @return retorna um objeto DualListModel preenchido para ser utilizado com o componente picklist do primefaces.
	 */
	public DualListModel<Perfil> getPerfis() {
		if (perfis == null) {
			List<Perfil> source = getPerfisDisponiveis();
			List<Perfil> target = getUsuario().getPerfilList();
			if (target == null) {
				target = new ArrayList<Perfil>();
			} else {
				for (Perfil p : target) {
					if(source.contains(p)){
						source.remove(p);
					}
				}
			}
			perfis = new DualListModel<Perfil>(source, target);
		}
		return perfis;
	}

	/**
	 * @param perfis - objeto DualListModel utilizado pelo componente picklist do primefaces.
	 */
	public void setPerfis(DualListModel<Perfil> perfis) {
		this.perfis = perfis;
		if(perfis != null && !perfis.getTarget().isEmpty()){
			usuario.setPerfilList(perfis.getTarget());
		}
	}

	public Conversation getConversation() {
		return conversation;
	}
}