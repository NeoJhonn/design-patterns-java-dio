package br.com.jhonnyazevedo.gof.service;

import br.com.jhonnyazevedo.gof.model.Cliente;

import java.util.UUID;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de Cliente. Com
 * isso, se necessário, podemos ter múltiplas implementações dessa interface.
 *
 * @author Neojhon
 */



public interface IClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(UUID id);

    void inserir(Cliente cliente);

    void atualizar(Cliente cliente) throws Exception;

    void excluir(UUID id);
}
