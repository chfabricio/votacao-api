package br.com.ntconsult.votacao.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tbabertura_votacao")
public class AberturaVotacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_abertura", sequenceName = "seq_abertura", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_abertura")
	@Column(name = "abertura_id")
	private Long id;

	@Column(name = "inicio")
	private LocalDateTime inicio;

	@Column(name = "fim")
	private LocalDateTime fim;

	@ManyToOne
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;

	public AberturaVotacao(LocalDateTime inicio, Pauta pauta) {
		this.inicio = inicio;
		this.pauta = pauta;
	}

	public boolean isEncerrada() {
		long segundos = ChronoUnit.SECONDS.between(inicio, LocalDateTime.now());
		return (segundos > 300);
	}

	public void encerrar() {
		fim = LocalDateTime.now();
	}

	public AberturaVotacao() {
	}

}
