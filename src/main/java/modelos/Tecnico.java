package modelos;

import java.io.Serializable;
import java.util.Set;
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
@Table(name = "tecnico")
public class Tecnico extends Persona implements Serializable{
    
    
    private boolean disponibilidad;
    
    @Enumerated(EnumType.STRING)
    private MedioNotificacionEnum notificacion;
    
    @ManyToMany(mappedBy = "listaTecnicos")
    private Set<Especialidad> listaEspecialidades;
    
    @ManyToOne
    @JoinColumn(name = "fk_operador", referencedColumnName = "id")        
    private Operador operador;
    
    @OneToMany(mappedBy = "tecnico")        
    private Set<Incidente> incidentes;

    @Override
    public String toString() {
        return "Tecnico{" + super.toString() + " disponibilidad=" + disponibilidad + ", notificacion=" + notificacion + '}';
    }
    
    
}
