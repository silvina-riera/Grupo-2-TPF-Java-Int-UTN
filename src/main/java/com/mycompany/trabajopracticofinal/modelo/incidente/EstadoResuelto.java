
package com.mycompany.trabajopracticofinal.modelo.incidente;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@NoArgsConstructor
@Getter

public class EstadoResuelto implements IncidenciaEstado{

  private String estado = "Resuelto";
    @Override
    public IncidenciaEstado cambiarEstado() {
       return null;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("El estado actual es:" + estado); 
    }
    
}
