package br.com.ntconsult.votacao.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ntconsult.votacao.api.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

	boolean existsByAssociadoAndPauta(Long associado, Long pauta);

	@Query("select count(*) from Voto v where v.voto = 1 and v.pauta =:pauta")
	int qtdVotosSim(Long pauta);

	@Query("select count(*) from Voto v where v.voto = 0 and v.pauta =:pauta")
	int qtdVotosNao(Long pauta);

}
