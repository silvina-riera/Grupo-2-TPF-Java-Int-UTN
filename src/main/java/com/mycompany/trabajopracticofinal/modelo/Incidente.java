
package com.mycompany.trabajopracticofinal.modelo;

import com.mycompany.trabajopracticofinal.modelo.incidente.EstadoEnProceso;
import com.mycompany.trabajopracticofinal.modelo.incidente.IncidenciaEstado;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "incidente")
public class Incidente {
    @Id
    @GeneratedValue(strategy=AUTO)
    private int id;
    private String descripcion;
    private IncidenciaEstado estado = new EstadoEnProceso();
    private int tiempoResolucion;
    private LocalDate fechaCreacion;
    private LocalDate fechaCierre;
    private int horaColchon;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name= "servicio_id", referencedColumnName = "id")
    private Servicio servicio;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name= "tecnico_id", referencedColumnName = "id")
    private Tecnico tecnico;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name= "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany (mappedBy = "incidente")
    private List<TipoProblema> listaProblemas;

    
}
