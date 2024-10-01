package co.edu.uniquindio.poo;

import java.util.Scanner;

public class DetallePrestamo {
    private Libro libro;
    private int cantidad;
    private double subtotal;

    /**
     * Método constructor de la clase DetallePrestamo
     * 
     * @param subtotal del costo del prestamo
     * @param cantidad de unidades del libro
     * @param libro    a prestar
     */
    public DetallePrestamo(Libro libro, int cantidad) {
        this.libro = libro;
        this.cantidad = cantidad;
        this.subtotal = libro.getCosto() * cantidad;
    }

    // -------Métodos Get y Set de la clase DetallePrestamo---------//

    /**
     * Método para obtener el subtotal del prestamo
     * 
     * @return subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Método para modificar el subtotal del prestamo
     * 
     * @param subtotal del prestamo
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Método para obtener la cantidad de unidades del libro a prestar
     * 
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Método para modificar la cantidad de unidades del libro a prestar
     * 
     * @param cantidad de unidades del libro a prestar
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método para obtener el libro a prestar
     * 
     * @return libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Método para modificar el libro a prestar
     * 
     * @param libro a prestar
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    // ----------------------------------------------------------------------------------------------------------

    /**
     * Método para verificar la disponibilidad del libro a prestar
     * @param cantidad de unidades solicitadas
     * @param libro    a prestar
     * @return centinela
     */
    public boolean verificarDisponibilidadLibro(int cantidad, Libro libro) {
        boolean centinela = true;
        if (cantidad > libro.getUnidadesDisponibles()) {
            centinela = false;
        }
        return centinela;
    }

  /**
     * Método para agregar el libro solicitado a un detalle del préstamo.
     * Si la cantidad solicitada es mayor que las unidades disponibles, se
     * pedirá nuevamente la cantidad hasta que sea válida.
     * @param cantidad de unidades solicitadas del libro
     * @param libro    a prestar
     * @param scanner  reutilizado de la clase principal
     */
    public void agregarLibroADetalle(int cantidad, Libro libro, Scanner scanner) {
        boolean cantidadValida = false;

        while (!cantidadValida) {

            if (verificarDisponibilidadLibro(cantidad, libro)) {
                setLibro(libro);
                setCantidad(cantidad);
                actualizarUnidadesLibro(cantidad);
                subtotal = libro.getCosto() * cantidad;
                cantidadValida = true;

            } else {
                System.out.println("No hay suficientes unidades disponibles del libro solicitado. Por favor, ingrese una cantidad menor.");
                System.out.print("Ingrese la cantidad de unidades del libro: ");
                cantidad = scanner.nextInt();
            }
        }
    }

    /**
     * Método para actualizar las unidades disponibles del libro luego de realizar
     * el prestamo
     * @param cantidad de unidades solicitadas
     */
    public void actualizarUnidadesLibro(int cantidad) {
        libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() - cantidad);
        libro.actualizarEstado(libro.getUnidadesDisponibles());
    }

    /**
     * Método toString de la clase DetallePrestamo
     */
    @Override
    public String toString() {
        return "DetallePrestamo [subtotal=" + subtotal + ", cantidad=" + cantidad + ", libro=" + libro.getTitulo() + "]" + "\n";
    }

}
