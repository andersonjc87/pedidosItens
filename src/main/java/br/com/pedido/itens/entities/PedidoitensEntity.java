package br.com.pedido.itens.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "pedidoItens")
@Entity
public class PedidoitensEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idItem")
    private Long idItem;

    @Column(name = "idPedido")
    private Long idPedido;

    @Column(name = "idProduto")
    private Long idProduto;

    @Column(name = "produto")
    private String produto;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PedidoitensEntity [idItem=");
        builder.append(idItem);
        builder.append(", idPedido=");
        builder.append(idPedido);
        builder.append(", idProduto=");
        builder.append(idProduto);
        builder.append(", produto=");
        builder.append(produto);
        builder.append(", quantidade=");
        builder.append(quantidade);
        builder.append(", valor=");
        builder.append(valor);
        builder.append(", subtotal=");
        builder.append(subtotal);
        builder.append("]");
        return builder.toString();
    }

}
