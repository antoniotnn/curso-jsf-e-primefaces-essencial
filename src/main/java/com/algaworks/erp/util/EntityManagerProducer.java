package com.algaworks.erp.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped // Deve sobreviver durante todo o ciclo de vida da aplicação
public class EntityManagerProducer {

	private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("AlgaWorksPU");
	}
	
	@Produces  //toda vez que precisar da instância do entity manager, esse método será chamado
	@RequestScoped //gerenciado a nível de requisição
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
	//ao acabar o ciclo de vida do @RequestScoped, acima, esse metodo logo abaixo é chamado, graças a anotação @Disposes, e assim o EntityManger é fechado.
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}