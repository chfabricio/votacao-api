package br.com.ntconsult.votacao.api.model.vo;

import lombok.Data;

@Data
public class VotoVO {
	private Long pautaID;
	private Long associadoID;
	private int voto;
}
