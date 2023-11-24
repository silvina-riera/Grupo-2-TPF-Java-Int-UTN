package modelos;
import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tipo_problema")
public class TipoProblema implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String descripcion;
    
    @Column(name = "tiempo_estimado")
    private int tiempoEstimado;
    
    @ManyToOne
    @JoinColumn(name = "fk_incidente", referencedColumnName = "id")
    private Incidente incidente;
    
    @ManyToOne
    @JoinColumn(name = "fk_especialidad", referencedColumnName = "id")
    private Especialidad especialidad;

    @Override
    public String toString() {
        return "TipoProblema{" + "id=" + id + ", descripcion=" + descripcion + ", tiempoEstimado=" + tiempoEstimado + ", incidente=" + incidente + ", especialidad=" + especialidad + '}';
    }   
}
