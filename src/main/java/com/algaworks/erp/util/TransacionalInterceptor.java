package com.algaworks.erp.util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor //anotação do CDI que indica que essa classe é um interceptador 
@Transacional // marcando interceptador para indicar o CDI que as classes e/ou métodos anotados com essa anotação devem ser interceptados
@Priority(Interceptor.Priority.APPLICATION) // serve para ativer o interceptador com prioridade de Aplicação, sem essa anotação o beans.xml deveria ser preenchido.
public class TransacionalInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	//método interceptador, todo método anotado com @Transacional, no momento q ele for invocado, este será interceptado pelo método abaixo:
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction trx = manager.getTransaction();
		boolean criador = false;

		try {
			if (!trx.isActive()) {
				// truque para fazer rollback no que já passou
				// (senão, um futuro commit confirmaria até mesmo operações sem transação) , necessário para não bagunçar com outras transações que possam estar sendo executadas, fora dessa interceptada. Pode acontecer se um EntityManger for chamado sem a anotar a classe ou método com @Transacional
				trx.begin();
				trx.rollback();

				// agora sim inicia a transação
				trx.begin();

				criador = true;
			}

			return context.proceed();
		} catch (Exception e) {
			if (trx != null && criador) {
				trx.rollback();
			}

			throw e;
		} finally {
			if (trx != null && trx.isActive() && criador) {
				trx.commit();
			}
		}
	}

}