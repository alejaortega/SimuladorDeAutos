
package autonoma.SimuladorDeAuto.Exception;

/**
 Exception lanzada cuando se intenta acelerar mas alla de la 
 capacidad del motor del vehiculo 
 * @author Gilary
 * @since 20250328
 * @version 1.0
 */
public class VelocidadExcedidaException extends Exception {
    
    /**
     * Constructor de la excepcion
     */
    public VelocidadExcedidaException(String mensaje ){
        super(mensaje);
    }
   
    
}
