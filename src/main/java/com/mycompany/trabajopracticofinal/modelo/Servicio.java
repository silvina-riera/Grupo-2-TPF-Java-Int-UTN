
package com.mycompany.trabajopracticofinal.modelo;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Servicio {
    private int id;
    private String tipoServicio;
    private String descripcion;
    private List <Cliente> clientes;
            
}
