package br.com.pedido.itens.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pedido.itens.body.PedidoItens;
import br.com.pedido.itens.entities.PedidoitensEntity;
import br.com.pedido.itens.exception.PedidoItensNotFound;
import br.com.pedido.itens.repositories.PedidoItensRepository;

@Service
public class PedidoItensService {

    @Autowired
    private PedidoItensRepository repository;

    public Page<PedidoitensEntity> getAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

    public PedidoitensEntity get(Long idPedidoItens) {
        Optional<PedidoitensEntity> subEmitterOp = repository.findById(idPedidoItens);

        if (subEmitterOp.isPresent()) {
            return subEmitterOp.get();
        }

        return null;
    }

    public PedidoitensEntity insert(PedidoItens pedidoItens) {
        return this.repository.save(convertToEntity(pedidoItens));
    }

    public Object update(PedidoitensEntity entity) {
        return this.repository.save(entity);

    }

    public PedidoitensEntity convertToEntity(PedidoItens pedidoItens) {

        PedidoitensEntity entity = new PedidoitensEntity();

        entity.setIdItem(pedidoItens.getIdItem());
        entity.setIdPedido(pedidoItens.getIdPedido());
        entity.setIdProduto(pedidoItens.getIdProduto());
        entity.setProduto(pedidoItens.getProduto());
        entity.setQuantidade(pedidoItens.getQuantidade());
        entity.setValor(pedidoItens.getValor());
        entity.setSubtotal(pedidoItens.getSubTotal());

        return entity;
    }

    public void delete(Long id) throws PedidoItensNotFound {

        Optional<PedidoitensEntity> entityOp = repository.findById(id);

        if (entityOp.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new PedidoItensNotFound("Range Bins not found");
        }

    }

}