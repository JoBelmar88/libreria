/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;

/**
 *
 * @author Tom
 */
public class Docente extends Usuario {
    private boolean doctorado;
    private boolean magister;

    public boolean isDoctorado() {
        return doctorado;
    }

    public void setDoctorado(boolean doctorado) {
        this.doctorado = doctorado;
    }

    public boolean isMagister() {
        return magister;
    }

    public void setMagister(boolean magister) {
        this.magister = magister;
    }

    public Docente(String RUN, String nombre, String genero, String carrera, boolean doctorado, boolean magister) {
        super(RUN, nombre, genero, carrera);
        this.doctorado = doctorado;
        this.magister = magister;
    }

    @Override
    public String toString() {
        return "Docente{" + super.toString() + ", doctorado=" + doctorado + ", magister=" + magister + '}';
    }
}

