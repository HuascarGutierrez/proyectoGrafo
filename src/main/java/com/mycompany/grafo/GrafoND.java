/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafo;
import java.sql.SQLOutput;
import java.util.Scanner;
/**
 *
 * @author huasc
 */
public class GrafoND 
{
    NodoG g;
    ColaG NG;
    Cola vertice;
    int cantidad;
    int grado;
    Scanner leer = new Scanner(System.in);
    public GrafoND()
    {
        g = null;
        NG = new ColaG();
        vertice = new Cola();
        cantidad = 0;
        System.out.println("Ingrese el grado del grafo");
        grado = leer.nextInt();
    }
    public void agregar()
    {
        String resp,dato;
        int j,k,costo;
        boolean flag;
        NodoColaG actual = NG.salida;
        System.out.print("Ingrese un nombre para el nodo: ");
        dato = leer.next();
        vertice.poner(dato);
        NodoColaG nuevo = new NodoColaG(dato,grado);
        //NG[cantidad] = nuevo;
        NG.poner(nuevo);
        if (g == null)
        {
            g = nuevo.datoG;
        }
        else 
        {
            
            while  (actual.siguiente !=null)
            {
                System.out.println("El nodo "+nuevo.datoG.dato
                +" tiene conexion con el nodo "+actual.datoG.dato+"?   S/N: ");
                resp = leer.next();
                if (resp.equals("S"))
                {
                    System.out.println("Ingrese el costo: ");
                    costo = leer.nextInt();
                    j=0;
                    flag = false;
                    while (!flag)
                    {
                        if(actual.datoG.p[j] == null)
                                    {
                                        actual.datoG.p[j] = nuevo.datoG;
                                        actual.datoG.c[j] = costo;
                                        flag = true;
                                    }
                        j++;
                    }
                    
                    k=0;
                    flag = false;
                    while(!flag)
                    {
                        if(nuevo.datoG.p[k] == null)
                        {
                                        nuevo.datoG.p[k] = actual.datoG;
                                        nuevo.datoG.c[k] = costo;
                                        flag = true;
                        }
                        k++;
                    }
                }
                actual = actual.siguiente;
            }
        }
        cantidad++;
    }
    public void mostrar()
    {
        NodoColaG actual = NG.salida;
        while(actual !=null)
        {
            actual.datoG.mostrar();
            actual = actual.siguiente;
        }
    }
    
    public void caminoCorto()
    {
        //cambia todos los flag de los nodos a false 
        NodoColaG act = NG.salida;
        while(act!=null)
        {
            act.datoG.flag = false;
            act = act.siguiente;
        }
        
        //se crea lo inicial
        String verticeAct;
        //datos de la clase
        Cola cola,visitados,etiquetas;
        cola = new Cola();
        visitados = new Cola();
        etiquetas = new Cola();
        //variables de apoyo
        int i;
        Nodo actual,et,paso,actu;
        NodoColaG busqueda;
        Cola costos = new Cola();
        //entrada del nodo de inicio
        System.out.print("Ingrese el nodo de inicio: ");
        verticeAct = leer.next();
        System.out.println("");
        //crea la cola visitados y etiquetas
        actual = vertice.salida;
        while(actual!=null)
        {
            visitados.poner(actual.dato);
            etiquetas.poner(actual.dato);
            actual = actual.siguiente;
        }       
        
        busqueda = NG.salida;        
        while(!busqueda.datoG.dato.equals(verticeAct))
        {
            busqueda = busqueda.siguiente;
        }             
        cola.poner(visitados.sacarEsp(verticeAct)); //toma ya 
        actu = cola.salida;
        System.out.println("\t\tPRIMER COLA");
        cola.mostrar();
        System.out.println("");
      
        while (actu!=null)
        {              
            for (i=0;i<grado;i++)
            {
                if(busqueda.datoG.p[i]!=null && !busqueda.datoG.p[i].flag)
                {
                    actual = vertice.salida;
                    paso = etiquetas.salida;
                    while(!actual.dato.equals(busqueda.datoG.dato))
                    {
                        paso = paso.siguiente;
                        actual = actual.siguiente;
                    }                       
                    actual=vertice.salida;
                    et = etiquetas.salida;
                    while(!actual.dato.equals(busqueda.datoG.p[i].dato))
                    {
                        actual=actual.siguiente;
                        et = et.siguiente;
                    } 
                    if (et.costo==0)
                    {
                        et.dato = verticeAct;
                        et.costo = busqueda.datoG.c[i]+paso.costo;

                        costos.ponerConCosto(actual.dato,et.costo);
                        //ITERACIONES
                        System.out.println("\t\tETIQUETAS DE PROCEDIMIENTO");
                        Nodo actual2 = vertice.salida;
                        Nodo et2 = etiquetas.salida;
                        while(actual2!=null)
                        {
                            System.out.println("Para "+actual2.dato+": "+et2.dato+" | "+et2.costo);
                            actual2 = actual2.siguiente;
                            et2 = et2.siguiente;
                        }
                        System.out.println("");
                    }
                    else 
                    {                        
                        if(et.costo>(paso.costo+busqueda.datoG.c[i]))
                        {
                            et.dato = verticeAct;
                            et.costo =paso.costo+busqueda.datoG.c[i];
                            //ITERACIONES
                            System.out.println("\t\tETIQUETAS DE PROCEDIMIENTO");
                            Nodo actual2 = vertice.salida;
                            Nodo et2 = etiquetas.salida;
                            while(actual2!=null)
                            {
                                System.out.println("Para "+actual2.dato+": "+et2.dato+" | "+et2.costo);
                                actual2 = actual2.siguiente;
                                et2 = et2.siguiente;
                            }
                            System.out.println("");
                        }       // toma ya 
                        else
                        {
                            System.out.println("\t\tETIQUETAS DE PROCEDIMIENTO");
                            System.out.println("ETIQUETA MUERTA");
                            System.out.println("");
                        }
                    }                    
                }
                else if(busqueda.datoG.p[i]!=null && busqueda.datoG.p[i].flag)
                {
                    System.out.println("\t\tETIQUETAS DE PROCEDIMIENTO");
                    System.out.println("NODO CON BANDERA");
                    System.out.println("");
                }
            }   
                           
            
            busqueda.datoG.flag = true; //aqui ya le ponemos check al nodo del grafo
            
            actual = cola.salida; 

            while(!actual.dato.equals(busqueda.datoG.dato))
            {
                actual = actual.siguiente;
            }
            actual.flag = true;             
            
            System.out.println("\t\tCOSTOS");
            costos.mostrarConCosto();
            System.out.println("");
            while(costos.salida!=null)
            {
                et =costos.salida;                
                actual = costos.salida;
                while(actual!=null)
                {
                    if(et.costo>actual.costo)
                    {
                        et = actual;
                    }
                    actual = actual.siguiente;
                }                
                cola.poner(costos.sacarEsp(et.dato)); //puede que este sea el problema
            }
            
            System.out.println("\t\tCOLA PROCESO");
            cola.mostrar();
            System.out.println("");
            actu = actu.siguiente;
            if(actu!=null)
            {
                verticeAct = actu.dato;
                    busqueda = NG.salida;        
                    while(!busqueda.datoG.dato.equals(verticeAct))
                    {
                        busqueda = busqueda.siguiente;
                    }       
            } 
            
        }
        
        System.out.println("\t\tETIQUETAS");
        actual = vertice.salida;
        et = etiquetas.salida;
        while(actual!=null)
        {
            System.out.println("Para "+actual.dato+": "+et.dato+" | "+et.costo);
            actual = actual.siguiente;
            et = et.siguiente;
        }
        System.out.println("");
        System.out.println("\t\tCOLA FINAL");
        cola.mostrar();
        System.out.println("");
        
    }
    
    public void matriz()
    {
        String sal;
        Nodo actual = vertice.salida;
        NodoColaG act = NG.salida;
        sal = "   ";
        Integer cambio;
        int k;
        while(actual!=null)
        {
            sal = sal + String.format("%3s",actual.dato);
            actual = actual.siguiente;
        }
        System.out.println(sal);
        for(int i=0;i<vertice.cantidad;i++)
        {
            k=0;
            sal = String.format("%3s",act.datoG.dato);
            actual = vertice.salida;
            for(int j=0;j<vertice.cantidad;j++)
            {
                if(i==j)
                {
                    sal = sal + "  0";
                }
                else
                {
                    if(k<grado)
                    {
                        if(act.datoG.p[k]!=null && act.datoG.p[k].dato.equals(actual.dato))
                        {
                            cambio = act.datoG.c[k];
                            sal = sal + String.format("%3s",cambio.toString());
                            k++;
                        }
                        else
                        {
                            sal = sal + "  0";
                        }
                    }
                    else
                    {
                        sal = sal + "  0";
                    }
                }
                actual = actual.siguiente;
            }
            act = act.siguiente;
            System.out.println(sal);
        }
    }
}
