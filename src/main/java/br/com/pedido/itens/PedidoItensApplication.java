package br.com.pedido.itens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.pedidosItens")
@EnableAutoConfiguration
public class PedidoItensApplication extends SpringBootServletInitializer {

    public PedidoItensApplication() {
        super();
        setRegisterErrorPageFilter(false); // <- this one
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PedidoItensApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PedidoItensApplication.class, args);
    }

}
