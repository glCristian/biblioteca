package co.edu.uniquindio.poo;
import java.util.Collection;

public class Estudiante extends Persona {
    private int edad;
    private Collection<Prestamo> prestamos;



    public Estudiante(String nombre, String cedula, int telefono, String correo, int edad) {
        super(nombre, cedula, telefono, correo);
        this.edad = edad;
    }

    /**
     * Método para obtener la edad de un estudiante
     * 
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Método para modificar la edad de un estudiante
     * 
     * @param edad del estudiante
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Método toString de la clase Estudiante
     */
    @Override
    public String toString() {
        return "Estudiante [" + super.toString() + "edad" + edad + "]";
    }

}
