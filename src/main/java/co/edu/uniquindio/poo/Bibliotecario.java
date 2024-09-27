package co.edu.uniquindio.poo;
import java.util.Collection;
import java.util.LinkedList;

public class Bibliotecario extends Persona {
    private double salario;
    private int antiguedad;
    private Collection<Prestamo> prestamos;

    public Bibliotecario(String nombre, String cedula, int telefono, String correo,  int antiguedad){
        super(nombre, cedula, telefono, correo);
        this.antiguedad = antiguedad;
        prestamos = new LinkedList<>();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Bibliotecario [" + super.toString() + ", salario=" + salario + ", antiguedad=" + antiguedad + ", prestamos=" + prestamos + "]";
    }
}
