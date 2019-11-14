package br.com.pedido.itens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedido.itens.entities.PedidoitensEntity;

@Repository
public interface PedidoItensRepository extends JpaRepository<PedidoitensEntity, Long> {

}
