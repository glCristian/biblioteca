package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Libro {
    private String titulo, codigo, isbn, autor, editorial;
    private int unidadesDisponibles;
    private LocalDate fecha;
    private boolean estado;

    /**
     * Método constructor de la clase Libro
     * 
     * @param titulo              del libro
     * @param codigo              del libro
     * @param isbn                del libro
     * @param unidadesDisponibles del libro
     * @param autor               del libro
     * @param editorial           del libro
     * @param fecha               de publicación libro
     * @param estado              del libro
     */
    public Libro(String titulo, String codigo, String isbn, int unidadesDisponibles, String autor, String editorial,
            LocalDate fecha, Estado estado) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.isbn = isbn;
        this.unidadesDisponibles = unidadesDisponibles;
        this.autor = autor;
        this.editorial = editorial;
        this.fecha = fecha;
        this.estado = estado;
    }

    // ---------------------Métodos get y set de la clase------------------//
    /**
     * Método para obtener el título de un libro
     * 
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método para modificar el título de un libro
     * 
     * @param titulo del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método para obtener el código de un libro
     * 
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método para modificar el código de un libro
     * 
     * @param codigo del libro
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método para obtener el ISBN de un libro
     * 
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Método para modificar el ISBN de un libro
     * 
     * @param isbn del libro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Método para obtener la cantidad de unidades disponibles de un libro
     * 
     * @return unidadesDisponibles
     */
    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    /**
     * Método para modificar la cantidad de unidades disponibles de un libro
     * 
     * @param unidadesDisponibles del libro
     */
    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    /**
     * Método para obtener el nombre del autor de un libro
     * 
     * @return autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Método para modificar el nombre del autor de un libro
     * 
     * @param autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Método para obtener la editorial de un libro
     * 
     * @return editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Método para modificar la editorial de un libro
     * 
     * @param editorial del libro
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Método para obtener la fecha de publicación de un libro
     * 
     * @return fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Método para modificar la fecha de publicación de un libro
     * 
     * @param fecha del libro
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Método para obtener el estado de un libro
     * 
     * @return estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Método para modificar el estado de un libro
     * 
     * @param estado del libro
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    // --------------------------------------------------------------------//

    /**
     * Método toString de la clase Libro
     */
    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", codigo=" + codigo + ", isbn=" + isbn + ", unidadesDisponibles="
                + unidadesDisponibles + ", autor=" + autor + ", editorial=" + editorial + ", fecha=" + fecha
                + ", estado=" + estado + "]";
    }

}