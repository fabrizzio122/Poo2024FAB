package pe.edu.upeu.syscenterlife.repositorio;

import static java.lang.Math.log;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.autocomp.ModeloDataAutocomplet;
import pe.edu.upeu.syscenterlife.modelo.Cliente;
import pe.edu.upeu.syscenterlife.modelo.Producto;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query(value = "SELECT c.* FROM Cliente c WHERE c.nombre like :filter", nativeQuery = true)
    List<Cliente> listAutoCompletCliente(@Param("filter") String filter);



 

}
