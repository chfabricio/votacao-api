package br.com.ntconsult.votacao.api.model.enums;

import lombok.Getter;

public enum ResultadoEnum {

	APROVADO("Aprovado"), NAO_APROVADO("Não aprovado"), EMPATE("Empate");

	private @Getter String descricao;

	private ResultadoEnum(String desc) {
		this.descricao = desc;
	}
}
