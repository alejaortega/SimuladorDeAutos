/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.SimuladorDeAuto.models;

import autonoma.SimuladorDeAuto.Exception.AccidenteException;
import autonoma.SimuladorDeAuto.Exception.FrenadoBruscoException;
import autonoma.SimuladorDeAuto.Exception.VehiculoApagadoException;
import autonoma.SimuladorDeAuto.Exception.VehiculoEncendidoException;
import autonoma.SimuladorDeAuto.Exception.VelocidadExcedidaException;

/**
 * Clase Vehiculo que modela el comportamiento de un automóvil en una simulación.
 * 
 * @author Alejandra
 * @version 1.0
 * @date 28/03/2025
 */
public class Vehiculo {
    /** Velocidad actual del vehículo en km/h. */
    private double velocidad;
    
    /** Motor del vehículo. */
    private Motor motor;
    
    /** Llantas del vehículo. */
    private Llanta llantas;
    
    /** Indica si el vehículo está encendido. */
    private boolean encendido;
    
    /** Indica si el vehículo ha sufrido un accidente. */
    private boolean accidentado;
    
    /** Indica si el vehículo está patinando. */
    private boolean patinando;

    /**
     * Constructor de la clase Vehiculo.
     * 
     * @param motor Motor del vehículo.
     * @param llantas Llantas del vehículo.
     */
    public Vehiculo(Motor motor, Llanta llantas) {
        this.motor = motor;
        this.llantas = llantas;
        this.velocidad = 0;
        this.encendido = false;
        this.accidentado = false;
        this.patinando = false;
    }

    // Métodos para acceder a los atributos
    
    /** @return Las llantas del vehículo. */
    public Llanta getLlantas() {
        return llantas;
    }
    
    /** @return El motor del vehículo. */
    public Motor getMotor() {
        return motor;
    }
    
    /** @return La velocidad actual del vehículo. */
    public double getVelocidad() {
        return velocidad;
    }

    /** @return Si el vehículo está encendido. */
    public boolean isEncendido() {
        return encendido;
    }

    /** @return Si el vehículo ha sufrido un accidente. */
    public boolean isAccidentado() {
        return accidentado;
    }

    /** @return Si el vehículo está patinando. */
    public boolean isPatinando() {
        return patinando;
    }
    
    /** @return Si el vehículo está encendido (duplicado de isEncendido()). */
    public boolean isEncender() {
        return encendido;
    }

    /**
     * Enciende el vehículo.
     * 
     * @throws VehiculoEncendidoException Si el vehículo ya está encendido.
     */
    public void encender() throws VehiculoEncendidoException {
        if (this.encendido) {
            throw new VehiculoEncendidoException("El vehículo ya está encendido.");
        }
        this.motor.encender();
        this.encendido = true;
    }

    /**
     * Apaga el vehículo.
     * 
     * @throws VehiculoApagadoException Si el vehículo ya está apagado.
     * @throws AccidenteException Si el vehículo intenta apagarse a más de 60 km/h.
     */
    public void apagar() throws VehiculoApagadoException, AccidenteException {
        if (!this.encendido) {
            throw new VehiculoApagadoException("El vehículo ya está apagado.");
        }
        if (this.velocidad > 60) {
            accidentar();
            throw new AccidenteException("El vehículo se accidentó al intentar apagarlo a alta velocidad.");
        }
        this.motor.apagar();
        this.encendido = false;
        System.out.println("Vehículo apagado.");
    }

    /**
     * Acelera el vehículo a una velocidad específica.
     * 
     * @param incremento Cantidad en la que se desea aumentar la velocidad.
     * @throws VelocidadExcedidaException Si la velocidad supera el límite del motor.
     * @throws VehiculoApagadoException Si el vehículo está apagado y no puede acelerar.
     */
    public void acelerar(double incremento) throws VelocidadExcedidaException, VehiculoApagadoException {
        if (!this.encendido) {
            throw new VehiculoApagadoException("El vehículo está apagado. No se puede acelerar.");
        }
        double nuevaVelocidad = this.velocidad + incremento;
        this.motor.validarVelocidadMaxima(nuevaVelocidad);
        this.velocidad = nuevaVelocidad;
        System.out.println("Vehículo acelerado. Velocidad actual: " + this.velocidad + " Km/h.");
    }

    /**
     * Reduce la velocidad del vehículo de forma controlada.
     * 
     * @param decremento Cantidad en la que se desea reducir la velocidad.
     * @throws VehiculoApagadoException Si el vehículo está apagado y no puede frenar.
     */
    public void frenar(double decremento) throws VehiculoApagadoException {
        if (!this.encendido) {
            throw new VehiculoApagadoException("El vehículo está apagado. No se puede frenar.");
        }
        if (this.velocidad == 0) {
            throw new VehiculoApagadoException("El vehículo ya está detenido.");
        }
        this.velocidad -= decremento;
        if (this.velocidad < 0) {
            this.velocidad = 0;
        }
        System.out.println("Vehículo frenado. Velocidad actual: " + this.velocidad + " Km/h.");
    }

    /**
     * Realiza una frenada brusca, lo que puede causar patinaje.
     * 
     * @throws FrenadoBruscoException Si el vehículo patina al frenar bruscamente.
     * @throws VehiculoApagadoException Si el vehículo está apagado y no puede frenar.
     */
    public void frenarBruscamente() throws FrenadoBruscoException, VehiculoApagadoException {
        if (this.velocidad > llantas.getLimitePatinaje()) {
            this.patinar();
            throw new FrenadoBruscoException("El vehículo patinó al frenar bruscamente.");
        } else if (0 > this.velocidad) {
            this.patinar();
            throw new FrenadoBruscoException("El vehículo patinó por frenar bruscamente con mayor intensidad que la velocidad.");
        }
        this.frenar(this.velocidad);
    }

    /**
     * Marca el vehículo como accidentado, deteniéndolo completamente.
     */
    public void accidentar() {
        this.accidentado = true;
        this.velocidad = 0;
        this.encendido = false;
        System.out.println("El vehículo ha tenido un accidente.");
    }

    /**
     * Marca el vehículo como patinando, reduciendo su velocidad a cero.
     */
    public void patinar() {
        this.patinando = true;
        this.velocidad = 0;
        System.out.println("El vehículo está patinando.");
    }
}
