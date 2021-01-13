package br.com.ntconsult.votacao.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.ntconsult.votacao.api.kafka.KafkaProducer;
import br.com.ntconsult.votacao.api.model.AberturaVotacao;
import br.com.ntconsult.votacao.api.model.enums.ResultadoEnum;
import br.com.ntconsult.votacao.api.model.vo.ResultadoVO;

@Service
public class NotificaoService {

	@Autowired
	private KafkaProducer kafkaProducer;

	@Autowired
	private VotacaoService votacaoService;

	@Autowired
	private VotoService votoService;

	private ObjectMapper mapper = new ObjectMapper();

	private @Value("${votacao.fecha-em-segundos}") Integer tempoMaximo;

	private Logger log = LogManager.getLogger(getClass());

	@Scheduled(fixedRate = 10000)
	public void notificarFimVotacao() {

		List<AberturaVotacao> votacoes = votacaoService.obterVotacoesAbertas();
		ResultadoVO resultadoVO = new ResultadoVO();

		votacoes.forEach(votacao -> {
			log.info("verificando se votação foi encerrada.");
			if (votacao.isEncerrada(tempoMaximo)) {
				votacaoService.encerrar(votacao);
				log.info("Votação encerrada.");
				notificar(resultadoVO, votacao);
				log.info("O resultado foi enviado para o kafka.");
			}

		});
	}

	private void notificar(ResultadoVO resultadoVO, AberturaVotacao votacao) {

		resultadoVO.setPauta(votacao.getPauta().getDescricao());
		int votosNao = votoService.qtdVotosNao(votacao.getPauta().getId());
		int votosSim = votoService.qtdVotosSim(votacao.getPauta().getId());

		if (votosSim > votosNao)
			resultadoVO.setResultado(ResultadoEnum.APROVADO.getDescricao());

		if (votosSim < votosNao)
			resultadoVO.setResultado(ResultadoEnum.NAO_APROVADO.getDescricao());

		if (votosSim == votosNao)
			resultadoVO.setResultado(ResultadoEnum.EMPATE.getDescricao());

		try {
			String json = mapper.writeValueAsString(resultadoVO);
			kafkaProducer.sendMessage(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
