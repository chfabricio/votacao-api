package br.com.ntconsult.votacao.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ntconsult.votacao.api.factory.PautaFactory;
import br.com.ntconsult.votacao.api.model.vo.PautaVO;
import br.com.ntconsult.votacao.api.repository.PautaRepository;
import br.com.ntconsult.votacao.api.service.exception.DomainException;

@Service
public class PautaService {
	
	@Autowired
	private PautaFactory factory;
	
	@Autowired
	private PautaRepository repository;
	
	public void criar(PautaVO request) {
		if(repository.existsByDescricao(request.getDescricao()))
			 throw new DomainException("Pauta já cadastrada!");
		
		repository.save(factory.create(request));
	}

}
