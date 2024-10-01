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
    public Bibliotecario(String nombre, String cedula, String telefono, String correo, int antiguedad) {
        super(nombre, cedula, telefono, correo);
        this.antiguedad = antiguedad;
        prestamos = new LinkedList<>();
        this.salario = calcularSalario();
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
     * @param antiguedad del bibliotecario
     * @return total
     */
    public double calcularSalario() {
        double salarioTotal = 0;
    
        for (Prestamo prestamo : prestamos) {
            double subTotal = prestamo.getTotal()*0.2;
            double totalGanancia = subTotal + ((subTotal*0.02)*antiguedad);
            salarioTotal += totalGanancia;
        }
    
        setSalario(salarioTotal);
        
        return salarioTotal;
    }

    /**
     * Método que obtiene el numero de prestamos realizados por el bibliotecario
     * @return tamaño de la lista de prestamos
     */
    public int obtenerCantidadPrestamosRealizados() {
        return prestamos.size();
    }


    /**
     * Método toString de la clase Bibliotecario
     */
    @Override
    public String toString() {
        return "Bibliotecario [" + super.toString() + ", salario=" + salario + ", antiguedad=" + antiguedad + "\n" 
        + "prestamos=" + "\n" + prestamos + "]";
    }
}
