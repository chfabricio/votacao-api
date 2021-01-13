package br.com.ntconsult.votacao.api.factory;

import org.springframework.stereotype.Component;

import br.com.ntconsult.votacao.api.model.Associado;
import br.com.ntconsult.votacao.api.model.vo.AssociadoVO;

@Component
public class AssociadoFactory {

	public Associado create(AssociadoVO vo) {
		Associado associado = new Associado(vo.getNome(), vo.getCpf());
		return associado;
	}

}
