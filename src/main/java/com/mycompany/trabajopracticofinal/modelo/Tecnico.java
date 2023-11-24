package com.mycompany.trabajopracticofinal.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "tecnico")
public class Tecnico extends Persona {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private int id;
    private boolean disponibilidad;
    private MedioNotificacionEnum notificacion;
}
