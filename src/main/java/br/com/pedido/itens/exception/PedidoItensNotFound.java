package br.com.pedido.itens.exception;

public class PedidoItensNotFound extends Exception {

    private static final long serialVersionUID = 1L;

    public PedidoItensNotFound(String msg) {
        super(msg);
    }

    public PedidoItensNotFound(String msg, Throwable cause) {
        super(msg, cause);
    }

}
