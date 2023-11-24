
package modelos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "especialidad")
public class Especialidad implements Serializable {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    
    @OneToMany(mappedBy = "especialidad", fetch = FetchType.EAGER)
    private Set<TipoProblema> listaProblemas;
    
    @ManyToMany(targetEntity = Tecnico.class,cascade = CascadeType.ALL)
    private Set<Tecnico> listaTecnicos;
}
