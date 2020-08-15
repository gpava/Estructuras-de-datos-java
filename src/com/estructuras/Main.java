package com.estructuras;

import Modelos.recursion;
import Modelos.Back;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        recursion m = new recursion();
        ArrayList<String> datos1 = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();
        LinkedList<Integer> lista1 = new LinkedList<>();
        int[] array = {11, 2, 31, 1, 53};
        p.add(1);
        p.add(23);
        p.add(34);
        p.add(5);
        Back b  = new Back();
        lista1.add(3);
        lista1.add(3);
        lista1.add(10);
        lista1.add(13);
        lista1.add(10);
        //m.sumaN(100,0);
        //m.sumaN2(100,0);
        //m.sumarA(numeros,0,0);
        //m.saludarR("Gustavo", 0);
        //System.out.println(m.invertir(lista1,0));
        //System.out.println(m.BuscarL(lista1,0,11));
        //System.out.println(m.menorarray(array,0));
        //System.out.println(m.sumarback(100));
        //System.out.println(m.invertirNumero(182));
        //m.imprimirvector(array,0);
        //m.imprimirArraylist(datos1,0);
        //m.imprimirLinkedlist(lista1,0);
        //System.out.println(m.factCola(5,1));
        //System.out.println(m.cuadrado(-5));
        //m.tablamultiplicar(4,20);
        //m.quicksort(array,0,array.length-1);
        //m.imprimirvector(array,0);
        //System.out.println(m.binario(2));
        //m.mensaje(0);
        //m.alfabetoA('Z');
        //System.out.println(m.potencia(3,-3));
        //System.out.println(m.sumaPares(28,datos1));
        //double[] arr = {9, 1, 3, 5, 10, 4, 6};
        //m.mergesort(arr, 0, arr.length - 1);
        //m.imprimirvector(arr, 0);
        b.inicializarLaberinto();


    }
}
