/**
 * Clase que representa a una persona.
 * @author BraynerMoncada
 */
public class Persona {
    private String nombre;
    private String provincia;
    private int edad;

    /**
     * Constructor de la clase Persona.
     * @param nombre El nombre de la persona.
     * @param provincia La provincia de la persona.
     * @param edad La edad de la persona.
     */
    public Persona(String nombre, String provincia, int edad) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.edad = edad;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la provincia de la persona.
     * @return La provincia de la persona.
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Obtiene la edad de la persona.
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
