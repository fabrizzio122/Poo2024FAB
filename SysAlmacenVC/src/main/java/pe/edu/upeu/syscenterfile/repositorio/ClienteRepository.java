package pe.edu.upeu.syscenterfile.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.syscenterfile.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
    
    
}
