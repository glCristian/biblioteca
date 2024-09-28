package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Bibliotecario extends Persona {
    private double salario;
    private int antiguedad;
    private Collection<Prestamo> prestamos;

    /**
     * Método constructor de la clase Bibliotecario
     * 
     * @param nombre     del bibliotecario
     * @param cedula     del bibliotecario
     * @param telefono   del bibliotecario
     * @param correo     del bibliotecario
     * @param antiguedad del bibliotecario
     */
    public Bibliotecario(String nombre, String cedula, int telefono, String correo, int antiguedad) {
        super(nombre, cedula, telefono, correo);
        this.antiguedad = antiguedad;
        prestamos = new LinkedList<>();
        this.salario = calcularSalario(antiguedad);
    }

    // --------Métodos Get y Set de la clase Bibliotecario----------//

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
     * 
     * @return antiguedad
     */
    public int getAntiguedad() {
        return antiguedad;
    }

    /**
     * Método para modificar los años de antigüedad de un bibliotecario
     * 
     * @param antiguedad
     */
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    /**
     * Método para obtener la lista de prestamos de un bibliotecario
     * 
     * @return prestamos
     */
    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Método para modificar la lista de prestamos de un bibliotecario
     * 
     * @param prestamos
     */
    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    // -------------------------------------------------------------//

    /**
     * Método para calcular el salario de un bibliotecario
     * 
     * @param antiguedad del bibliotecario
     * @return total
     */
    public double calcularSalario(int antiguedad) {
        double total = 0;
        for (Prestamo prestamo : prestamos) {
            double valorPrestamo = prestamo.getTotal();
            total += valorPrestamo * 0.2;
        }
        total += (total * 0.2) * antiguedad;
        return total;
    }

    /**
     * Método toString de la clase Bibliotecario
     */
    @Override
    public String toString() {
        return "Bibliotecario [" + super.toString() + ", salario=" + salario + ", antiguedad=" + antiguedad
                + ", prestamos=" + prestamos + "]";
    }
}
