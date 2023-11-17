package com.mycompany.trabajopracticofinal.modelo;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoProblema {
    private int id ;
    private String descripcion;
    private LocalDate tiempoEstimado;
    private Incidente incidente;
}
