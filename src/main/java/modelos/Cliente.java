
package modelos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable{

    @Column(name = "razon_social")
    private String razonSocial;
    private String cuit;
    private String telefono;
    @Column(name = "email")
    private String correoElectronico;
    
    @OneToOne
    @JoinColumn(name = "fk_mesa_ayuda", referencedColumnName = "id")
    private MesaAyuda mesaAyuda;
    
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Incidente> incidentes;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "cliente_servicio", joinColumns = @JoinColumn(name = "fk_cliente"), 
            inverseJoinColumns = @JoinColumn(name = "fk_servicio"))
    private Set<Servicio> servicios;

    @Override
    public String toString() {
        return "Cliente{" + "razonSocial=" + razonSocial + ", cuit=" + cuit + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico + '}';
    }
    
    
}
