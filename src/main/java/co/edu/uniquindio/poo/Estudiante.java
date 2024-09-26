package co.edu.uniquindio.poo;
import java.util.Collection;
import java.util.LinkedList;

public class Estudiante extends Persona {
    private int edad;
    private Collection<Prestamo> prestamos;

    public Estudiante(String nombre, String cedula, int telefono, String correo, int edad) {
        super(nombre, cedula, telefono, correo);
        this.edad = edad;
        prestamos = new LinkedList<>();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Estudiante [" + super.toString() + ", edad=" + edad + ", prestamos=" + prestamos + "]";
    }

}
