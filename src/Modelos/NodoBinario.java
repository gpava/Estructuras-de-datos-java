/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Gustavo
 */
public class NodoBinario
{

    /**
     * Dato a almacenar en el Nodo
     */
    int dato;
    /**
     * Nombre del nodo(Opcional)
     */
    String nombre;
    /**
     * Enlaces del nodo a sus respectivos hijos
     */
    NodoBinario hijoIzquierdo;
    NodoBinario hijoDerecho;

    /**
     * Constructor Principal
     *
     * @param d Dato a almacenar en el nodo
     *
     */
    public NodoBinario(int d)
    {
        this.dato = d;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public NodoBinario(int i, NodoBinario izq, NodoBinario der) {
        this.dato = i;
        this.hijoIzquierdo= izq;
        this.hijoDerecho = der;
    }

    public int getDato() {
        return dato;
    }

    public void setHijoDerecho(NodoBinario hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setHijoIzquierdo(NodoBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoBinario getHijoDerecho() {
        return hijoDerecho;
    }

    public NodoBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }
}
