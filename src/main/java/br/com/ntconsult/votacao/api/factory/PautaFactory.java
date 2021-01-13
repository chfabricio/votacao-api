package br.com.ntconsult.votacao.api.factory;

import org.springframework.stereotype.Component;

import br.com.ntconsult.votacao.api.model.Pauta;
import br.com.ntconsult.votacao.api.model.vo.PautaVO;

@Component
public class PautaFactory {
	
	public Pauta create(PautaVO vo) {
		Pauta pauta = new Pauta(vo.getDescricao());
		return pauta;
	}

}
