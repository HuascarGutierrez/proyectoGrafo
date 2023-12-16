/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafo;

/**
 *
 * @author huasc
 */
public final class ColaG {
    NodoColaG entrada;
    NodoColaG salida;
    int cantidad;
    public ColaG()
    {
        this.entrada = null;
        this.salida = null;
        this.cantidad = 0;
    }

     public void poner(NodoColaG n)
    {
        NodoColaG nuevo = n;
        if(salida == null)
        {
            entrada = nuevo;
            salida = nuevo;
        }
        else
        {
            entrada.siguiente = nuevo;
            entrada = entrada.siguiente;
        }
        cantidad++;
    }
     
    public void sacar()
    {
        if (salida !=null)
        {
            salida = salida.siguiente;
            cantidad--;
        }
        else
        {
            System.out.println("No hay datos en la cola");
        }
    }
    public void mostrar()
    {
        NodoColaG actual = salida;
        if(salida != null)
        {
            while(actual !=null)
            {
                actual.mostrar();
                actual=actual.siguiente;
            }
        }
        else
        {
            System.out.println("No hay datos en el grafo");
        }
    }
}
