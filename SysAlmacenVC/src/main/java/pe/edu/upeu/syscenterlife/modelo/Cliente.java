
package pe.edu.upeu.syscenterlife.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@Data

public class Cliente {
    @Id
    @Basic(optional = false)
    String dniruc;
    String nombre;
    String documento;    
}
