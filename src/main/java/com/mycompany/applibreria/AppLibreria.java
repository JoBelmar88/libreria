/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.applibreria;

// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tom
 */
public class AppLibreria {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
    /*
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dtf.format(now)); */

        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            boolean usuarioExistente = false;
            String nombre;
            String rut;
            String genero;
            String carrera;

            System.out.println("------------Menú--------------");
            System.out.println("1.- Ingresar estudiante");
            System.out.println("2.- Ingresar docente");
            System.out.println("3.- Eliminar usuario");

            System.out.println("0.- Salir");
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
                    System.out.println("=====Ingresando datos del docente=====\n");
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

                    Docente docente = new Docente(rut, nombre, genero, carrera);
                    usuarios.add(docente);
                    System.out.println("====== Docente agregado correctamente ======");
                    break;

                case 3:
                    int indice = 0;
                    System.out.println("=====Ingresa rut del usuario a eliminar=====\n");
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
            }

        } while (opcion != 0);

        System.out.println("Ha finalizado el ciclo");
        System.out.println(usuarios);

       /* Docente docente1 = new Docente("4-4");
        Docente docente2 = new Docente("9-9");

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        usuarios.add(docente1);
        usuarios.add(docente2);
        */

        // GENERAMOS DATOS DE USUARIOS BASE
       /* ArrayList<Usuario> usuarios = new ArrayList<Usuario>(
                Arrays.asList(
                        new Docente("1-1", ),
                        new Docente("1-2"),
                        new Docente("1-3"),
                        new Estudiante("2-1"),
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
