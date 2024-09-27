package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.LocalDate;

public class Biblioteca {
    private String nombre;
    private Collection<Estudiante> estudiantes;
    private Collection<Bibliotecario> bibliotecarios;
    private Collection<Prestamo> prestamos;
    private Collection<Libro> libros;
    private double ganancia;
    private int cantidadLibros;

    public Biblioteca(String nombre, double ganancia, int cantidadLibros) {

        estudiantes = new LinkedList<>();
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
        this.nombre = nombre;
        this.ganancia = ganancia;
        this.cantidadLibros = cantidadLibros;

    }

    // -------------------------------Métodos Get y Set de la clase
    // Biblioteca-----------------------//

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

    // ---------------------------------------------------------------------------------------------------//
    public void crearNuevoLibro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();

        System.out.print("Fecha de publicación (aaaa-mm-dd): ");
        LocalDate fecha = LocalDate.parse(scanner.nextLine());

        System.out.print("Estado (DISPONIBLE o AGOTADO):");
        Estado estado = Estado.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Costo: ");
        double costo = scanner.nextDouble();

        System.out.print("Unidades Disponibles: ");
        int unidadesDisponibles = scanner.nextInt();

        Libro libro = new Libro(titulo, codigo, isbn, unidadesDisponibles, autor, editorial, fecha, estado, costo);

        agregarLibro(libro);
    }

    public void crearNuevoEstudiante() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Teléfono: ");
        int telefono = scanner.nextInt();

        System.out.print("Correo:");
        String correo = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();

        Estudiante estudiante = new Estudiante(nombre, cedula, telefono, correo, edad);

        agregarEstudiante(estudiante);
    }

    public void crearNuevoBibliotecario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre del bibliotecario:");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa la cedula del bibliotecario:");
        String cedula = scanner.nextLine();

        System.out.println("Ingresa el telefono de bibliotecario:");
        int telefono = scanner.nextInt();

        System.out.println("Ingresa el correo del bibliotecario:");
        String correo = scanner.nextLine();

        System.out.println("Ingresa la antiguedad del bibliotecario:");
        int antiguedad = scanner.nextInt();

        Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula, telefono, correo, antiguedad);

        agregarBibliotecario(bibliotecario);
    }

    public boolean verificarEstudiante(String cedula) {
        boolean centinela = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarBibliotecario(String cedula) {
        boolean centinela = false;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarLibro(String codigo) {
        boolean centinela = false;
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarPrestamo(String codigo) {
        boolean centinela = false;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (!verificarEstudiante(estudiante.getCedula())) {
            estudiantes.add(estudiante);
        }
    }

    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        if (!verificarBibliotecario(bibliotecario.getCedula())) {
            bibliotecarios.add(bibliotecario);
        }
    }

    public void agregarLibro(Libro libro) {
        if (!verificarLibro(libro.getCodigo())) {
            libros.add(libro);
        }
    }

    public void agregarPrestamo(Prestamo prestamo) {
        if (!verificarPrestamo(prestamo.getCodigo())) {
            prestamos.add(prestamo);
        }
    }

    public void eliminarPrestamo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamos.remove(prestamo);
            }
        }
    }

    public void eliminarEstudiante(String cedula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                estudiantes.remove(estudiante);
            }
        }
    }

    public void eliminarBibliotecario(String cedula) {
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                bibliotecarios.remove(bibliotecario);
            }
        }
    }

    public void eliminarLibro(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                libros.remove(libro);
            }
        }
    }

    public int unidadesLibroEnPrestamos(String titulo) {
        int cantidadPrestamos = 0;
        for (Prestamo prestamo : prestamos) {
            for (DetallePrestamo detallePrestamo : prestamo.getListaDetallesPrestamo()) {
                if (detallePrestamo.getLibro().getTitulo().equals(titulo)) {
                    cantidadLibros += 1;
                }
            }
        }
        return cantidadPrestamos;
    }

    public void mostrarDetallesLibro(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                System.out.println(libro.toString());
            }
        }
    }

    public void sobreescribirLibro(String codigo) {
        Scanner scanner = new Scanner(System.in);
        for (Libro libro : libros) {

            if (libro.getCodigo().equals(codigo)) {
                System.out.println("A continuación, ingrese los nuevos datos del libro:");

                System.out.print("Título: ");
                String nuevoTitulo = scanner.nextLine();
                libro.setTitulo(nuevoTitulo);

                System.out.println("ISBN: ");
                String nuevoIsbn = scanner.nextLine();
                libro.setIsbn(nuevoIsbn);

                System.out.println("Autor: ");
                String nuevoAutor = scanner.nextLine();
                libro.setAutor(nuevoAutor);

                System.out.println("Editorial: ");
                String nuevaEditorial = scanner.nextLine();
                libro.setEditorial(nuevaEditorial);

                System.out.println("Nueva fecha de publicación (aaaa-mm-dd):");
                LocalDate nuevaFecha = LocalDate.parse(scanner.nextLine());
                libro.setFecha(nuevaFecha);

                System.out.println("Nuevo estado (DISPONIBLE o AGOTADO):");
                Estado nuevoEstado = Estado.valueOf(scanner.nextLine().toUpperCase());
                libro.setEstado(nuevoEstado);

                System.out.println("Nuevo costo:");
                double nuevoCosto = scanner.nextDouble();
                libro.setCosto(nuevoCosto);

                System.out.println("Nuevas unidades disponibles:");
                int nuevasUnidades = scanner.nextInt();
                libro.setUnidadesDisponibles(nuevasUnidades);

                // Actualizamos el estado según la cantidad de unidades disponibles
                libro.actualizarEstado(nuevasUnidades);

                System.out.println("Los datos del libro se han actualizado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún libro con el código especificado.");
    }

    public void consultarPrestamo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                System.out.println(prestamo.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", estudiantes=" + estudiantes + ", bibliotecarios=" + bibliotecarios
                + ", prestamos=" + prestamos + ", libros=" + libros + ", ganancia=" + ganancia + ", cantidadLibros="
                + cantidadLibros + "]";
    }

}