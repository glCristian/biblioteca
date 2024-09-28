package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Estudiante extends Persona {
    private int edad;
    private Collection<Prestamo> prestamos;

    /**
     * Método constructor de la clase estudiante
     * 
     * @param nombre   del estudiante
     * @param cedula   del estudiante
     * @param telefono del estudiante
     * @param correo   del estudiante
     * @param edad     del estudiante
     */
    public Estudiante(String nombre, String cedula, int telefono, String correo, int edad) {
        super(nombre, cedula, telefono, correo);
        this.edad = edad;
        prestamos = new LinkedList<>();
    }

    // ----------Métodos Get y Set de la clase Estudiante-----------//

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
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Método para obtener la lista de prestamos de un estudiante
     * 
     * @return
     */
    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Método para modificar la lista de prestamos de un estudiante
     * 
     * @param prestamos
     */
    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    // -------------------------------------------------------------//

    /**
     * Método toString de la clase Estudiante
     */
    @Override
    public String toString() {
        return "Estudiante [" + super.toString() + ", edad=" + edad + ", prestamos=" + prestamos + "]";
    }

}
