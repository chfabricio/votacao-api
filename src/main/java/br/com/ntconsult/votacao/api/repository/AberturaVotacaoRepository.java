package br.com.ntconsult.votacao.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ntconsult.votacao.api.model.AberturaVotacao;
import br.com.ntconsult.votacao.api.model.Pauta;

@Repository
public interface AberturaVotacaoRepository extends JpaRepository<AberturaVotacao, Long> {

	AberturaVotacao findByPauta(Pauta pauta);
	
	@Query("select votacao from AberturaVotacao votacao where votacao.fim is null ")
	List<AberturaVotacao> obterVotacoesAbertas();

	boolean existsByPauta(Pauta pauta);
	
	
	
}
