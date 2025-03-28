
package autonoma.SimuladorDeAuto.Exception;

/**
 Exception lanzada cuando se intenta realizar una accion invalida
 como acelerar o frenar un vehiculo apagado
 * @author Gilary
 * @since 20250328
 * @version 1.0
 */
public class AccionInvalidaException extends Exception {
    
    /**
     * Constructor de la excepcion
     */
    public AccionInvalidaException(String mensaje ){
        super(mensaje);
    }
    
    
}
