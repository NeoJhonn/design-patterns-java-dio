package br.com.jhonnyazevedo.gof.Repository;

import br.com.jhonnyazevedo.gof.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository // Usamos CrudRepository pois se trata de um Strategy
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    Optional<Cliente> findByNome(String nome);
}
