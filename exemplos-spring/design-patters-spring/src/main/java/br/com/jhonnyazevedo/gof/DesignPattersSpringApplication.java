package br.com.jhonnyazevedo.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Initializr
 * As seguintes dependências foram selecionadas:
 * - Spring Web
 * - Spring Data JPA
 * - PostgresSQL Driver
 * - OpenFeign
 *
 * @author neojhon
 */

@EnableFeignClients // habilita o OpenFeign na sua aplicação
@SpringBootApplication
public class DesignPattersSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPattersSpringApplication.class, args);
	}
}
