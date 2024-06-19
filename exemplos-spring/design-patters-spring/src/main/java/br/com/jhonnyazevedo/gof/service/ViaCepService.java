package br.com.jhonnyazevedo.gof.service;


import br.com.jhonnyazevedo.gof.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Cliente HTTP criado a partir da interface <b>OpenFeign</b> para consume da API do <b>ViaCEP</b>.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring CLoud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author NeoJhon
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")// endereço base da api
public interface ViaCepService {

    @GetMapping("/{cep}/json/") // continuação do endereço com o path variable
    Endereco consultarCep(@PathVariable("cep") String cep);
}
