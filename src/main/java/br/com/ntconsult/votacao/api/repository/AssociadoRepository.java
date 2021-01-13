package br.com.ntconsult.votacao.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ntconsult.votacao.api.model.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>{
	
	boolean existsByCpf(String cpf);

}
