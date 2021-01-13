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
@Table(name = "tbvoto")
public class Voto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_voto", sequenceName = "seq_voto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_voto")
	@Column(name = "voto_id")
	private Long id;

	@Column(name = "pauta_id")
	private Long pauta;

	@Column(name = "voto")
	private int voto;

	@Column(name = "associado_id")
	private Long associado;

	public Voto(Long pauta, int voto, Long associado) {
		this.pauta = pauta;
		this.voto = voto;
		this.associado = associado;
	}

	public Voto() {
	
	}

}
