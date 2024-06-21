package br.com.jhonnyazevedo.gof.service.impl;

import br.com.jhonnyazevedo.gof.Repository.ClienteRepository;
import br.com.jhonnyazevedo.gof.Repository.EnderecoRepository;
import br.com.jhonnyazevedo.gof.exceptions.ClienteEncontradoException;
import br.com.jhonnyazevedo.gof.exceptions.ClienteNaoEncontradoException;
import br.com.jhonnyazevedo.gof.model.Cliente;
import br.com.jhonnyazevedo.gof.model.Endereco;
import br.com.jhonnyazevedo.gof.service.IClienteService;
import br.com.jhonnyazevedo.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService implements IClienteService {

    // Singleton: Injetar os componentes do com @Autowired
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository  enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(UUID id) {
        return clienteRepository.findById(id).orElseThrow(() -> {
            throw new ClienteNaoEncontradoException();
        });
    }

    @Override
    public void inserir(Cliente cliente) {
        Endereco enderecoExistente = enderecoRepository.findById(cliente.getEndereco()
                .getCep()).orElse(null);
        Cliente clienteCadastrado = buscarPeloNome(cliente.getNome());

        if (clienteCadastrado != null && enderecoExistente != null) {
            throw new ClienteEncontradoException();
        }

        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clienteRepository.findById(cliente.getId()).orElseThrow(() -> {
            throw new ClienteNaoEncontradoException();
        });

        clienteRepository.save(cliente);
    }

    @Override
    public void excluir(UUID id) {
        clienteRepository.findById(id).orElseThrow(() -> {
            throw new ClienteNaoEncontradoException();
        });

        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o endereço do cliente já existe pelo CEP
        Endereco endereco = enderecoRepository.findById(cliente.getEndereco().getCep())
                .orElseGet(() -> {
                    // Pesquisar o endereço pelo CEP
                    Endereco novoEndereco = viaCepService.consultarCep(cliente.getEndereco().getCep());
                    String cep = novoEndereco.getCep().replace("-", "");
                    novoEndereco.setCep(cep);
                    // Salvar no banco novo endereço
                    enderecoRepository.save(novoEndereco);

                    return novoEndereco;
                });

        cliente.setEndereco(endereco);

        clienteRepository.save(cliente);
    }

    public Cliente buscarPeloNome(String nome) {
        return clienteRepository.findByNome(nome).get();
    }
}
