package br.com.ntconsult.votacao.api.model;

import java.io.Serializable;

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
@Table(name = "tbpauta")
public class Pauta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_pauta", sequenceName = "seq_pauta", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pauta")
	@Column(name = "pauta_id")
	private Long id;

	@Column(name = "descricao")
	private String descricao;

	public Pauta(String descricao) {
		this.descricao = descricao;
	}

	public Pauta(Long id) {
		this.id = id;
	}

	public Pauta() {

	}
}
