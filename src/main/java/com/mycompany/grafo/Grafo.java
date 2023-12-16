/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grafo;
import java.util.Scanner;
/**
 *
 * @author huasc
 */
public class Grafo {

    public static void main(String[] args) {
        int op;
        Scanner leer = new Scanner(System.in);
        GrafoND nuevo = new GrafoND();
        /*nuevo.agregar();
        nuevo.agregar();
        nuevo.agregar();
        nuevo.agregar();
        nuevo.mostrar();*/
        while (true)
        {
            System.out.println("_______________");
            System.out.println("\tOPCIONES");
            System.out.println("1. Agregar nodo");
            System.out.println("2. Mostrar");
            System.out.println("3. Camino corto");
            System.out.println("4. Mostrar matriz");
            System.out.println("5. Salir");
            System.out.println("_______________");
            op = leer.nextInt();
            switch(op)
            {
                case 1: nuevo.agregar();
                break;
                case 2: nuevo.mostrar();
                break;
                case 3: nuevo.caminoCorto();
                break;
                case 4: nuevo.matriz();
                break;
                default: return;
            }
        }
    }
}
