
package autonoma.SimuladorDeAuto.Exception;

/**
 Exception lanzada cuando el vehiculo se accidenta, ya sea por apagarlo
 a alta velocidad o por acelerar mas alla de su limite
 * @author Gilary
 * @since 20250328
 * @version 1.0
 */
public class AccidenteException extends Exception {

    /**
     * Constructor de la excepcion
     */
    public AccidenteException(String mensaje ){
        super(mensaje);
    }
    
}
