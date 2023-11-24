package com.mycompany.trabajopracticofinal.modelo;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "tipo_problema")
public class TipoProblema {
    @Id
    @GeneratedValue(strategy=AUTO)
    private int id ;
    private String descripcion;
    private LocalDate tiempoEstimado;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name= "incidente_id", referencedColumnName = "id")
    private Incidente incidente;
}
