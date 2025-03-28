package autonoma.SimuladorDeAuto.Exception;

/**
 Exception lanzada cuando se intenta encender el vehiculo que ya
 esta encendido
 * @author Gilary
 * @since 20250328
 * @version 1.0
 */
public class VehiculoEncendidoException extends Exception{
    
    /**
     * Constructor de la excepcion
     */
    public VehiculoEncendidoException(String mensaje ){
        super(mensaje);
    }
}
