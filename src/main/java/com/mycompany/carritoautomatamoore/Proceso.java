/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carritoautomatamoore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanMiguelC
 */
public class Proceso {

    public String[] entrada = {"Stop", "adelante", "atras", "izquierda", "derecha"};
    public String[] nombreSalidas = {"Stop", "adelante", "atras", "izquierda", "derecha", "girando a la derecha", "girando a la izquierda", "retrocediendo a la derecha", "retrocediendo a la izquierda"};
    public ArrayList<Estado> totalEstados = new ArrayList();
    public List<String> estados = new ArrayList();
    public List<String> listaProceso = new ArrayList();
    public List<String> listaSalida = new ArrayList();
    public List<String> cadenaEntrada = new ArrayList();
    public String estadoActual = "";

    public Proceso() {
        listaProceso.add("q0");
        //listaSalida.add("Stop");
        init();
        estadoActual = "q0";
    }

    public void init() {
        List<String> temp = new ArrayList();
        temp.add("q5");
        temp.add("q1");
        temp.add("q2");
        temp.add("q3");
        temp.add("q4");
        totalEstados.add(new Estado("q0", temp, nombreSalidas[0]));
        totalEstados.add(new Estado("q5", temp, nombreSalidas[0]));
        temp.clear();

        temp.add("q5");
        temp.add("q1");
        temp.add("q2");
        temp.add("q7");
        temp.add("q6");
        totalEstados.add(new Estado("q1", temp, nombreSalidas[1]));
        temp.clear();

        temp.add("q5");
        temp.add("q1");
        temp.add("q2");
        temp.add("q8");
        temp.add("q9");
        totalEstados.add(new Estado("q2", temp, nombreSalidas[2]));
        temp.clear();

        temp.add("q5");
        temp.add("q7");
        temp.add("q8");
        temp.add("q3");
        temp.add("q4");
        totalEstados.add(new Estado("q3", temp, nombreSalidas[3]));
        temp.clear();

        temp.add("q5");
        temp.add("q6");
        temp.add("q9");
        temp.add("q3");
        temp.add("q4");
        totalEstados.add(new Estado("q4", temp, nombreSalidas[4]));
        temp.clear();

        temp.add("q5");
        temp.add("q1");
        temp.add("q2");
        temp.add("q7");
        temp.add("q6");
        totalEstados.add(new Estado("q6", temp, nombreSalidas[5]));
        totalEstados.add(new Estado("q7", temp, nombreSalidas[6]));
        temp.clear();

        temp.add("q5");
        temp.add("q1");
        temp.add("q2");
        temp.add("q8");
        temp.add("q9");
        totalEstados.add(new Estado("q8", temp, nombreSalidas[8]));
        totalEstados.add(new Estado("q9", temp, nombreSalidas[7]));
        temp.clear();
    }

    public String nuevaEntrada(int into) {
        cadenaEntrada.add(entrada[into]);

        identificarEstadoActual(into);
        String salida = salida();
        return salida;
    }

    public int buscarIndice(String nombreEst) {
        int index;
        //boolean found = false;
        for (int i = 0; i < totalEstados.size(); i++) {
            if (totalEstados.get(i).nombre.equals(nombreEst)) {

                return i;
            }
        }
        return -1;
    }

    public String salida() {
        int indice = buscarIndice(estadoActual);
        String est = totalEstados.get(indice).nombre;
        String salida = "";
        switch (est) {
            case "q0":
                listaSalida.add("Stop");
                salida = "sleeping.png";
                break;
            case "q1":
                listaSalida.add("adelante");
                salida = "delante.png";
                break;
            case "q2":
                listaSalida.add("atras");
                salida = "abajo.png";
                break;
            case "q3":
                listaSalida.add("izquierda");
                salida = "left.png";
                break;
            case "q4":
                listaSalida.add("derecha");
                salida = "derecha.png";
                break;
            case "q5":
                listaSalida.add("Stop");
                salida = "sleeping.png";
                break;
            case "q6":
            listaSalida.add("girando a la derecha");
                salida = "girando_a_la_derecha.jpg";
                break;
            case "q7":
            listaSalida.add("girando a la izquierda");
                salida = "girando_a_la_izq.jpg";
                break;
            case "q8":
            listaSalida.add("retrocediendo a la izquierda");
                salida = "atras_izq.png";
                break;
            case "q9":
            listaSalida.add("retrocediendo a la derecha");
                salida = "atras_a_la_derecha.jpg";
                break;
        }
        return salida;
    }

    public void identificarEstadoActual(int into) {
        int estado = buscarIndice(estadoActual);
        estadoActual = totalEstados.get(estado).est.get(into);
        
        listaProceso.add(estadoActual);
        totalEstados.get(estado).añadirUso();
        recursividad(estadoActual);
    }

    public void recursividad(String nuevoEstado) {
        //System.out.println(listaProceso.get(listaProceso.size() - 1) +" ---------"+nuevoEstado);
        if(nuevoEstado.equals(listaProceso.get(listaProceso.size() - 2))){
        //if (listaProceso.get(listaProceso.size() - 1).equals(nuevoEstado)) {
            int estado = buscarIndice(nuevoEstado);
            System.out.println("entraaaaa " +totalEstados.get(estado).nombre);
            
            totalEstados.get(estado).añadirRecursividad();
            System.out.println("entraaaaa " +totalEstados.get(estado).recursividad);
        }
    }

}
