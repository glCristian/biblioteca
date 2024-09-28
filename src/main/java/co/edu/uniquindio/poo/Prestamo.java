package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Prestamo {
    private LocalDate fechaPrestamo, fechaEntrega;
    private String codigo;
    private Bibliotecario bibliotecario;
    private Estudiante estudiante;
    private LinkedList<DetallePrestamo> listaDetallesPrestamo;
    private double total;

    /**
     * Método constructor de la clase Prestamo
     * 
     * @param fechaPrestamo del prestamo
     * @param codigo        del prestamo
     * @param bibliotecario del prestamo
     * @param estudiante    del prestamo
     */
    public Prestamo(LocalDate fechaPrestamo, String codigo, Bibliotecario bibliotecario, Estudiante estudiante) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = null;
        this.codigo = codigo;
        this.bibliotecario = bibliotecario;
        this.estudiante = estudiante;
        this.total = 0;
        listaDetallesPrestamo = new LinkedList<>();
    }

    // ---------------------------------------------Métodos Get y Set de la clase
    // Prestamo--------------------------//

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LinkedList<DetallePrestamo> getListaDetallesPrestamo() {
        return listaDetallesPrestamo;
    }

    public void setListaDetallesPrestamo(LinkedList<DetallePrestamo> listaDetallesPrestamo) {
        this.listaDetallesPrestamo = listaDetallesPrestamo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Método para agregar un detallePrestamo al prestamo
     * 
     * @param detallePrestamo
     */
    public void agregarDetallePrestamo(DetallePrestamo detallePrestamo) {
        listaDetallesPrestamo.add(detallePrestamo);
    }

    /**
     * Método para calcular el costo total del prestamo de acuerdo a los libros y
     * unidades solicitadas en el prestamo
     * 
     * @return
     */
    public double calcularTotal() {
        double total = 0;
        for (DetallePrestamo detallePrestamo : listaDetallesPrestamo) {
            total += detallePrestamo.getSubtotal();
        }
        return total;
    }

    /**
     * Método toString de la clase Prestamo
     */
    @Override
    public String toString() {
        return "Prestamo [fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega + ", costoDia="
                + ", codigo=" + codigo + ", bibliotecario=" + bibliotecario + ", estudiante =" + estudiante
                + "listaDetallesPrestamo="
                + listaDetallesPrestamo + ", total=" + total + "]";
    }

}
