package com.algaworks.erp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ramo_atividade") //somente a anotação acima, Entity, já é suficiente para indicar que existe uma tabela RamoAtividade no banco de dados, porém se quiser especificar o nome da tabela e usar o padrão de sgbds que é nome_alguma_coisa, é sugestivel de usar a anotação @Table
public class RamoAtividade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//@Column(name = "ramo_atividade_id") se quiser especificar o nome da coluna ao qual o atributo se refere, no banco basta usar essa anotação.
	@Id //essa anotação indica ao Hibernate que esse atributo refere-se a Primary Key no banco de dados.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // serve para o Hibernate delegar ao banco de dados, no caso o MySQL a missão de  controlar a sequencia de IDS, e que não seja necessário inserir manualmente os IDS
	private Long id;
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RamoAtividade other = (RamoAtividade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RamoAtividade [id=" + id + "]";
	}
	

}
