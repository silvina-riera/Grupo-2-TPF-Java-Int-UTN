
package com.mycompany.trabajopracticofinal.modelo;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente extends Persona{
    
    private int id;
    private String razonSocial;
    private String cuit;
    private String telefono;
    private String correoElectronico;
    private MesaAyuda atencion;
    private Set<Incidente> incidentes;
    private Set<Servicio> servicios;
    
}
