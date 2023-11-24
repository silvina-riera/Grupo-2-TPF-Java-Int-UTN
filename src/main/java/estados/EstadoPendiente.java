package estados;

import modelos.EEstado;
import modelos.Incidente;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EstadoPendiente implements IncidenciaEstado {

    private EEstado estado;

    @Override
    public Incidente cambiarEstado(Incidente incidente) {
        incidente.setEstado(EEstado.EN_PROCESO);
        estado = EEstado.EN_PROCESO;
        return incidente;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("El estado actual es:" + estado);
    }

}
