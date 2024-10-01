package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca("biblioteca CRAI", 0, 0);

        // --------------------------Banco de datos de prueba genéricos----------------------//

        Libro libro1 = new Libro("Cien años de soledad", "282", "GG32", 15, "Gabriel Garcia Marquez ",
                "Norma", LocalDate.of(1967, 05, 4), 1500);
        biblioteca.agregarLibro(libro1);

        Libro libro2 = new Libro("Maria", "398", "JI23", 11, "Jorge Isaacs ",
                "Norma", LocalDate.of(1867, 05, 9), 1300);
        biblioteca.agregarLibro(libro2);

        Libro libro3 = new Libro("El amor en los tiempos del cólera", "677", "GG13", 16, "Gabriel Garcia Marquez  ",
                "Norma", LocalDate.of(1867, 1, 1), 1100);
        biblioteca.agregarLibro(libro3);

        Libro libro4 = new Libro("El hombre en busca de sentido", "785", "VF17", 9, "Viktor frankl  ",
                "Herder", LocalDate.of(1946, 1, 1), 1000);
        biblioteca.agregarLibro(libro4);

        Libro libro5 = new Libro("El arte de la guerra", "993", "SZ89", 17, "Sun Tzu",
                "Unknown", LocalDate.of(1, 1, 1), 1600);
        biblioteca.agregarLibro(libro5);

        Bibliotecario bibliotecario1 = new Bibliotecario("Julian Alvarez", "1115167", "3217896556",
                "juliAlva@gmail.com", 11);
        biblioteca.agregarBibliotecario(bibliotecario1);

        Bibliotecario bibliotecario2 = new Bibliotecario("Andres Parra", "12345678", "3123456556",
                "Andypaa@gmail.com", 10);
        biblioteca.agregarBibliotecario(bibliotecario2);

        Estudiante estudiante1 = new Estudiante("Cristian Camilo Bonilla",
                "1115192851", "31882161658", "cristianc@gmail.com", 18);
        biblioteca.agregarEstudiante(estudiante1);

        Estudiante estudiante2 = new Estudiante("Nicolas Orozco Osorio",
                "1092852380", "3146138755", "nicooo@gmail.com", 33);
        biblioteca.agregarEstudiante(estudiante2);

        Estudiante estudiante3 = new Estudiante("Camila Alzate",
                "11156", "3145678990", "camilaxdr@gyahoo.com", 19);
        biblioteca.agregarEstudiante(estudiante3);

        // ----------------------------------------------------------------------------------//

        boolean activo = true;
        while (activo) {
            Scanner scanner = new Scanner(System.in);
            mostrarMensaje("Bienvenido a la biblioteca" + "\n" + "Ingrese el número de la acción que desea realizar:");
            mostrarMensaje("1. Gestionar Bibliotecarios");
            mostrarMensaje("2. Gestionar Estudiantes");
            mostrarMensaje("3. Gestionar Libros");
            mostrarMensaje("4. Gestionar Prestamos");
            mostrarMensaje("5. Opciones adicionales");
            mostrarMensaje("6. Salir");
            char opcion = scanner.nextLine().charAt(0);

            if (opcion == '1' || opcion == '2' || opcion == '3' || opcion == '4' || opcion == '5') {
                switch (opcion) { 
                    case '1':
                        biblioteca.gestionarBibliotecarios();
                        break;

                    case '2':
                        biblioteca.gestionarEstudiantes();
                        break;
                
                    case '3':
                        biblioteca.gestionarLibros();
                        break;

                    case '4':
                        biblioteca.gestionarPrestamos();
                        break;

                    case '5':
                        biblioteca.opcionesAdicionales();
                        break;
                }

            }

            else if (opcion == '6') {
                mostrarMensaje("Saliendo..." + "\n"
                        + "------------------------------------------------------------------------------------");
            }

            else {
                mostrarMensaje("Ingrese una opción valida.");
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
