
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
@Table (name ="cliente")
public class Cliente extends Persona{
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private int id;
    private String razonSocial;
    private String cuit;
    private String telefono;
    private String correoElectronico;

    @ManyToOne
    @JoinColumn(name= "mesa_ayuda_id", referencedColumnName = "id")
    private MesaAyuda atencion;

    @OneToMany (mappedBy = "incidente")
    private Set<Incidente> incidentes;

    @ManyToMany
    @JoinTable (
            name = "cliente_has_servicio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private Set<Servicio> servicios;
    
}
