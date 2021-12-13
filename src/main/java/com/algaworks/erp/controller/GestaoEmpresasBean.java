package com.algaworks.erp.controller;

import java.io.Serializable;

//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


//@RequestScoped // ciclo de vida inicia no momento de início da requisição, e termina ao fim da requisição
//@SessionScoped // ciclo de vida inicia na abertura da sessão, e termina no seu encerramento (sessão)
//@ApplicationScoped // escopo que permite apenas e sempre uma instância, pois é a nível de aplicação um todo. Ciclo de vida durante TODA a aplicaçã.
@ViewScoped // (mais utilizado) clico de vida inicia no momento que a página (view) é carregada e termina quando a sessão termina, ou termina antes que a sessão termina quando a navegação é feita dentro de algum outcoming dentro do JSF. Esse escopo devido a ter maior vida, é passível de ser Serializado, então somente anotar a classe com ViewScoped causará erros. Devemos então implementar a interface serializable
@Named
public class GestaoEmpresasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Integer NUMERO = 0;

	public GestaoEmpresasBean() {
		NUMERO++;
	}
	
	public Integer getNUMERO() {
		return NUMERO;
	}

}
