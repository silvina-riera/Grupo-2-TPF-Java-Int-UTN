
package com.mycompany.trabajopracticofinal.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy=AUTO)
    private int id;
    private String nombre;
    private String descripcion;

    @OneToMany
    @JoinColumn(name= "especialidad_id", referencedColumnName = "id")
    Set<TipoProblema> listaProblemas;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (
            name = "especialidad_has_tecnico",
            joinColumns = @JoinColumn(name = "especialidad_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id")
    )
    Set<Tecnico> listaTecnicos;
}
