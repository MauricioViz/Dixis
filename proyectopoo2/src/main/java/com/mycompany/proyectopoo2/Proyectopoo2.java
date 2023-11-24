/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectopoo2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author CHRISTOPHER
 */
public class Proyectopoo2 {

    public static void main(String[] args) {
        String dato = "FACT-000001";
        String num = dato.substring(5);
        String letra = dato.substring(0,5);
        int numero = Integer.parseInt(num);
        numero++;
        String correlativo = letra + String.format("%06d", numero);
        Date fecha = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        
        System.out.println(formateador.format(fecha));
        System.out.println(num);
        System.out.println(letra);
        System.out.println(dato);
        System.out.println(correlativo);
    }
}
