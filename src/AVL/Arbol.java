package AVL;

/**
 * Creado por @author: GustavoP
 * el 9/07/20
 **/
public class Arbol {

    Nodo raiz;

    public Arbol(int dato) {
        raiz = new Nodo(dato);
    }

    public Arbol() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public int obtenerFe(Nodo padre) {
        if (padre == null) {
            return -1;
        } else {
            return padre.getFe();
        }
    }

    // rotacion simple izquierda, roto hacia la derecha
    public Nodo rotacionIzquierda(Nodo Padre) {
        Nodo aux = Padre.getHijoIzquierdo();
        Padre.setHijoIzquierdo(aux.getHijoDerecho());
        aux.setHijoDerecho(Padre);
        //actualizo las alturas
        Padre.setFe(Math.max(obtenerFe(Padre.getHijoIzquierdo()), obtenerFe(Padre.getHijoDerecho())) + 1);
        aux.setFe(Math.max(obtenerFe(aux.getHijoIzquierdo()), obtenerFe(aux.getHijoDerecho())) + 1);
        return aux;
    }

    // rotacion simple derecha, roto hacia a la izquierda
    public Nodo rotacionDerecha(Nodo Padre){
            Nodo aux =Padre.getHijoDerecho();
            Padre.setHijoDerecho(aux.getHijoIzquierdo());
            aux.setHijoIzquierdo(Padre);
            //actualizo alturas
            Padre.setFe(Math.max(obtenerFe(Padre.getHijoIzquierdo()),obtenerFe(Padre.getHijoDerecho()))+1);
            aux.setFe(Math.max(obtenerFe(aux.getHijoIzquierdo()),obtenerFe(aux.getHijoDerecho()))+1);
            return aux;
    }

    // rotacion doble a la izquieda
    public Nodo rotacionDobleIzquierda(Nodo Padre) {
        //Detecto que hay un desbalance por derecha para girar hacia la izquierda
        Padre.setHijoIzquierdo(rotacionDerecha(Padre.getHijoIzquierdo()));
        Nodo aux = rotacionIzquierda(Padre);
        return aux;
    }

    //rotacion doble derecha
    public Nodo rotacionDobleDerecha(Nodo Padre) {
        //Detecto que hay un desbalance por izquierda para girar hacia la derecha
        Padre.setHijoDerecho(rotacionIzquierda(Padre.getHijoDerecho()));
        Nodo aux = rotacionDerecha(Padre);
        return aux;
    }

    public static void main(String[] args) {

    }
}
