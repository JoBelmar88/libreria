/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;

/**
 *
 * @author Tom
 */
public class Estudiante extends Usuario {

    public Estudiante(String RUN, String nombre, String genero, String carrera) {
        super(RUN, nombre, genero, carrera);
    }

    @Override
    public String toString() {
        return "Estudiante{" + super.toString() + '}';
    }


}
