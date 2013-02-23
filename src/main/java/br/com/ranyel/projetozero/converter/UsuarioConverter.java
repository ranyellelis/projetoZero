package br.com.ranyel.projetozero.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.ranyel.projetozero.domain.Usuario;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent cpn, String str) {
		Usuario usuario = (Usuario) ctx.getExternalContext().getSessionMap().get("objUsuario-"+ str);
		return usuario;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent cpn, Object obj) {
		if (obj instanceof Usuario) {
			Usuario usuario = (Usuario) obj;
			if (usuario.getId() != null) {
				ctx.getExternalContext().getSessionMap().put("objUsuario-" + usuario.getId(), obj);
				return String.valueOf(usuario.getId());
			} else {
				return null;
			}
		}
		return null;
	}
}
