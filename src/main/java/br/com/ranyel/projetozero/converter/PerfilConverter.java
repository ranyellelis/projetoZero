package br.com.ranyel.projetozero.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.ranyel.projetozero.domain.Perfil;

@FacesConverter(forClass=Perfil.class,value= "perfilConverter")
public class PerfilConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent cpn, String str) {
		Perfil perfil = (Perfil) ctx.getExternalContext().getSessionMap().get("objPerfil-"+ str);
		return perfil;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent cpn, Object obj) {
		if (obj instanceof Perfil) {
			Perfil perfil = (Perfil) obj;
			if (perfil.getId() != null) {
				ctx.getExternalContext().getSessionMap().put("objPerfil-" + perfil.getId(), obj);
				return String.valueOf(perfil.getId());
			} else {
				return null;
			}
		}
		return null;
	}

}
