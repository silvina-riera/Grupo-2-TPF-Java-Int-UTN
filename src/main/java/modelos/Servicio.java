
package modelos;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "tipo_servicio")
    private String tipoServicio;
    
    private String descripcion;
    
    @ManyToMany(mappedBy = "servicios")
    private Set<Cliente> clientes;
            
}
