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
public class NodoG {
    String dato;
    NodoG[] p;
    int grado;
    int[] c;
    
    boolean flag;
    
    Scanner leer = new Scanner(System.in);
    public NodoG (String d, int g)
    {
        dato = d;
        p = new NodoG[g];
        for (int i=0;i<g;i++)
        {
            p[i]=null;
        }
        grado = g;
        c = new int[g];
        
        flag = false;
    }
    public void mostrar()
    {
        System.out.println("______________________________________________________________");
        System.out.println("dato del nodo: "+dato);
        System.out.println("______________________________________________________________");     
        for (int i=0;i<grado;i++)
        {
            if(p[i]!=null)
            {
                System.out.println("puntero Nro1: "+p[i].dato);
                System.out.println("con dirrecion "+p[i]);
            }
            else
            {
                System.out.println("puntero Nro1: Sin dato");
                System.out.println("dirrecion "+p[i]);
            }
            System.out.println("costo Nro1: "+c[i]);
        }
    }
}
