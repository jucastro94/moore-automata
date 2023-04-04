package com.mycompany.carritoautomatamoore;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author JuanMiguelC
 */
public class Estado {

    public String nombre, salida;
    public int usos = 0, recursividad = 0;
    public List<String> est = new ArrayList();
    public Estado(String nombre, List<String> entrada, String salida) {
        this.nombre = nombre;
        this.salida = salida;
        for (String i: entrada) {
            est.add(i);
        }
    }

    public void añadirUso() {
        this.usos++;
    }

    public void añadirRecursividad() {
        this.recursividad++;
    }
}
