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

        mostrarMensaje("Nombre: ");
        String nombre = scanner.nextLine();

        String cedula;
        do {
            System.out.println("Cédula: ");
            cedula = scanner.nextLine();
            
            if (verificarBibliotecario(cedula)) {
                mostrarMensaje("Ya existe un bibliotecario con esa cédula. Por favor, ingrese una cédula diferente.");
            }
        } while (verificarBibliotecario(cedula));

        mostrarMensaje("Teléfono: ");
        String telefono = scanner.nextLine();

        mostrarMensaje("Correo: ");
        String correo = scanner.nextLine();

        mostrarMensaje("Años de antigüedad: ");
        int antiguedad = scanner.nextInt();

        Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula, telefono, correo, antiguedad);

        agregarBibliotecario(bibliotecario);
    }

    /**
     * Método para evitar la creación de bibliotecarios duplicados
     * @param cedula del bibliotecario creado
     * @return estado del centinela (true/false)
     */
    public boolean verificarBibliotecario(String cedula) {
        boolean centinela = false;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                return true;
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
    public String mostrarDetallesBibliotecario(String cedula) {
        String detalles = "";
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                detalles += bibliotecario.toString();
            }
        }
        return detalles;
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

        mostrarMensaje("Nombre: ");
        String nombre = scanner.nextLine();

        String cedula;
        do {
            mostrarMensaje("Cédula: ");
            cedula = scanner.nextLine();
            
            if (verificarEstudiante(cedula)) {
                mostrarMensaje("Ya existe un estudiante con esa cédula. Por favor, ingrese una cédula diferente.");
            }
        } while (verificarEstudiante(cedula));System.out.print("Cédula: ");

        mostrarMensaje("Teléfono: ");
        String telefono = scanner.nextLine();

        mostrarMensaje("Correo: ");
        String correo = scanner.nextLine();

        mostrarMensaje("Edad: ");
        int edad = scanner.nextInt();

        Estudiante estudiante = new Estudiante(nombre, cedula, telefono, correo, edad);

        agregarEstudiante(estudiante);
    }

    /**
     * Método para evitar la creación de estudiantes duplicados
     * @param cedula del estudiante creado
     * @return estado del centinela (true/false)
     */
    public boolean verificarEstudiante(String cedula) {
        boolean centinela = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return true;
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

        mostrarMensaje("Título: ");
        String titulo = scanner.nextLine();

        mostrarMensaje("Código: ");
        String codigo;
        do {
            mostrarMensaje("Cédula: ");
            codigo = scanner.nextLine();
            
            if (verificarLibro(codigo)) {
                mostrarMensaje("Ya existe un libro con ese código. Por favor, ingrese un código diferente.");
            }
        } while (verificarLibro(codigo));System.out.print("Código: ");

        mostrarMensaje("ISBN: ");
        String isbn = scanner.nextLine();

        mostrarMensaje("Autor: ");
        String autor = scanner.nextLine();

        mostrarMensaje("Editorial: ");
        String editorial = scanner.nextLine();

        mostrarMensaje("Fecha de publicación (aaaa-mm-dd): ");
        LocalDate fecha = LocalDate.parse(scanner.nextLine());

        mostrarMensaje("Costo: ");
        double costo = scanner.nextDouble();

        mostrarMensaje("Unidades Disponibles: ");
        int unidadesDisponibles = scanner.nextInt();

        Libro libro = new Libro(titulo, codigo, isbn, unidadesDisponibles, autor, editorial, fecha, costo);

        agregarLibro(libro);
    }

    /**
     * Método para evitar la creación de libros duplicados
     * @param codigo del libro creado
     * @return estado del centinela (true/false)
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
                mostrarMensaje("A continuación, ingrese los nuevos datos del libro:");

                mostrarMensaje("Título: ");
                String nuevoTitulo = scanner.nextLine();
                libro.setTitulo(nuevoTitulo);

                mostrarMensaje("ISBN: ");
                String nuevoIsbn = scanner.nextLine();
                libro.setIsbn(nuevoIsbn);

                mostrarMensaje("Autor: ");
                String nuevoAutor = scanner.nextLine();
                libro.setAutor(nuevoAutor);

                mostrarMensaje("Editorial: ");
                String nuevaEditorial = scanner.nextLine();
                libro.setEditorial(nuevaEditorial);

                mostrarMensaje("Nueva fecha de publicación (aaaa-mm-dd):");
                LocalDate nuevaFecha = LocalDate.parse(scanner.nextLine());
                libro.setFecha(nuevaFecha);

                mostrarMensaje("Nuevo costo:");
                double nuevoCosto = scanner.nextDouble();
                libro.setCosto(nuevoCosto);

                mostrarMensaje("Nuevas unidades");
                int nuevasUnidades = scanner.nextInt();
                libro.setUnidadesDisponibles(nuevasUnidades);

                libro.actualizarEstado(nuevasUnidades);

                mostrarMensaje("Los datos del libro se han actualizado exitosamente.");
            }
        }
        mostrarMensaje("No se encontró ningún libro con el código especificado.");
    }

    /**
     * Método para eliminar un libro dado su código
     * @param codigo del libro
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

    /**
     * 
     */
    public void crearNuevoPrestamo() {
        Scanner scanner = new Scanner(System.in);
    
        mostrarMensaje("Código: ");
        String codigo = scanner.nextLine();
    
        mostrarMensaje("Ingrese la cédula del Bibliotecario: ");
        String cedulaBibliotecario = scanner.nextLine();
        Bibliotecario bibliotecarioPrestamo = null;
    
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedulaBibliotecario)) {
                bibliotecarioPrestamo = bibliotecario;
                break;
            }
        }
    
        if (bibliotecarioPrestamo == null) {
            mostrarMensaje("No se encontró un bibliotecario con esa cédula.");
            return;
        }
    
        mostrarMensaje("Ingrese la cédula del Estudiante: ");
        String cedulaEstudiante = scanner.nextLine();
        Estudiante estudiantePrestamo = null;
    
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedulaEstudiante)) {
                estudiantePrestamo = estudiante;
                break;
            }
        }
    
        if (estudiantePrestamo == null) {
            mostrarMensaje("No se encontró un estudiante con esa cédula.");
            return;
        }
    
        Prestamo prestamo = new Prestamo(LocalDate.now(), codigo, bibliotecarioPrestamo, estudiantePrestamo);
        bibliotecarioPrestamo.getPrestamos().add(prestamo);
        estudiantePrestamo.getPrestamos().add(prestamo);
        agregarPrestamo(prestamo);
    
        // Bucle para agregar DetallePrestamo
        boolean agregarMasDetalles = true;
    
        while (agregarMasDetalles) {
            mostrarMensaje("Ingrese el código del libro que desea prestar: ");
            String codigoLibro = scanner.nextLine();
            Libro libroPrestamo = null;
    
            for (Libro libro : libros) {
                if (libro.getCodigo().equals(codigoLibro)) {
                    libroPrestamo = libro;
                    break;
                }
            }
    
            if (libroPrestamo == null) {
                mostrarMensaje("No se encontró un libro con ese código.");
                return;
            }
    
            mostrarMensaje("Ingrese la cantidad de unidades del libro: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada después de leer un entero
    
            // Crear el objeto DetallePrestamo
            DetallePrestamo detalle = new DetallePrestamo(libroPrestamo, cantidad);
    
            // Llamar al método agregarLibroADetalle de la instancia
            detalle.agregarLibroADetalle(cantidad, libroPrestamo);
    
            // Agregar el detalle al préstamo
            prestamo.agregarDetallePrestamo(detalle);
    
            mostrarMensaje("Detalle agregado exitosamente.");
    
            // Preguntar si desea agregar otro detalle
            mostrarMensaje("¿Desea agregar otro detalle al préstamo? (Si/No): ");
            String respuesta = scanner.nextLine();
    
            if (respuesta.equalsIgnoreCase("No")) {
                agregarMasDetalles = false;
            }
        }
    
        bibliotecarioPrestamo.getPrestamos().add(prestamo);
        estudiantePrestamo.getPrestamos().add(prestamo);
        agregarPrestamo(prestamo);
    
        mostrarMensaje("Préstamo creado exitosamente con sus detalles.");
    }
    

    /**
     * 
     * @param codigo
     * @return
     */
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

    /**
     * 
     * @param prestamo
     */
    public void agregarPrestamo(Prestamo prestamo) {
        if (!verificarPrestamo(prestamo.getCodigo())) {
            prestamos.add(prestamo);
        }
    }

    /**
     * 
     * @param codigo
     */
    public void consultarPrestamo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                System.out.println(prestamo);
            }
        }
    }

    /**
     * 
     * @param codigo
     */
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
                mostrarMensaje("Prestamo entregado correctamente (" + LocalDate.now()+ "), el costo total del prestamo es: $" + prestamo.getTotal());
            }
        }
    }


    /**
     * Método que obtiene el número de prestamos realizados por cada bibliotecario y muestra un mensaje 
     * @param cedula del bibliotecario 
     */
    public void obtenerCantidadPrestamosBibliotecario() {
        StringBuilder cantidadPrestamos = new StringBuilder();
        for (Bibliotecario bibliotecario : bibliotecarios) {
            cantidadPrestamos.append(bibliotecario.getNombre() + ": ");
            cantidadPrestamos.append(bibliotecario.obtenerCantidadPrestamosRealizados() + "\n");
        }
        System.out.print(cantidadPrestamos);
    }


    /**
     * Método que imprime el estudiante con más prestamos
     */
    public void obtenerEstudianteConMasPrestamos() {
        Estudiante estudianteConMasPrestamos = null;
        int maxPrestamos = 0;
    
        for (Estudiante estudiante : estudiantes) {
            int cantidadPrestamos = estudiante.getPrestamos().size();
    
            if (cantidadPrestamos > maxPrestamos) {
                maxPrestamos = cantidadPrestamos;
                estudianteConMasPrestamos = estudiante;
            }
        }
    
        mostrarMensaje("El estudiante con mas prestamos es: " + estudianteConMasPrestamos);
    }


    // Agregar un método para calcular el total de dinero a pagar a los
    // bibliotecarios
    public double totalPagarBibliotecarios (){
        double totalPagar = 0;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            totalPagar += bibliotecario.getSalario();
        }
        mostrarMensaje("El total a pagar a los bibliotecarios es: $" + totalPagar); 
        return totalPagar;
    }



    // Agregar un método para calcular el total de dinero recaudado por la
    // biblioteca, teniendo en cuenta el dinero a pagar a los bibliotecarios
    public void totalRecaudoBiblioteca(){
        double subTotal = 0;
        double  recaudo = 0;
        for (Prestamo prestamo : prestamos) {
            subTotal += prestamo.getTotal();
        }
        recaudo = subTotal - totalPagarBibliotecarios();
        mostrarMensaje("El recaudo total de la biblioteca es de: $" + recaudo);
    }

    // ------------------------------------------------------------//


    // -----Métodos para manejar selección del usuario-------------//

    public void gestionarBibliotecarios() {
        Scanner scanner = new Scanner(System.in);
        boolean activo = true;
    
        while (activo) {
            mostrarMensaje("\n" + "¿Qué desea hacer?");
            mostrarMensaje("1. Crear bibliotecario");
            mostrarMensaje("2. Buscar bibliotecario");
            mostrarMensaje("3. Eliminar bibliotecario");
            mostrarMensaje("4. Volver");
            
            char opcion = scanner.nextLine().charAt(0);
    
            switch (opcion) {
                case '1':
                    crearNuevoBibliotecario();
                    break;
                case '2':
                    mostrarMensaje("Ingrese la cedula del bibliotecario que desea buscar: ");
                    String cedulaBuscar = scanner.nextLine();
                    System.out.println(mostrarDetallesBibliotecario(cedulaBuscar));
                    break;
                case '3':
                    mostrarMensaje("Ingrese la cedula del bibliotecario que desea eliminar: ");
                    String cedulaEliminar = scanner.nextLine();
                    eliminarBibliotecario(cedulaEliminar);
                    break;
                case '4':
                    activo = false;
                    mostrarMensaje("Volviendo al menú principal...");
                    break;
                default:
                    mostrarMensaje("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
    

    public void gestionarEstudiantes(){
        Scanner scanner = new Scanner(System.in);
        boolean activo = true;
    
        while (activo) {
            mostrarMensaje("\n" + "¿Qué desea hacer?");
            mostrarMensaje("1. Crear estudiante");
            mostrarMensaje("2. Buscar estudiante");
            mostrarMensaje("3. Eliminar estudiante");
            mostrarMensaje("4. Volver");
            
            char opcion = scanner.nextLine().charAt(0);
    
            switch (opcion) {
                case '1':
                    crearNuevoEstudiante();
                    break;
                case '2':
                    mostrarMensaje("Ingrese la cedula del estudiante que desea buscar: ");
                    String cedulaBuscar = scanner.nextLine();
                    mostrarDetallesEstudiante(cedulaBuscar);
                    break;
                case '3':
                    mostrarMensaje("Ingrese la cedula del estudiante que desea eliminar: ");
                    String cedulaEliminar = scanner.nextLine();
                    eliminarEstudiante(cedulaEliminar);
                    break;
                case '4':
                    activo = false;
                    mostrarMensaje("Volviendo al menú principal...");
                    break;
                default:
                    mostrarMensaje("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    public void gestionarLibros(){
        Scanner scanner = new Scanner(System.in);
        boolean activo = true;
    
        while (activo) {
            mostrarMensaje("\n" + "¿Qué desea hacer?");
            mostrarMensaje("1. Crear libro");
            mostrarMensaje("2. Buscar libro");
            mostrarMensaje("3. Eliminar libro");
            mostrarMensaje("4. Sobreescribir libro");
            mostrarMensaje("5. Volver");
            
            char opcion = scanner.nextLine().charAt(0);
    
            switch (opcion) {
                case '1':
                    crearNuevoLibro();
                    break;
                case '2':
                    mostrarMensaje("Ingrese el codigo del libro que desea buscar: ");
                    String codigoBuscar = scanner.nextLine();
                    mostrarDetallesLibro(codigoBuscar);
                    break;
                case '3':
                    mostrarMensaje("Ingrese el codigo del libro que desea eliminar: ");
                    String codigoEliminar = scanner.nextLine();
                    eliminarLibro(codigoEliminar);
                    break;
                case '4':
                    mostrarMensaje("Ingrese el código del libro que desea sobreescribir: ");
                    String codigoSobreescribir = scanner.nextLine();
                    eliminarBibliotecario(codigoSobreescribir);
                    break;
                case '5':
                    activo = false;
                    mostrarMensaje("Volviendo al menú principal...");
                default:
                    mostrarMensaje("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    public void gestionarPrestamos(){
        Scanner scanner = new Scanner(System.in);
        boolean activo = true;
    
        while (activo) {
            mostrarMensaje("\n" + "¿Qué desea hacer?");
            mostrarMensaje("1. Crear prestamo");
            mostrarMensaje("2. Buscar prestamo");
            mostrarMensaje("3. Eliminar prestamo");
            mostrarMensaje("4. Entregar prestamo");
            mostrarMensaje("5. Volver");
            
            char opcion = scanner.nextLine().charAt(0);
    
            switch (opcion) {
                case '1':
                    crearNuevoPrestamo();
                    
                    break;
                case '2':
                    mostrarMensaje("Ingrese el codigo del prestamo que desea buscar: ");
                    String codigoBuscar = scanner.nextLine();
                    consultarPrestamo(codigoBuscar);
                    break;
                case '3':
                    mostrarMensaje("Ingrese el codigo del prestamo que desea eliminar: ");
                    String codigoEliminar = scanner.nextLine();
                    eliminarPrestamo(codigoEliminar);
                    break;
                    
                case '4':
                    mostrarMensaje("Ingrese el codigo del prestamo que desea entregar: ");
                    String codigoEntregar = scanner.nextLine();
                    entregarPrestamo(codigoEntregar);
                break;
                    
                case '5':
                    activo = false;
                    mostrarMensaje("Volviendo al menú principal...");
                    break;
                default:
                    mostrarMensaje("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    public void opcionesAdicionales(){
        Scanner scanner = new Scanner(System.in);
        boolean activo = true;
    
        while (activo) {
            mostrarMensaje("\n" + "¿Qué desea hacer?");
            mostrarMensaje("1. Cantidad de prestamos de cada empleado");
            mostrarMensaje("2. Mostrar datos del estudiante con más prestamos");
            mostrarMensaje("3. Mostrar el total de dinero recaudado por la biblioteca");
            mostrarMensaje("4. Calcular el dinero a pagar a los bibliotecarios");
            mostrarMensaje("5. Volver");
            
            char opcion = scanner.nextLine().charAt(0);
    
            switch (opcion) {
                case '1':
                    obtenerCantidadPrestamosBibliotecario();
                    break;
                case '2':
                    obtenerEstudianteConMasPrestamos();
                    break;
                case '3':
                    totalRecaudoBiblioteca();
                    break;
                case '4':
                    totalPagarBibliotecarios();
                    break;
                case '5':
                    activo = false;
                    mostrarMensaje("Volviendo al menú principal...");
                    break;
                default:
                    mostrarMensaje("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    // ------------------------------------------------------------//

    /**
     * Método para imprimir una cadena de texto
     * @param mensaje
     */
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

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