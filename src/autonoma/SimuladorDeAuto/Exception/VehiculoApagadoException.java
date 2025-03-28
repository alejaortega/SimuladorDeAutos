
package autonoma.SimuladorDeAuto.Exception;

/**
 Exception lanzada cuando se intenta apagar el vehiculo que ya
 esta apagado
 * @author Gilary
 * @since 20250328
 * @version 1.0
 */
public class VehiculoApagadoException extends Exception {
    
    /**
     * Constructor de la excepcion
     */
    
    public VehiculoApagadoException(String mensaje ){
     super(mensaje);
    }
    
    
}
