package com.atividade.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.main.model.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	
}
