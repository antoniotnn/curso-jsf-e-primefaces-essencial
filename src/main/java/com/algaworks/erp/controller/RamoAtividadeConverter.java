package com.algaworks.erp.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.algaworks.erp.model.RamoAtividade;

//@FacesConverter(forClass = RamoAtividade.class)  fazer assim para não precisar chamar o atributo converter="nomeDoConversor" na view .xhtml
//@FacesConverter("ramoAtividadeConverter")
public class RamoAtividadeConverter implements Converter {
	
	private List<RamoAtividade> listaRamoAtividades;
	
	public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividades) {
		this.listaRamoAtividades = listaRamoAtividades;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		Long id = Long.valueOf(value);
		
		return listaRamoAtividades.stream()
			.filter(ramoAtividade -> id.equals(ramoAtividade.getId()))
			.findFirst().orElse(null);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		RamoAtividade ramoAtividade = (RamoAtividade) value;
		
		return ramoAtividade.getId().toString();
	}

}
