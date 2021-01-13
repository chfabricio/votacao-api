package br.com.ntconsult.votacao.api.factory;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.ntconsult.votacao.api.model.AberturaVotacao;
import br.com.ntconsult.votacao.api.model.Pauta;
import br.com.ntconsult.votacao.api.model.vo.AberturaVotacaoVO;

@Component
public class AberturaVotacaoFactory {

	public AberturaVotacao create(AberturaVotacaoVO vo) {
		AberturaVotacao abertura = new AberturaVotacao(LocalDateTime.now(), new Pauta(vo.getPautaID()));
		return abertura;

	}

}
