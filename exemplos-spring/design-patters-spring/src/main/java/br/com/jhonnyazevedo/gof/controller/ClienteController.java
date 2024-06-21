package br.com.jhonnyazevedo.gof.controller;

import br.com.jhonnyazevedo.gof.exceptions.ClienteNaoEncontradoException;
import br.com.jhonnyazevedo.gof.model.Cliente;
import br.com.jhonnyazevedo.gof.service.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.ref.Cleaner;
import java.util.UUID;

/**
 * Representa design pattern <b>Facade</b> pois abstrai toda a complexidadede integrações
 * (banco de dados Postgres e API do ViaCEP nesta API).
 *
 * @author Neojhonn
 */

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(clienteService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@RequestBody Cliente cliente) {
        try {
            clienteService.inserir(cliente);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody Cliente cliente) {
        try {
            clienteService.atualizar(cliente);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable UUID id) {
        try {
            clienteService.excluir(id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }




    }
}
