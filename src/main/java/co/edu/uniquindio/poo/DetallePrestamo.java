package co.edu.uniquindio.poo;

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
     * Método para modificar la disponibilidad del libro a prestar
     * 
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
     * Método para agregar el libro solicitado a un detalle del prestamo
     * 
     * @param codigo   del libro
     * @param cantidad de unidades solicitadas del libro
     * @param libro    a prestar
     */
    public void agregarLibroADetalle(int cantidad, Libro libro) {
        if (verificarDisponibilidadLibro(cantidad, libro)) {
            setLibro(libro);
            actualizarUnidadesLibro(cantidad);
        }
    }

    /**
     * Método para actualizar las unidades disponibles del libro luego de realizar
     * el prestamo
     * 
     * @param cantidad de unidades solicitadas
     */
    public void actualizarUnidadesLibro(int cantidad) {
        libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() - cantidad);
    }

    /**
     * Método toString de la clase DetallePrestamo
     */
    @Override
    public String toString() {
        return "DetallePrestamo [subtotal=" + subtotal + ", cantidad=" + cantidad + ", libro=" + libro + "]";
    }

}
