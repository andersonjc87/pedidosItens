package br.com.pedido.itens.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedido.itens.body.PedidoItens;
import br.com.pedido.itens.entities.PedidoitensEntity;
import br.com.pedido.itens.exception.PedidoItensNotFound;
import br.com.pedido.itens.services.PedidoItensService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "brasilPrev")
public final class PedidoItensResource {

    @Autowired
    private PedidoItensService service;

    @ResponseBody
    @ApiOperation(value = "Busca por todos os Itens")
    @GetMapping(path = "/pedidoItens")
    public ResponseEntity<?> getAll(Pageable pageable) {

        Page<PedidoitensEntity> pedidoItens = service.getAll(pageable);

        if (pedidoItens == null) {
            return (ResponseEntity<?>) ResponseEntity.noContent();
        }
        return ResponseEntity.ok(pedidoItens);

    }

    @ResponseBody
    @ApiOperation(value = "Busca por id de item")
    @GetMapping(path = "/pedidoItens/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {

        PedidoitensEntity pedidoItens = service.get(id);

        if (pedidoItens == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidoItens);

    }

    @RequestBody
    @ApiOperation(value = "novo pedido")
    @PostMapping(path = "/pedidoItens/novo")
    public ResponseEntity<?> post(PedidoItens rangeBins) {

        try {
            return ResponseEntity.ok(service.insert(rangeBins));

        } catch (Exception e) {

            return ResponseEntity.status(500).build();
        }

    }

    @RequestBody
    @ApiOperation(value = "Atualizar pedido")
    @PutMapping(path = "/pedidoItens/{id}")
    public ResponseEntity<?> put(@PathVariable("id") Long id, PedidoItens pedidoItens) {

        PedidoitensEntity Entity = service.get(id);

        try {
            return ResponseEntity.ok(service.update(Entity));

        } catch (Exception e) {

            return ResponseEntity.status(500).build();
        }

    }

    @RequestBody
    @ApiOperation(value = "excluir pedido Item")
    @DeleteMapping(path = "/pedidoItens/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.status(200).build();
        } catch (PedidoItensNotFound e) {
            return ResponseEntity.noContent().build();
        }
    }

}
