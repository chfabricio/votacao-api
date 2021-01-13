package br.com.ntconsult.votacao.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ntconsult.votacao.api.factory.VotoFactory;
import br.com.ntconsult.votacao.api.model.AberturaVotacao;
import br.com.ntconsult.votacao.api.model.Associado;
import br.com.ntconsult.votacao.api.model.Pauta;
import br.com.ntconsult.votacao.api.model.vo.VotoVO;
import br.com.ntconsult.votacao.api.repository.AberturaVotacaoRepository;
import br.com.ntconsult.votacao.api.repository.VotoRepository;
import br.com.ntconsult.votacao.api.service.exception.DomainException;

@Service
public class VotoService {

	@Autowired
	private AberturaVotacaoRepository aberturaRepository;

	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private VotoFactory factory;

	@Autowired
	private AssociadoService associadoService;

	public void criar(VotoVO request) {
		validarDados(request);
		votoRepository.save(factory.create(request));
	}

	private void validarDados(VotoVO request) {

		Associado associado = associadoService.obterAssociado(request.getAssociadoID());
		associadoService.validarCpfAssociado(associado.getCpf());

		if (!aberturaRepository.existsByPauta(new Pauta(request.getPautaID()))) {
			throw new DomainException("Pauta não cadastrada!");
		}
		if (isEncerrada(request.getPautaID())) {
			throw new DomainException("Pauta encerrada!");
		}
		if (associadoJaVotou(request.getAssociadoID(), request.getPautaID())) {
			throw new DomainException("Associado já votou!");
		}

	}

	private boolean isEncerrada(Long pautaID) {
		AberturaVotacao abertura = aberturaRepository.findByPauta(new Pauta(pautaID));
		return abertura.isEncerrada();
	}

	private boolean associadoJaVotou(Long associadoID, Long pautaID) {
		return votoRepository.existsByAssociadoAndPauta(associadoID, pautaID);
	}

	public int qtdVotosSim(Long pautaID) {
		return votoRepository.qtdVotosSim(pautaID);

	}

	public int qtdVotosNao(Long pautaID) {
		return votoRepository.qtdVotosNao(pautaID);
	}

}
