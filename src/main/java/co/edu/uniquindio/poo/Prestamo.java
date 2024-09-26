package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Prestamo {
    private LocalDate fechaPrestamo, fechaEntrega;
    private double costoDia;
    private String codigo;
    private Bibliotecario bibliotecario;
    private LinkedList<DetallePrestamo> listaDetallesPrestamo;
    private double total;

    public Prestamo(String codigo, Libro libro, LocalDate fechaPrestamo, LocalDate fechaEntrega,
            Bibliotecario bibliotecario, LinkedList<DetallePrestamo> listaDetallePrestamos, double total) {
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.bibliotecario = bibliotecario;
        listaDetallePrestamos = new LinkedList<>();
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

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

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Prestamo [codigo=" + codigo + ", libro="  + ", fechaPrestamo=" + fechaPrestamo
                + ", fechaEntrega=" + fechaEntrega + ", bibliotecario=" + bibliotecario + ", total=" + total + "]";
    }

    
    
}
