/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafo;
import java.util.Scanner;
/**
 *
 * @author huasc
 */
public class NodoColaG {
    NodoG datoG;
    NodoColaG siguiente;
    Scanner leer;

    public NodoColaG (String x,int g)
    {
        datoG = new NodoG(x,g);
        this.siguiente = null;
    }    
    public void mostrar()
    {
        datoG.mostrar();
    }
}
