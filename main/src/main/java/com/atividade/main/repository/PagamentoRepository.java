package com.atividade.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.main.model.Endereco;
import com.atividade.main.model.Pagamento;



@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
	
	

	
}
