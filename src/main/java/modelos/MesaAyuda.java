
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
@Table(name = "mesa_ayuda")
public class MesaAyuda implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany( targetEntity = Operador.class)
    @JoinColumn(name = "fk_operador", referencedColumnName = "id")
    private Set<Operador> operador;
}
