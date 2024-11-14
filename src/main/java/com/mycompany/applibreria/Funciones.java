package com.mycompany.applibreria;

public class Funciones {
    public Funciones() {
    }

    public static String validarRut(String rut) {
        rut = rut.replaceAll("[^0-9kK]", "").toUpperCase();

        if (rut.length() < 8 || rut.length() > 9) {
            return null;
        }

        String cuerpo = rut.substring(0, rut.length() - 1);
        char dv = rut.charAt(rut.length() - 1);

        int suma = 0;
        int multiplicador = 2;

        for (int i = cuerpo.length() - 1; i >= 0; i--) {
            suma += Integer.parseInt(String.valueOf(cuerpo.charAt(i))) * multiplicador;
            multiplicador = (multiplicador == 7) ? 2 : multiplicador + 1;
        }

        int resto = suma % 11;
        char dvCalculado = (resto == 0) ? '0' : (resto == 1) ? 'K' : (char) (11 - resto + '0');

        return rut;
    }

}
