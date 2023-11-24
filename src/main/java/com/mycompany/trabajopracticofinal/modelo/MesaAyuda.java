
package com.mycompany.trabajopracticofinal.modelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "mesa_ayuda")
public class MesaAyuda {
    @Id
    @GeneratedValue(strategy=AUTO)
    private int id;

    @OneToMany
    @JoinColumn(name= "mesa_ayuda_id", referencedColumnName = "id")
    private Operador operador;
}
