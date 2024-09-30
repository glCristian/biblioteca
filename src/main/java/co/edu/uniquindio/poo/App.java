package co.edu.uniquindio.poo;
import java.time.LocalDate;
import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        boolean activo = true;
        while (activo){
            Scanner scanner = new Scanner(System.in);
            mostrarMensaje("Bienvenido a la biblioteca" +  "\n" + "Ingrese el número de la acción que desea realizar:");
            mostrarMensaje("1. Gestionar Bibliotecarios");
            mostrarMensaje("2. Gestionar Estudiantes");
            mostrarMensaje("3. Gestionar Libros");
            mostrarMensaje("4. Gestionar Prestamos");
            mostrarMensaje("5. Salir");
            char opcion = scanner.nextLine().charAt(0);

            if(opcion == '1' || opcion == '2' || opcion == '3' || opcion == '4' || opcion == '5'){
                //manejarSeleccion(opcion);
            }

            else if(opcion == '5'){
                mostrarMensaje("Saliendo..."+ "\n" + "------------------------------------------------------------------------------------");
            }
        }
    }

    public void manejarSeleccion(char opcion){
        switch(opcion){
            case '1':
            
            case '2':

            case '3':

        }

    }


    public static String ingresarTexto(String mensaje){
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();
        return texto;
    }

    
    public static int ingresarEntero(String mensaje){
        Scanner scanner = new Scanner(System.in);
        int entero = scanner.nextInt();
        return entero;
    }

    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }


//--------------------------Banco de datos de prueba genéricos----------------------//

    Libro libro1 = new Libro("Cien años de soledad", "2828", "CX32", 15, "Gabriel Garcia Marquez ",
     "Norma", LocalDate.of(1967, 05, 4) , 1500);

    Libro libro2 = new Libro("Maria", "398", "JI23", 11, "Jorge Isaacs ",
     "Norma", LocalDate.of(1867, 05, 9) , 1300);

    Libro libro3 = new Libro("El amor en los tiempos del colera", "6777", "GG13", 16, "Gabriel Garcia Marquez  ",
     "Norma", LocalDate.of(1867, 1, 1) , 1100);

    Bibliotecario bibliotecario1 = new Bibliotecario("Julian Alvarez", "1115167", "3217896556",
     "juliAlva@gmail.com", 23);

    Estudiante estudiante1 = new Estudiante("Cristian Camilo Bonilla", 
     "1115192851", "31882161658" , "cristianc@gmail.com", 18);
     
//----------------------------------------------------------------------------------//






}





