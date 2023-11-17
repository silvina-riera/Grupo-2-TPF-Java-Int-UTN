
package com.mycompany.trabajopracticofinal.modelo;

import java.util.Set;


public class Especialidad {
    
    private int id;
    private String nombre;
    private String descripcion;
    Set<TipoProblema> listaProblemas;
    Set<Tecnico> listaTecnicos;
}
