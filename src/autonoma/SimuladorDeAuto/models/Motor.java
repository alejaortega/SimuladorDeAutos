
package autonoma.SimuladorDeAuto.models;

import autonoma.SimuladorDeAuto.Exception.VelocidadExcedidaException;

/**
 *
 * @author Alejandra
 */
/**
 * La clase Motor representa un motor con una velocidad máxima y la capacidad de encenderse y apagarse.
 */
public class Motor {  

    /** Indica si el motor está encendido (true) o apagado (false). */
    private boolean encendido;  

    /** Velocidad máxima permitida para el motor. */
    private double velocidadMaxima;  

    /**
     * Constructor de la clase Motor.
     * 
     * @param velocidadMaxima Velocidad máxima permitida para el motor.
     */
    public Motor(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
        this.encendido = false;  // El motor comienza apagado por defecto
    }

    /**
     * Enciende el motor y muestra un mensaje en la consola.
     */
    public void encender() {
        this.encendido = true;
        System.out.println("Motor encendido.");
    }

    /**
     * Apaga el motor y muestra un mensaje en la consola.
     */
    public void apagar() {
        this.encendido = false;
        System.out.println("Motor apagado.");
    }

    /**
     * Valida si una velocidad dada supera la velocidad máxima del motor.
     * 
     * @param velocidad Velocidad a validar.
     * @throws LimiteMotorException Si la velocidad supera el límite permitido.
     */
    public void validarVelocidadMaxima(double velocidad) throws VelocidadExcedidaException {
        if (velocidad > this.velocidadMaxima) {
            throw new VelocidadExcedidaException("Se ha excedido la velocidad máxima del motor.");
        }
    }

    /**
     * Obtiene la velocidad máxima del motor.
     * 
     * @return Velocidad máxima permitida.
     */
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Verifica si el motor está encendido.
     * 
     * @return true si el motor está encendido, false si está apagado.
     */
    public boolean isEncendido() {
        return encendido;
    }
}
