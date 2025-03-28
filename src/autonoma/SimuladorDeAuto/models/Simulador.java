/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.SimuladorDeAuto.models;

import autonoma.SimuladorDeAuto.Exception.AccidenteException;
import autonoma.SimuladorDeAuto.Exception.FrenadoBruscoException;
import autonoma.SimuladorDeAuto.Exception.VehiculoApagadoException;
import autonoma.SimuladorDeAuto.Exception.VehiculoEncendidoException;
import autonoma.SimuladorDeAuto.Exception.VelocidadExcedidaException;

/**
 *
 * @author valej
 */
/**
 * La clase Simulador representa un sistema que controla un vehículo,
 * permitiendo encenderlo, apagarlo, acelerar y frenar, incluyendo frenadas bruscas.
 */
public class Simulador {  

    /** Vehículo que se va a controlar en la simulación. */
    private Vehiculo vehiculo;

    /**
     * Constructor de la clase Simulador.
     * 
     * @param vehiculo Vehículo que será controlado en la simulación.
     */
    public Simulador(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Enciende el vehículo.
     * 
     * @throws VehiculoEncendidoException Si el vehículo ya está encendido.
     */
    public void encenderVehiculo() throws VehiculoEncendidoException {
        vehiculo.encender();
    }

    /**
     * Apaga el vehículo.
     * 
     * @throws VehiculoApagadoException Si el vehículo ya está apagado.
     * @throws AccidenteException Si el vehículo ha sufrido un accidente.
     */
    public void apagarVehiculo() throws VehiculoApagadoException, AccidenteException {
        vehiculo.apagar();
    }

    /**
     * Acelera el vehículo hasta una velocidad específica.
     * 
     * @param velocidad Velocidad a la que se quiere acelerar el vehículo.
     * @throws VelocidadExcedidaException Si se supera la velocidad máxima del motor.
     * @throws VehiculoApagadoException Si el vehículo está apagado y no puede acelerar.
     */
    public void acelerarVehiculo(double velocidad) throws VelocidadExcedidaException, VehiculoApagadoException {
        vehiculo.acelerar(velocidad);
    }

    /**
     * Reduce la velocidad del vehículo de forma controlada.
     * 
     * @param velocidad Cantidad en la que se quiere reducir la velocidad.
     * @throws VehiculoApagadoException Si el vehículo está apagado y no puede frenar.
     */
    public void frenarVehiculo(double velocidad) throws VehiculoApagadoException {
        vehiculo.frenar(velocidad);
    }

    /**
     * Realiza una frenada brusca con el vehículo.
     * 
     * @throws FrenadoBruscoException Si la frenada brusca causa un patinaje del vehículo.
     * @throws VehiculoApagadoException Si el vehículo está apagado y no puede frenar.
     */
    public void frenarBruscamenteVehiculo() throws FrenadoBruscoException, VehiculoApagadoException {
        vehiculo.frenarBruscamente();
    }

    /**
     * Obtiene la velocidad actual del vehículo.
     * 
     * @return La velocidad del vehículo en ese momento.
     */
    public double getVelocidadVehiculo() {
        return vehiculo.getVelocidad();
    }
    
    /**
     * Obtiene el vehículo que está siendo simulado.
     * 
     * @return Objeto de tipo Vehiculo.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}

