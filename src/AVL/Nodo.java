package AVL;

/**
 * Creado por @author: GustavoP
 * el 7/07/20
 **/
public class Nodo {

    int dato;
    int fe=0;
    /**
     * Enlaces del nodo a sus respectivos hijos
     */
    Nodo hijoIzquierdo;
    Nodo hijoDerecho;

    public Nodo(int d)
    {
        this.dato = d;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public Nodo(int i, Nodo izq, Nodo der) {
        this.dato = i;
        this.hijoIzquierdo= izq;
        this.hijoDerecho = der;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
}
