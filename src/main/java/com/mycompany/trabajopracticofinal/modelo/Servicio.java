
package com.mycompany.trabajopracticofinal.modelo;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy=AUTO)
    private int id;
    private String tipoServicio;
    private String descripcion;

    @ManyToMany (mappedBy = "servicios")
    private List <Cliente> clientes;
            
}
