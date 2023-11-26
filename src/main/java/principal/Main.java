
package principal;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import javax.persistence.EntityManager;
import modelos.EEstado;
import modelos.Tecnico;
import repository.EntityManagerConfig;
import service.TecnicoService;
import utils.ObjetosUtilitarios1;
import utils.ObjetosUtilitarios2;
import utils.ObjetosUtilitarios3;
import utils.ObjetosUtilitarios4;
import utils.ObjetosUtilitarios5;


public class Main {
    public static void main(String[] args) {
        
       /**
        * Ciclo de vida de la aplicación      
        */
       
        EntityManager em = EntityManagerConfig.getEntityManager();
        CicloVida cicloVida = new CicloVida();
        TecnicoService service = new TecnicoService();
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("Menú Principal");
            System.out.println("1. Registrar Ciclo de vida nº 1");
            System.out.println("2. Registrar Ciclo de vida nº 2");
            System.out.println("3. Registrar Ciclo de vida nº 3");
            System.out.println("4. Registrar Ciclo de vida nº 4");
            System.out.println("5. Registrar Ciclo de vida nº 5");
            System.out.println("6. Cambiar estado a incidente resuelto");
            System.out.println("7. Técnico con más cantidad de incidentes resueltos por fecha");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = sc.nextInt();

                  switch (opcion) {
                case 1:
                    cicloVida.crearCliente(ObjetosUtilitarios1.cliente(), "Tango Full support");
                    cicloVida.crearEspecialidad(ObjetosUtilitarios1.Especialidad1());
                    cicloVida.crearProblema(ObjetosUtilitarios1.problema1(), "Tango Windows");
                    cicloVida.crearProblema(ObjetosUtilitarios1.problema2(), "Tango Windows");
                    cicloVida.crearOperador(ObjetosUtilitarios1.operador());
                    cicloVida.crearTecnico(ObjetosUtilitarios1.tecnico1(), "Tango Windows", 1);
                    cicloVida.crearIncidente(ObjetosUtilitarios1.incidente1(), "UTN SRL", 1, "Tango Full support", ObjetosUtilitarios1.listaProblemas(ObjetosUtilitarios1.problema1(), ObjetosUtilitarios1.problema2()));

                    // Relaciones adicionales
                    cicloVida.actualizarCliente("UTN SRL", 1);
                    cicloVida.actualizarEspecialidadTecnicos(1, 1);
                    cicloVida.actualizarTipoProblema(1, 1);
                    cicloVida.actualizarTipoProblema(2, 1);
                    cicloVida.actualizarEspecialidadProblemas(1, 1);
                    cicloVida.actualizarEspecialidadProblemas(1, 2);
                    cicloVida.actualizarOperador(1, 1);
                    cicloVida.actualizarTecnico(1, 1);
                    
                    System.out.println("\n Se guardaron con exito todos los registros en la base de datos \n");
                    break;
                case 2:
                    cicloVida.crearCliente(ObjetosUtilitarios2.cliente(), "SAP Full support");
                    cicloVida.crearEspecialidad(ObjetosUtilitarios2.Especialidad2());
                    cicloVida.crearProblema(ObjetosUtilitarios2.problema1(), "SAP Linux");
                    cicloVida.crearProblema(ObjetosUtilitarios2.problema2(), "SAP Linux");
                    cicloVida.crearOperador(ObjetosUtilitarios2.operador());
                    cicloVida.crearTecnico(ObjetosUtilitarios2.tecnico2(), "SAP Linux", 2);
                    cicloVida.crearIncidente(ObjetosUtilitarios2.incidente2(), "Sauce SA", 2, "SAP Full support", ObjetosUtilitarios2.listaProblemas(ObjetosUtilitarios1.problema1(), ObjetosUtilitarios2.problema2()));
                    
                    // Relaciones adicionales
                    cicloVida.actualizarCliente("Sauce SA", 2);
                    cicloVida.actualizarEspecialidadTecnicos(2, 2);
                    cicloVida.actualizarTipoProblema(3, 2);
                    cicloVida.actualizarTipoProblema(4, 2);
                    cicloVida.actualizarEspecialidadProblemas(2, 3);
                    cicloVida.actualizarEspecialidadProblemas(2, 4);
                    cicloVida.actualizarOperador(2, 2);
                    cicloVida.actualizarTecnico(2, 2);
                    
                    System.out.println("\n Se guardaron con exito todos los registros en la base de datos \n");
                    break;
                case 3:
                    cicloVida.crearCliente(ObjetosUtilitarios3.cliente(), "Tango basic support");
                    cicloVida.crearProblema(ObjetosUtilitarios3.problema1(), "Tango Windows");
                    cicloVida.crearProblema(ObjetosUtilitarios3.problema2(), "Tango Windows");
                    cicloVida.crearOperador(ObjetosUtilitarios3.operador());
                    cicloVida.crearTecnico(ObjetosUtilitarios3.tecnico3(), "Tango Windows", 3);
                    cicloVida.crearIncidente(ObjetosUtilitarios3.incidente3(), "Rio SA", 3, "Tango basic support", ObjetosUtilitarios2.listaProblemas(ObjetosUtilitarios1.problema1(), ObjetosUtilitarios2.problema2()));
                    
                    // Relaciones adicionales
                    cicloVida.actualizarCliente("Rio SA", 3);
                    cicloVida.actualizarEspecialidadTecnicos(1, 3);
                    cicloVida.actualizarTipoProblema(5, 3);
                    cicloVida.actualizarTipoProblema(6, 3);
                    cicloVida.actualizarEspecialidadProblemas(1, 5);
                    cicloVida.actualizarEspecialidadProblemas(1, 6);
                    cicloVida.actualizarOperador(3, 3);
                    cicloVida.actualizarTecnico(3, 3);
                    
                    System.out.println("\n Se guardaron con exito todos los registros en la base de datos \n");
                    break;
                case 4:
                    cicloVida.crearCliente(ObjetosUtilitarios4.cliente(), "Tango basic support Anual");
                    cicloVida.crearProblema(ObjetosUtilitarios4.problema1(), "Tango Windows");
                    cicloVida.crearProblema(ObjetosUtilitarios4.problema2(), "Tango Windows");
                    cicloVida.crearIncidente(ObjetosUtilitarios4.incidente4(), "Flandes SRL", 1, "Tango basic support", ObjetosUtilitarios2.listaProblemas(ObjetosUtilitarios1.problema1(), ObjetosUtilitarios2.problema2()));
                    
                    // Relaciones adicionales
                    cicloVida.actualizarCliente("Flandes SRL", 4);
                    cicloVida.actualizarTipoProblema(7, 4);
                    cicloVida.actualizarTipoProblema(8, 4);
                    cicloVida.actualizarEspecialidadProblemas(1, 7);
                    cicloVida.actualizarEspecialidadProblemas(1, 8);
                    cicloVida.actualizarOperador(1, 4);
                    cicloVida.actualizarTecnico(1, 4);
                    
                    System.out.println("\n Se guardaron con exito todos los registros en la base de datos \n");
                    break;
                case 5:
                    cicloVida.crearCliente(ObjetosUtilitarios5.cliente(), "Tango Premium support");
                    cicloVida.crearProblema(ObjetosUtilitarios5.problema1(), "Tango Windows");
                    cicloVida.crearProblema(ObjetosUtilitarios5.problema2(), "Tango Windows");
                    cicloVida.crearIncidente(ObjetosUtilitarios5.incidente5(), "Roman Hnos. SRL", 2, "Tango basic support", ObjetosUtilitarios2.listaProblemas(ObjetosUtilitarios1.problema1(), ObjetosUtilitarios2.problema2()));
                    
                    // Relaciones adicionales
                    cicloVida.actualizarCliente("Roman Hnos. SRL", 5);
                    cicloVida.actualizarTipoProblema(9, 5);
                    cicloVida.actualizarTipoProblema(10, 5);
                    cicloVida.actualizarEspecialidadProblemas(1, 9);
                    cicloVida.actualizarEspecialidadProblemas(1, 10);
                    cicloVida.actualizarOperador(2, 5);
                    cicloVida.actualizarTecnico(2, 5);
                    
                    System.out.println("\n Se guardaron con exito todos los registros en la base de datos \n");
                    break;
                case 6:
                    cicloVida.incidenteResuelto(1);
                    cicloVida.incidenteResuelto(3);
                    cicloVida.incidenteResuelto(4);
                    break;   
                case 7:
                LocalDate fecha1 = LocalDate.parse("2023-11-24");
                LocalDate fecha2 = LocalDate.parse("2023-11-25");
                Tecnico tecnico = service.resueltosporFecha(EEstado.RESUELTO, fecha1, fecha2);
                System.out.println("Tecnico más incidentes resueltos: " + tecnico.getNombre() + " " + tecnico.getApellido());
                break; 
                case 0:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intente nuevamente.");
            }
        } while (opcion != 0);
        
        em.close();
       
        //Prueba metodo 1
        System.out.println("técnico con más incidentes resueltos");
        Optional<Map.Entry<Tecnico, Long>> resultado = service.obtenerTecnicoConMasIncidentesResueltosUltimosNDias(80);
        resultado.ifPresent(entry -> {
        Tecnico tecnicoConMasIncidentes = entry.getKey();
        Long cantidadIncidentes = entry.getValue();
            
        System.out.println("Técnico con más incidentes: " +tecnicoConMasIncidentes.getNombre() +" " + tecnicoConMasIncidentes.getApellido());
        System.out.println("Cantidad de incidentes: " + cantidadIncidentes);
           
        
});
       
     System.out.println("Metodo 2");
     System.out.println("técnico con más incidentes resueltos por especialidad - sin probar por falta de datos");
       Optional<Map.Entry<Tecnico, Long>> resultado2 =service.tecnicoConMaximaCantidadDeIncidentesEnEspecialidad(null, 100);
       resultado2.ifPresent(entry -> {
        Tecnico tecnicoConMasIncidentes = entry.getKey();
        Long cantidadIncidentes = entry.getValue();
            
        System.out.println("Técnico con más incidentes: " +tecnicoConMasIncidentes.getNombre() +" " + tecnicoConMasIncidentes.getApellido());
        System.out.println("Cantidad de incidentes: " + cantidadIncidentes);
       });
   
             
}
}
