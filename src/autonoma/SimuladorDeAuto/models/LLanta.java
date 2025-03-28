
package autonoma.SimuladorDeAuto.models;

/**
 *
 * @author Alejandra
 */
/**
 * La clase Llanta representa una llanta con un tipo específico y un límite de patinaje.
 */
public class Llanta {  

    /** Tipo de llanta (por ejemplo, "Buenas", "bonitas", "Baratas"). */
    private String tipo;  

    /** Límite de patinaje de la llanta, que indica en qué punto comienza a perder tracción. */
    private double limitePatinaje;  

    /**
     * Constructor de la clase Llanta.
     * 
     * @param tipo Tipo de la llanta 
     * @param limitePatinaje Valor que indica el límite de patinaje de la llanta.
     */
    public Llanta(String tipo, double limitePatinaje) {
        this.tipo = tipo;  
        this.limitePatinaje = limitePatinaje;  
    }

    /**
     * Obtiene el tipo de la llanta.
     * 
     * @return Tipo de la llanta en formato de cadena de texto.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el límite de patinaje de la llanta.
     * 
     * @return Valor del límite de patinaje en formato de número decimal.
     */
    public double getLimitePatinaje() {
        return limitePatinaje;
    }
    
}

