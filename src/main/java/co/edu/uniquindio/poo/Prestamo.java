package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Prestamo {
    private LocalDate fechaPrestamo, fechaEntrega;
    private String codigo;
    private Bibliotecario bibliotecario;
    private LinkedList<DetallePrestamo> listaDetallesPrestamo;
    private double total;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, String codigo,
            Bibliotecario bibliotecario, double total) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.codigo = codigo;
        this.bibliotecario = bibliotecario;
        this.total = total;
        listaDetallesPrestamo = new LinkedList<>();
    }

    //---------------------------------------------Métodos Get y Set de la clase Prestamo--------------------------//
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

    //----------------------------------------------------------------------------------------------------------------------------------------------//


    public void agregarDetallePrestamo(DetallePrestamo detallePrestamo){
            listaDetallesPrestamo.add(detallePrestamo);
        }
 
    @Override
    public String toString() {
        return "Prestamo [fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega + ", costoDia=" 
                + ", codigo=" + codigo + ", bibliotecario=" + bibliotecario + ", listaDetallesPrestamo="
                + listaDetallesPrestamo + ", total=" + total + "]";
    }

}
