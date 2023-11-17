
package com.mycompany.trabajopracticofinal.modelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
}
