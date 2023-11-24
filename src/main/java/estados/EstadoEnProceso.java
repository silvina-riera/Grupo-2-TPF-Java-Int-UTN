
package estados;

import modelos.EEstado;
import modelos.Incidente;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EstadoEnProceso implements IncidenciaEstado{
    
    private EEstado estado;
   
    @Override
    public void mostrarEstado() {
        System.out.println("El estado actual es:" + estado);   
    }

    @Override
    public Incidente cambiarEstado(Incidente incidente) {
        incidente.setEstado(EEstado.RESUELTO);
        estado = EEstado.RESUELTO;
        return incidente;
    }
    
}
