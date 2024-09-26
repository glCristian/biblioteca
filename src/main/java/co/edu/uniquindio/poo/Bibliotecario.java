package co.edu.uniquindio.poo;
import java.util.Collection;

public class Bibliotecario extends Persona {
    private double salario;
    private int antiguedad;
    private Collection<Prestamo> prestamos;


    public Bibliotecario(String nombre, String cedula, int telefono, String correo, double salario) {
        super(nombre, cedula, telefono, correo);
        this.salario = salario;
    }

    /**
     * Método para obtener el salario de un bibliotecario
     * 
     * @return salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Método para modificar el salario de un bibliotecario
     * 
     * @param salario del bibliotecario
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Método para obtener los años de antigüedad de un bibliotecario
     * @return antiguedad
     */
    public int getAntiguedad(){
        return antiguedad;
    }

    /**
     * Método para modificar los años de antigüedad de un bibliotecario 
     * @param antiguedad del bibliotecario
     */
    public void setAntiguedad(int antiguedad){
        this.antiguedad = antiguedad;
    }
    /**
     * Método toString de la clase Bibliotecario
     */
    @Override
    public String toString() {
        return "Bibliotecario [" + super.toString() + "salario=" + salario + "]";
    }
}
