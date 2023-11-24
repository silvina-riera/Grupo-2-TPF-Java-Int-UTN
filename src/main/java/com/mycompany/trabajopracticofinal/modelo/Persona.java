
package com.mycompany.trabajopracticofinal.modelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@MappedSuperclass
public class Persona {
    /** private int id; */
    private String nombre;
    private String apellido;
}
