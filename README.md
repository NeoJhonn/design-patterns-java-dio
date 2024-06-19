# Design Patterns(Padrões de Projeto)

- São soluções consolidadas para problemas recorrentes no desenvolvimento e manutenção de software orientado a objetos.

- O livro Design Patterns: Elements of Reusable Object-Oriented Software (1995) é a principal referência sobre o tema, a qual tornou 
os autores Gamma, Helm, Johnson e Vlissides conhecidos como “Gang of Four” (GoF).

- São comumente classificados nas seguintes categorias:
  - Padrões Criacionais: Abstract Factory, Builder, Factory Method, Prototype, Singleton.
  - Padrões Comportamentais: Chain of Responsibility, Iterator, Observer, Strategy, Template Method.
  - Padrões Estruturais: Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy.

## Singleton

- Permitir a criação de uma única instância de uma classe e fornecer um modo para recuperá-la.


## Strategy

- Simplificar a variação de algoritmos para a resolução de um mesmo problema.


## Facade

- Prover uma interface que reduza a complexidade nas integrações com subsistemas.

# Spring Framework

- Singleton: @Bean e @Autowired.


- Strategy: @Service e @Repository.


- Facade: construção de uma API REST. Integrações: Spring Data JPA e ViaCEP API(Feig).


- Criar um projeto no spring initializr com as seguintes dependências: Spring Web, Spring Data JPA, PostgresSQL Driver, Lombok 
e o OpenFeign.

- Adicionar documentação com Swagger manualmente no pom:

```
<!-- Documentação no Swagger -->
<dependency>
       <groupId>org.springdoc</groupId>
       <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
       <version>2.2.0</version>
</dependency>

// Configurações no arquivo application.properties

## Endpoint JSON documentação do Swagger
springdoc.api-docs.path=/api-docs
## Para acessar o Swagger UI(página html): http://localhost:8080/swagger-ui/index.html
```

- OpenFeign: cliente REST declarativo, onde você consegue criar um client HTTP para consumir Api externas de uma maneira mais simples.

- Para habilitar o OpenFeign adicione a notação @EnableFeignClients na classe que contenha o seu método main:

```
@EnableFeignClients  <--------------------
@SpringBootApplication
public class DesignPattersSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPattersSpringApplication.class, args);
	}
}
```

- Para consumir uma Api usando o OpenFeign crie uma interface e configure da seguinte forma:

```
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws") <------------------------------
public interface ViaCepService {

    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/") <---------------------
    Endereco consultarCep(@PathVariable("cep") String cep);
}
```

































