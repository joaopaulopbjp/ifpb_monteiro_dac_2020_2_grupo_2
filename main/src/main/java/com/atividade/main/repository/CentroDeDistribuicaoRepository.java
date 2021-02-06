package com.atividade.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.main.model.CentroDeDistribuicao;



@Repository
public interface CentroDeDistribuicaoRepository extends JpaRepository<CentroDeDistribuicao, Long>{ 

		
}
