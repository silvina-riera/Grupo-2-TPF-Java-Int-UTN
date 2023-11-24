package estados;

import modelos.Incidente;


public interface IncidenciaEstado {
 
 void mostrarEstado();
 Incidente cambiarEstado(Incidente incidente);
}
