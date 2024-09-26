package co.edu.uniquindio.poo;
import java.util.Collection;
import java.util.LinkedList;


public class Biblioteca {
    private String nombre;
    private Collection<Estudiante> estudiantes;
    private Collection<Bibliotecario> bibliotecarios;
    private Collection<Prestamo> prestamos;
    private Collection<Libro> libros;
    private double ganancia;
    private int cantidadLibros;

    
    public Biblioteca(String nombre, double ganancia, int cantidadLibros){

        estudiantes = new LinkedList<>();
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
        this.nombre = nombre;
        this.ganancia = ganancia;
        this.cantidadLibros = cantidadLibros;

    }

    //-------------------------------Métodos Get y Set de la clase Biblioteca-----------------------//

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    public void setEstudiantes(Collection<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }



    public Collection<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }
    
    public void setBibliotecarios(Collection<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }



    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }



    public Collection<Libro> getLibros() {
        return libros;
    }
    
    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }



    public double getGanancia() {
        return ganancia;
    }
    
    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }



    public int getCantidadLibros() {
        return cantidadLibros;
    }
    
    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }


    //---------------------------------------------------------------------------------------------------//


    public boolean verificarEstudiante(String cedula){
        boolean centinela = false;
        for (Estudiante estudiante : estudiantes) {
            if(estudiante.getCedula().equals(cedula)){
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarBibliotecario(String cedula){
        boolean centinela = false;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if(bibliotecario.getCedula().equals(cedula)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarLibro(String codigo){
        boolean centinela = false;
        for (Libro libro : libros) {
            if(libro.getCodigo().equals(codigo)){
                centinela = true;
                break;
            }
        }
        return centinela;
    }

        
    public boolean verificarPrestamo(String codigo){
        boolean centinela = false;
        for(Prestamo prestamo : prestamos){
            if(prestamo.getCodigo().equals(codigo)){
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public void agregarEstudiante(Estudiante estudiante){
        if(!verificarEstudiante(estudiante.getCedula())){
            estudiantes.add(estudiante);
        }
    }

    public void agregarBibliotecario(Bibliotecario bibliotecario){
        if(!verificarBibliotecario(bibliotecario.getCedula())){
            bibliotecarios.add(bibliotecario);
        }
    }       

    public void agregarLibro(Libro libro){
        if(!verificarLibro(libro.getCodigo())){
            libros.add(libro);
        }
    }

    public void agregarPrestamo(Prestamo prestamo){
        if(!verificarPrestamo(prestamo.getCodigo())){
            prestamos.add(prestamo);
        }
    }

    
    public void eliminarPrestamo(String codigo){
        for(Prestamo prestamo : prestamos){
            if(prestamo.getCodigo().equals(codigo)){
                prestamos.remove(prestamo);
            }
        }
    }

    public void eliminarEstudiante(String cedula){
        for(Estudiante estudiante : estudiantes){
            if(estudiante.getCedula().equals(cedula)){
                estudiantes.remove(estudiante);
            }
        }
    }

    public void eliminarBibliotecario(String cedula){
        for(Bibliotecario bibliotecario: bibliotecarios){
            if(bibliotecario.getCedula().equals(cedula)){
                bibliotecarios.remove(bibliotecario);
            }
        }
    }

    public void eliminarLibro(String codigo){
        for (Libro libro : libros){
            if(libro.getCodigo().equals(codigo)){
                libros.remove(libro);
            }
        }
    }

    public int unidadesLibroEnPrestamos(String titulo){
        int cantidadPrestamos = 0;
        for (Prestamo prestamo : prestamos) {
            for (DetallePrestamo detallePrestamo  : prestamo.getListaDetallesPrestamo()){
                if(detallePrestamo.getLibro().getTitulo().equals(titulo)){
                    cantidadLibros += 1;
                }
            } 
        }
        return cantidadPrestamos;
    }

    
    


    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", estudiantes=" + estudiantes + ", bibliotecarios=" + bibliotecarios
                + ", prestamos=" + prestamos + ", libros=" + libros + ", ganancia=" + ganancia + ", cantidadLibros="
                + cantidadLibros + "]";
    }
    
    
}