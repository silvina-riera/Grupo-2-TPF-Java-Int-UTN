package com.mycompany.trabajopracticofinal.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Tecnico extends Persona {
    private boolean disponibilidad;
    private MedioNotificacionEnum notificacion;
}
