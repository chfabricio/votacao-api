package br.com.ntconsult.votacao.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ntconsult.votacao.api.factory.AberturaVotacaoFactory;
import br.com.ntconsult.votacao.api.model.AberturaVotacao;
import br.com.ntconsult.votacao.api.model.vo.AberturaVotacaoVO;
import br.com.ntconsult.votacao.api.repository.AberturaVotacaoRepository;

@Service
public class VotacaoService {

	@Autowired
	private AberturaVotacaoFactory factory;

	@Autowired
	private AberturaVotacaoRepository repository;

	public void criar(AberturaVotacaoVO vo) {
		repository.save(factory.create(vo));
	}

	public List<AberturaVotacao> obterVotacoesAbertas() {
		return repository.obterVotacoesAbertas();
	}
	
	public void encerrar(AberturaVotacao aberturaVotacao) {
		aberturaVotacao.encerrar();
		repository.save(aberturaVotacao);
	}

}
