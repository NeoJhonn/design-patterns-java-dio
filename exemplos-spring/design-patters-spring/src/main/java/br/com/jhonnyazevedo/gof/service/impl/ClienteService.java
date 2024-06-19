package br.com.jhonnyazevedo.gof.service.impl;

import br.com.jhonnyazevedo.gof.Repository.ClienteRepository;
import br.com.jhonnyazevedo.gof.Repository.EnderecoRepository;
import br.com.jhonnyazevedo.gof.model.Cliente;
import br.com.jhonnyazevedo.gof.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(UUID id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(UUID id, Cliente cliente) {

    }

    @Override
    public void excluir(UUID id) {

    }
}
