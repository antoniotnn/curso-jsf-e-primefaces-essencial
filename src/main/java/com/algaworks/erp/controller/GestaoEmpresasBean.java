package com.algaworks.erp.controller;

import java.io.Serializable;

import javax.enterprise.inject.New;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;

@ViewScoped
@Named
public class GestaoEmpresasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Empresa empresa = new Empresa();
	
	public void salvar() {
		System.out.println("Razão Social: " + empresa.getRazaoSocial()
				+ " - Nome Fantasia: " + empresa.getNomeFantasia()
				+ " - Tipo: " + empresa.getTipo());
	}
	
	public String ajuda() {
		System.out.println("Chegamos até aqui");
		return "AjudaGestaoEmpresas?faces-redirect=true";
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}

}
