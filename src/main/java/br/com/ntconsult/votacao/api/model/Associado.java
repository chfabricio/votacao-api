package br.com.ntconsult.votacao.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tbassociado")
public class Associado {

	@Id
	@SequenceGenerator(name = "seq_associado", sequenceName = "seq_associado", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_associado")
	@Column(name = "associado_id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	public Associado(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Associado() {

	}
}
