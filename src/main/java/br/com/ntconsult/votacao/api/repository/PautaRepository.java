package br.com.ntconsult.votacao.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ntconsult.votacao.api.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>{
	
	boolean existsByDescricao(String descricao);

}
