
package modelos;

import estados.EstadoEnProceso;
import estados.EstadoPendiente;
import estados.EstadoResuelto;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "incidente")
public class Incidente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    EEstado estado = EEstado.PENDIENTE;

    @Column(name = "tiempo_resolucion")
    private int tiempoResolucion;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @Column(name = "fecha_cierre")
    private LocalDate fechaCierre;
    @Column(name = "hora_colchon")
    private int horaColchon;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_servicio", referencedColumnName = "id")
    private Servicio servicio;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_tecnico", referencedColumnName = "id")
    private Tecnico tecnico;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(mappedBy = "incidente", cascade = CascadeType.ALL) 
    private Set<TipoProblema> listaProblemas;

    
    public EEstado modificarEstado(){
        if (this.tecnico != null && this.tecnico.isDisponibilidad() == false){
            EstadoPendiente pendiente = new EstadoPendiente();
            pendiente.cambiarEstado(this);
        }else if(this.fechaCierre != null){
            EstadoEnProceso enProceso = new EstadoEnProceso();
            enProceso.cambiarEstado(this);
        }
        return this.estado;
    }

    @Override
    public String toString() {
        return "Incidente{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", tiempoResolucion=" + tiempoResolucion + ", fechaCreacion=" + fechaCreacion + ", fechaCierre=" + fechaCierre + ", horaColchon=" + horaColchon + ", servicio=" + servicio + ", tecnico=" + tecnico + ", cliente=" + cliente + ", listaProblemas=" + listaProblemas + '}';
    }
    
    
}
