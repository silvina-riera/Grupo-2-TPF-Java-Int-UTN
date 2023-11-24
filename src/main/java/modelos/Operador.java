
package modelos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "operador")
public class Operador extends Persona implements Serializable{

    @OneToOne(targetEntity = Incidente.class)
    @JoinColumn(name = "fk_incidente", referencedColumnName = "id")
    private Incidente incidente;
    
    @OneToMany(mappedBy = "operador", fetch = FetchType.EAGER)
    private Set<Tecnico> listaTecnicos;    
}
