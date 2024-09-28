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

    /**
     * Método constructor de la clase Biblioteca
     * 
     * @param nombre         de la biblioteca
     * @param ganancia       de la biblioteca
     * @param cantidadLibros de la biblioteca
     */
    public Biblioteca(String nombre, double ganancia, int cantidadLibros) {

        estudiantes = new LinkedList<>();
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
        this.nombre = nombre;
        this.ganancia = ganancia;
        this.cantidadLibros = cantidadLibros;

    }

    // ----------Métodos Get y Set de la clase Biblioteca-----------//

    /**
     * Método para obtener el nombre de la biblioteca
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para modificar el nombre de la biblioteca
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la lista de estudiantes de la biblioteca
     * @return
     */
    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    /**
     * Método para modificar la lista de estudiantes de la biblioteca
     * @param estudiantes
     */
    public void setEstudiantes(Collection<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    /**
     * Método para obtener la lista de bibliotecarios de la biblioteca
     * @return
     */
    public Collection<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    /**
     * Método para modificar la lista de bibliotecarios de la biblioteca
     * @param bibliotecarios
     */
    public void setBibliotecarios(Collection<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    /**
     * Método para obtener la lista de prestamos de la biblioteca
     * @return 
     */
    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Método para modificar la lista de prestamos de la biblioteca
     * @param prestamos
     */
    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * Método para obtener la lista de libros de la biblioteca
     * @return
     */
    public Collection<Libro> getLibros() {
        return libros;
    }

    /**
     * Método para modificar la lista de libros de la biblioteca
     * @param libros
     */
    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Método para obtener la ganancia total de la biblioteca
     * @return
     */
    public double getGanancia() {
        return ganancia;
    }

    /**
     * Método para modificar la ganancia total de la biblioteca
     * @param ganancia
     */
    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    /**
     * Método para obtener la cantidad de libros de la biblioteca
     * @return
     */
    public int getCantidadLibros() {
        return cantidadLibros;
    }

    /**
     * Método para modificar la lista de libros de la biblioteca
     * @param cantidadLibros
     */
    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    // ---------------------------------------------------------------------------------------------------//


    // ---------------------CRUD Bibliotecario--------------------//

    /**
     * Método para crear un nuevo bibliotecario y agregarlo automáticamente a la biblioteca
     */
    public void crearNuevoBibliotecario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.println("Teléfono: ");
        int telefono = scanner.nextInt();

        System.out.println("Correo: ");
        String correo = scanner.nextLine();

        System.out.println("Años de antigüedad: ");
        int antiguedad = scanner.nextInt();

        Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula, telefono, correo, antiguedad);

        agregarBibliotecario(bibliotecario);
    }

    /**
     * Método para evitar la creación de bibliotecarios duplicados
     * @param cedula del bibliotecario creado
     * @return centinela
     */
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

    /**
     * Método para agregar un nuevo bibliotecario a la lista de bibliotecarios de la biblioteca
     * @param bibliotecario
     */
    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        if (!verificarBibliotecario(bibliotecario.getCedula())) {
            bibliotecarios.add(bibliotecario);
        }
    }

    /**
     * Método para mostrar los detalles de un bibliotecario dada su cédula
     * @param cedula del bibliotecario
     */
    public void mostrarDetallesBibliotecario(String cedula) {
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                System.out.println(bibliotecario);
            }
        }
    }

    /**
     * Método para eliminar un bibliotecario de la biblioteca dada su cédula
     * @param cedula del bibliotecario
     */
    public void eliminarBibliotecario(String cedula) {
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                bibliotecarios.remove(bibliotecario);
            }
        }
    }

    // -----------------------------------------------------------//


    // ---------------------CRUD Estudiante----------------------//

    /**
     * Método para crear un nuevo estudiante y agregarlo automáticamente a la biblioteca
     */
    public void crearNuevoEstudiante() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Teléfono: ");
        int telefono = scanner.nextInt();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();

        Estudiante estudiante = new Estudiante(nombre, cedula, telefono, correo, edad);

        agregarEstudiante(estudiante);
    }

    /**
     * Método para evitar la creación de estudiantes duplicados
     * @param cedula del estudiante creado
     * @return centinela
     */
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

    /**
     * Método para agregar un nuevo estudiante a la lista de estudiantes de la biblioteca
     * @param estudiante
     */
    public void agregarEstudiante(Estudiante estudiante) {
        if (!verificarEstudiante(estudiante.getCedula())) {
            estudiantes.add(estudiante);
        }
    }

    /**
     * Método para mostrar los detalles de un estudiante dada su cédula
     * @param cedula del estudiante
     */
    public void mostrarDetallesEstudiante(String cedula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                System.out.println(estudiante);
            }
        }
    }

    /**
     * Método para eliminar un estudiante de la biblioteca dada su cédula
     * @param cedula del estudiante
     */
    public void eliminarEstudiante(String cedula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                estudiantes.remove(estudiante);
            }
        }
    }

    // -----------------------------------------------------------//


    // ------------------------CRUD Libro-------------------------//

    /**
     * Método para crear un nuevo libro, agregarlo a la biblioteca y establecer su estado según las unidades disponibles del mismo
     */
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

        System.out.print("Costo: ");
        double costo = scanner.nextDouble();

        System.out.print("Unidades Disponibles: ");
        int unidadesDisponibles = scanner.nextInt();

        Libro libro = new Libro(titulo, codigo, isbn, unidadesDisponibles, autor, editorial, fecha, costo);

        agregarLibro(libro);
    }

    /**
     * Método para evitar la creación de libros duplicados
     * @param codigo del libro creado
     * @return centinela
     */
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

    /**
     * Método para agregar un nuevo libro a la lista de libros de la biblioteca
     * @param libro
     */
    public void agregarLibro(Libro libro) {
        if (!verificarLibro(libro.getCodigo())) {
            libros.add(libro);
        }
    }

    /**
     * Método para mostrar los detalles de un libro dado su código
     * @param codigo del libro
     */
    public void mostrarDetallesLibro(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                System.out.println(libro);
            }
        }
    }

    /**
     * Método para modificar los datos de un libro existente (sobreescribir un libro) dado su código
     * @param codigo del libro
     */
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

                System.out.println("Nuevo costo:");
                double nuevoCosto = scanner.nextDouble();
                libro.setCosto(nuevoCosto);

                System.out.println("Nuevas unidades disponibles:");
                int nuevasUnidades = scanner.nextInt();
                libro.setUnidadesDisponibles(nuevasUnidades);

                libro.actualizarEstado(nuevasUnidades);

                System.out.println("Los datos del libro se han actualizado exitosamente.");
            }
        }
        System.out.println("No se encontró ningún libro con el código especificado.");
    }

    /**
     * 
     * @param codigo
     */
    public void eliminarLibro(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                libros.remove(libro);
            }
        }
    }

    // ------------------------------------------------------------//


    // ---------------------CRUD Prestamo--------------------------//

    public void crearNuevoPrestamo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Código: ");
        String codigo = scanner.nextLine();

        System.out.println("Ingrese la cédula del Bibliotecario: ");
        String cedulaBibliotecario = scanner.nextLine();
        Bibliotecario bibliotecarioPrestamo = null;

        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedulaBibliotecario)) {
                bibliotecarioPrestamo = bibliotecario;
                break;
            }
        }

        if (bibliotecarioPrestamo == null) {
            System.out.println("No se encontró un bibliotecario con esa cédula.");
            return;
        }

        System.out.println("Ingrese la cédula del Estudiante: ");
        String cedulaEstudiante = scanner.nextLine();
        Estudiante estudiantePrestamo = null;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedulaEstudiante)) {
                estudiantePrestamo = estudiante;
                break;
            }
        }

        if (estudiantePrestamo == null) {
            System.out.println("No se encontró un estudiante con esa cédula.");
            return;
        }

        Prestamo prestamo = new Prestamo(LocalDate.now(), codigo, bibliotecarioPrestamo, estudiantePrestamo);

        bibliotecarioPrestamo.getPrestamos().add(prestamo);
        estudiantePrestamo.getPrestamos().add(prestamo);

        agregarPrestamo(prestamo);

        System.out.println("Préstamo creado exitosamente.");
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

    public void agregarPrestamo(Prestamo prestamo) {
        if (!verificarPrestamo(prestamo.getCodigo())) {
            prestamos.add(prestamo);
        }
    }

    public void consultarPrestamo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                System.out.println(prestamo.toString());
            }
        }
    }

    public void eliminarPrestamo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamos.remove(prestamo);
            }
        }
    }

    // ------------------------------------------------------------//


    /**
     * Método para consultar la cantidad de prestamos en la cuál está incluido un
     * libro
     * 
     * @param titulo del libro
     * @return cantidadPrestamos
     */
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

    /**
     * Método para entregar un prestamo con fecha del día actual
     * 
     * @param codigo del prestamo a entregar
     */
    public void entregarPrestamo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamo.setFechaEntrega(LocalDate.now());
                double total = prestamo.calcularTotal();
                prestamo.setTotal(total);
                System.out.println("Prestamo entregado correctamente (" + LocalDate.now()
                        + "), el costo total del prestamo es: $" + prestamo.getTotal());
            }
        }
    }

    // Agregar un método para mostrar la cantidad de préstamos realizados por cada
    // empleado

    // Agregar un método para imprimir el estudiante con mayor cantidad de prestamos

    // Agregar un método para calcular el total de dinero a pagar a los
    // bibliotecarios

    // Agregar un método para calcular el total de dinero recaudado por la
    // biblioteca, teniendo en cuenta el dinero a pagar a los bibliotecarios

    /**
     * Método toString de la clase Biblioteca
     */
    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", estudiantes=" + estudiantes + ", bibliotecarios=" + bibliotecarios
                + ", prestamos=" + prestamos + ", libros=" + libros + ", ganancia=" + ganancia + ", cantidadLibros="
                + cantidadLibros + "]";
    }

}