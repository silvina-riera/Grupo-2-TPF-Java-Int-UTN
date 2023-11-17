
package com.mycompany.trabajopracticofinal.modelo;

import com.mycompany.trabajopracticofinal.modelo.incidente.EstadoEnProceso;
import com.mycompany.trabajopracticofinal.modelo.incidente.IncidenciaEstado;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Incidente {

private int id;
private String descripcion;
private IncidenciaEstado estado = new EstadoEnProceso();
private int tiempoResolucion;
private LocalDate fechaCreacion;
private LocalDate fechaCierre;
private int horaColchon;
private Servicio servicio;
private Tecnico tecnico;
private Cliente cliente;
private List<TipoProblema> listaProblemas;

    
}
