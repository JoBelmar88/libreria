/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.applibreria;

// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Tom
 */
public class AppLibreria {
    public static void main(String[] args) {

        // Carga automática
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>(
                Arrays.asList(
                        new Docente("184180626", "Osvaldo caceres", "M", "Profesor",  true, false),
                        new Docente("170447050", "José Belmar", "M", "Profesor", true, false),
                        new Estudiante("123456785", "Macarena Leiva", "F", "Enfermeria"),
                        new Estudiante("876543212", "Carolina Lagos", "F", "Ingeniera Comercial")
                )
        );
        // GENERAMOS DATOS DE LIBROS BASE
        ArrayList<Libro> libros = new ArrayList<Libro>(
                Arrays.asList(
                        new Libro(9990, "Cien años de soledad", "Gabriel García Márquez", 3,3, "https://static.wikia.nocookie.net/muyinteresante/images/3/38/9788497592208.jpg/revision/latest?cb=20170908093803&path-prefix=es" ),
                        new Libro(9991, "Cien años de soledad 2", "Gabriel García Márquez", 5,5, "https://static.wikia.nocookie.net/muyinteresante/images/3/38/9788497592208.jpg/revision/latest?cb=20170908093803&path-prefix=es"),
                        new Libro(9992, "Cien años de soledad 3", "Gabriel García Márquez", 7,7, "https://static.wikia.nocookie.net/muyinteresante/images/3/38/9788497592208.jpg/revision/latest?cb=20170908093803&path-prefix=es"),
                        new Libro(9993, "Cien años de soledad 4", "Gabriel García Márquez", 5,5, "https://static.wikia.nocookie.net/muyinteresante/images/3/38/9788497592208.jpg/revision/latest?cb=20170908093803&path-prefix=es"),
                        new Libro(9994, "Cien años de soledad 5", "Gabriel García Márquez", 10,10, "https://static.wikia.nocookie.net/muyinteresante/images/3/38/9788497592208.jpg/revision/latest?cb=20170908093803&path-prefix=es")
                )
        );

        ArrayList<Prestamo> prestamos = new ArrayList<>();

    /*
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dtf.format(now)); */

        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            // Variables para libros
            int ISBN;
            String titulo;
            String autor;
            int cantidad;
            int disponible;
            String imagen;
            boolean libroExistente = false;
            Libro libro;

            // Variables para usuarios
            Usuario usuario;
            boolean usuarioExistente = false;
            String nombre;
            String rut;
            String genero;

            // Variables para estudiantes
            String carrera;

            // Variables para docentes
            String posgrado;
            boolean doctorado = false;
            boolean magister = false;

            // Arreglos
            int indice = 0;

            System.out.println("------------Menú--------------");
            System.out.println("1.- Ingresar estudiante");
            System.out.println("2.- Ingresar docente");
            System.out.println("3.- Eliminar usuario");
            System.out.println("4.- Crear libro");
            System.out.println("5.- Eliminar libro");
            System.out.println("6.- Generar prestamo");

            System.out.println("0.- Salir\n");
            System.out.println("Ingrese una opción:");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("=====Ingresando datos del estudiante=====\n");
                    System.out.println("Ingrese nombre:");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese rut:");
                    rut = sc.nextLine();

                    if(Funciones.validarRut(rut) == null) {
                        System.out.println("Rut inválido");
                        break;
                    };

                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getRUN().equals(rut)) {
                            usuarioExistente = true;
                        };
                    }

                    if (usuarioExistente) {
                        System.out.println("El estudiante ya existe");
                        break;
                    } else {
                        rut = Funciones.validarRut(rut);
                    };

                    System.out.println("Ingrese genero:");
                    genero = sc.nextLine();

                    if (!genero.equals("M") && !genero.equals("F")) {
                        System.out.println("El genero debe ser M o F");
                        break;
                    }

                    System.out.println("Ingrese carrera:");
                    carrera = sc.nextLine();

                    Estudiante estudiante = new Estudiante(rut, nombre, genero, carrera);
                    usuarios.add(estudiante);
                    System.out.println("====== Estudiante agregado correctamente ======");
                    break;
                case 2:
                    System.out.println("===== Ingresando datos del docente =====\n");
                    System.out.println("Ingrese nombre:");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese rut:");
                    rut = sc.nextLine();

                    if(Funciones.validarRut(rut) == null) {
                        System.out.println("Rut inválido");
                        break;
                    } else {
                        rut = Funciones.validarRut(rut);
                    };

                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getRUN().equals(rut)) {
                            usuarioExistente = true;
                        };
                    }

                    if (usuarioExistente) {
                        System.out.println("El docente ya existe");
                        break;
                    }

                    System.out.println("Ingrese genero:");
                    genero = sc.nextLine();

                    if (!genero.equals("M") && !genero.equals("F")) {
                        System.out.println("El genero debe ser M o F");
                        break;
                    }

                    System.out.println("Ingrese carrera:");
                    carrera = sc.nextLine();

                    System.out.println("Ingrese opción de posgrado: \n");
                    System.out.println("a.- Magister:");
                    System.out.println("b.- Doctorado:");
                    posgrado = sc.nextLine();

                    if (posgrado.equals("a")) {
                        magister = true;
                    } else if (posgrado.equals("b")) {
                        doctorado = true;
                    }

                    Docente docente = new Docente(rut, nombre, genero, carrera, doctorado, magister);
                    usuarios.add(docente);
                    System.out.println("====== Docente agregado correctamente ======");
                    break;

                case 3:
                    System.out.println("===== Ingresa rut del usuario a eliminar =====\n");
                    rut = sc.nextLine();

                    if(Funciones.validarRut(rut) == null) {
                        System.out.println("Rut inválido");
                        break;
                    } else {
                        rut = Funciones.validarRut(rut);
                    };

                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getRUN().equals(rut)) {
                            indice = i;
                            usuarioExistente = true;
                        };
                    }

                    if (usuarioExistente) {
                        usuarios.remove(indice);
                        System.out.println("====== Usuario eliminado correctamente ======");
                    } else {
                        System.out.println("El usuario no existe");
                    }

                    break;
                case 4:
                    System.out.println("===== Ingresa datos del libro =====\n");
                    System.out.println("Ingrese ISBN:");
                    ISBN = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < libros.size(); i++) {
                        if (libros.get(i).getISBN() == ISBN) {
                            libroExistente = true;
                        };
                    }

                    if (libroExistente) {
                        System.out.println("El libro ya existe");
                        break;
                    }

                    System.out.println("Ingrese titulo:");
                    titulo = sc.nextLine();
                    System.out.println("Ingrese autor:");
                    autor = sc.nextLine();
                    System.out.println("Ingrese cantidad en biblioteca:");
                    cantidad = sc.nextInt();

                    if (cantidad <= 0) {
                        System.out.println("La cantidad en biblioteca debe ser mayor que 0");
                        break;
                    }

                    System.out.println("Ingrese disponible:");
                    disponible = sc.nextInt();

                    if (disponible <= 0 || disponible > cantidad) {
                        System.out.println("La cantidad disponible debe ser mayor a 0 o menor o igual a la cantidad en biblioteca");
                        break;
                    }

                    System.out.println("Ingrese URL de la imagen:");
                    imagen = sc.nextLine();

                    libro = new Libro(ISBN, titulo, autor, cantidad, disponible, imagen);
                    libros.add(libro);
                    System.out.println("====== Libro agregado correctamente ======");
                    break;

                case 5:
                    System.out.println("===== Ingresa ISBN del libro a eliminar =====\n");
                    ISBN = sc.nextInt();

                    for (int i = 0; i < libros.size(); i++) {
                        if (libros.get(i).getISBN() == ISBN) {
                            indice = i;
                            libroExistente = true;
                        };
                    }

                    if (libroExistente) {
                        libros.remove(indice);
                        System.out.println("====== Libro eliminado correctamente ======");
                    } else {
                        System.out.println("El libro no existe");
                    }

                    break;
                case 6:
                    System.out.println("===== Generando prestamo =====");

                    System.out.println("Ingrese ISBN del libro:");
                    ISBN = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < libros.size(); i++) {
                        if (libros.get(i).getISBN() == ISBN) {
                            libro = libros.get(i);
                            libroExistente = true;
                        };
                    }

                    if (!libroExistente) {
                        System.out.println("El libro no existe");
                        break;
                    }

                    System.out.println("Ingrese rut del usuario:");
                    rut = sc.nextLine();

                    Prestamo prestamo = Prestamo.ingresarPrestamo(ISBN, rut, libros, usuarios);

                    System.out.println(prestamo);

                    prestamos.add(prestamo);

                    System.out.println("===== Prestamo generado correctamente =====");

            }

        } while (opcion != 0);

        System.out.println("Ha finalizado el ciclo");
        System.out.println(libros);
        System.out.println(prestamos);

       /* Docente docente1 = new Docente("4-4");
        Docente docente2 = new Docente("9-9");

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        usuarios.add(docente1);
        usuarios.add(docente2);
        */

        // GENERAMOS DATOS DE USUARIOS BASE
       /* ArrayList<Usuario> usuarios = new ArrayList<Usuario>(
                Arrays.asList(
                        new Docente("184180626", ),
                        new Docente("1-2"),
                        new Docente("1-3"),
                        new Estudiante("170447050"),
                        new Estudiante("2-2"),
                        new Estudiante("2-3")
                )
        );
        // GENERAMOS DATOS DE LIBROS BASE
        ArrayList<Libro> libros = new ArrayList<Libro>(
                Arrays.asList(
                        new Libro(1),
                        new Libro(2),
                        new Libro(3),
                        new Libro(4),
                        new Libro(5)
                )
        );
        // UN LISTA DE DEVOLUCIONES
        ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
        // GENERAMOS UN PRÉSTAMO
        Prestamo prestamo = Prestamo.ingresarPrestamo(1, "1-2", libros, usuarios);
        // AGREGAMOS EL PRÉTAMO AL ARREGLO DE PRÉSTAMOS
        prestamos.add(prestamo);
        // IMPRIMIMOS EL ESTADO ACTUAL DEL PRÉSTAMO
        System.out.println(prestamo.toString());
        // GENERAMOS UNA DEVOLUCION
        Prestamo.ingresarDevolucion(1, "1-2", prestamos);
        System.out.println("-----------------------------------------------------------");
        // IMPRIMIMOS EL ESTADO ACTUAL DEL PRÉSTAMO
        System.out.println(prestamo.toString());
    */
    }
}
