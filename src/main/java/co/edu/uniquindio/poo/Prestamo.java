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

    // -----------Métodos Get y Set de la clase Prestamo------------//

    /**
     * Método para obtener la fecha inicial del prestamo
     * @return fechaPrestamo
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Método para modificar la fecha inicial del prestamo
     * @param fechaPrestamo
     */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Método para obtener la fecha de entrega de un prestamo
     * @return fechaEntrega
     */
    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Método para modificar la fecha de entrega de un prestamo
     * @param fechaEntrega
     */
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Método para obtener el código de un prestamo
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método para modificar el código de un prestamo
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método para obtener el bibliotecario que asignó el prestamo
     * @return bibliotecario
     */
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    /**
     * Método para modificar el bibliotecario que asignó el prestamo
     * @param bibliotecario
     */
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    /**
     * Método para obtener el estudiante que realizó el prestamo
     * @return estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * Método para modificar el estudiante que realizó el prestamo
     * @param estudiante
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Método para obtener la lista de detalles del prestamo
     * @return listaDetallesPrestamo
     */
    public LinkedList<DetallePrestamo> getListaDetallesPrestamo() {
        return listaDetallesPrestamo;
    }

    /**
     * Método para modificar la lista de detalles del prestamo
     * @param listaDetallesPrestamo
     */
    public void setListaDetallesPrestamo(LinkedList<DetallePrestamo> listaDetallesPrestamo) {
        this.listaDetallesPrestamo = listaDetallesPrestamo;
    }

    /**
     * Método para obtener el costo total del prestamo
     * @return total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Método para modificar el costo total del prestamo
     * @param total
     */
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
