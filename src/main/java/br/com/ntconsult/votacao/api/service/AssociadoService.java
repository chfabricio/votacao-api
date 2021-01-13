package br.com.ntconsult.votacao.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import br.com.ntconsult.votacao.api.factory.AssociadoFactory;
import br.com.ntconsult.votacao.api.model.Associado;
import br.com.ntconsult.votacao.api.model.vo.AssociadoVO;
import br.com.ntconsult.votacao.api.repository.AssociadoRepository;
import br.com.ntconsult.votacao.api.service.exception.DomainException;
import br.com.ntconsult.votacao.api.service.exception.IntegracaoException;

@Service
public class AssociadoService extends ServiceBase {

	@Autowired
	private AssociadoFactory factory;

	@Autowired
	private AssociadoRepository repository;

	public void criar(AssociadoVO request) {

		try {
			if (repository.existsByCpf(request.getCpf()))
				throw new DomainException("Associado já cadastrado!");
		
			validarCpfAssociado(request.getCpf());
			repository.save(factory.create(request));
		} catch (IntegracaoException e) {
			throw new IntegracaoException(e.getMessage());
		} catch (Exception e) {
			throw new DomainException(e.getMessage());
		}

	}

	public void validarCpfAssociado(String cpf) {
		String status = "";
		try {
			status = restTemplate.getForObject(configBean.getUrlValidarCpf(cpf), String.class);
		} catch (Exception e) {
			HttpStatusCodeException httpStatusCodeException = (HttpStatusCodeException) e;
			if (HttpStatus.NOT_FOUND.equals(httpStatusCodeException.getStatusCode())) {
				throw new IntegracaoException("Cpf inválido!");
			}
			throw new IntegracaoException("Serviço indisponível! Por favor, tente mais tarde.");
		}

		if (status.contains("UNABLE"))
			throw new IntegracaoException("Associado não está habilitado para votar.");

	}

	public Associado obterAssociado(Long associadoID) {
		if (!repository.findById(associadoID).isPresent())
			throw new DomainException("Associado não cadastrado!");
		return repository.findById(associadoID).get();
	}

}
