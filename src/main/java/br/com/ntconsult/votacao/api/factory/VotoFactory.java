package br.com.ntconsult.votacao.api.factory;

import org.springframework.stereotype.Component;

import br.com.ntconsult.votacao.api.model.Voto;
import br.com.ntconsult.votacao.api.model.vo.VotoVO;

@Component
public class VotoFactory {

	public Voto create(VotoVO vo) {
		Voto voto = new Voto(vo.getPautaID(), vo.getVoto(), vo.getAssociadoID());
		return voto;
	}

}
