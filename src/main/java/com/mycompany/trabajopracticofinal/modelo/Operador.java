
package com.mycompany.trabajopracticofinal.modelo;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "operador")
public class Operador extends Persona{
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private int id;

    @OneToMany
    @JoinColumn(name= "operador_id", referencedColumnName = "id")
    private Incidente incidente;

    @OneToMany
    @JoinColumn(name= "operador_id", referencedColumnName = "id")
    private Set<Tecnico> listaTecnicos;
    
}
