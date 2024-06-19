package br.com.jhonnyazevedo.gof.Repository;

import br.com.jhonnyazevedo.gof.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // Usamos CrudRepository pois se trata de um Strategy
public interface ClienteRepository extends CrudRepository<Cliente, UUID> {
}
