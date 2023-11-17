package com.mycompany.trabajopracticofinal.modelo.incidente;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EstadoPendiente implements IncidenciaEstado {

    private String estado = "Pendiente";

    @Override
    public IncidenciaEstado cambiarEstado() {
        IncidenciaEstado estado;
        estado = new EstadoEnProceso();
        return estado;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("El estado actual es:" + estado);
    }

}
