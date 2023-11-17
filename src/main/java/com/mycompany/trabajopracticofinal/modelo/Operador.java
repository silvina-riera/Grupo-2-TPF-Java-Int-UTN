
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
public class Operador extends Persona{
    
    private Incidente incidente;
    private Set<Tecnico> listaTecnicos;
    
}
