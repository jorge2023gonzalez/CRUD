package multiservicios.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import multiservicios.cliente.model.cliente;

@Repository
public interface clienterepository extends JpaRepository<cliente, Integer>{

}
