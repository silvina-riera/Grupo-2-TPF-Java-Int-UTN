
package com.mycompany.trabajopracticofinal.modelo.incidente;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EstadoEnProceso implements IncidenciaEstado{
    
    private String estado = "En Proceso";
    @Override
    public void mostrarEstado() {
        System.out.println("El estado actual es:" + estado);   
    }

    @Override
    public IncidenciaEstado cambiarEstado() {
        IncidenciaEstado estado;
        estado = new EstadoResuelto();
        return estado ;
    }
    
}
