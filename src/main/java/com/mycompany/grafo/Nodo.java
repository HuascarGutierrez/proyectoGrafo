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
public class Nodo {
    String dato;
    Nodo siguiente;
    Scanner leer;
    
    int costo;
    boolean flag;
    
    public Nodo()
    {
        this.dato = "";
        this.siguiente = null;
    }
    public Nodo (String x)
    {
        this.dato = x;
        this.siguiente = null;
        
        this.costo = 0;
        this.flag = false;
    }    
    public Nodo (String x,int y)
    {
        this.dato = x;
        this.siguiente = null;
        
        this.costo = y;
        this.flag = false;
    }  
    public void mostrar()
    {
        System.out.println("_______________________________");
        System.out.println("dato: "+this.dato);
        System.out.println("siguiente: "+this.siguiente);
        System.out.println("flag: "+this.flag);
        System.out.println("_______________________________");
    }
        
    public void mostrarConCosto()
    {
        System.out.println("_______________________________");
        System.out.println("anterior: "+this.dato);
        System.out.println("costo: "+this.costo);
        System.out.println("siguiente: "+this.siguiente);
        System.out.println("_______________________________");
    }
}
