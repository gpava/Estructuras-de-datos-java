package Modelos;
import jdk.swing.interop.SwingInterOpUtils;
import java.util.*;
public class ArbolBinario
{
    NodoBinario raiz;

    public ArbolBinario(int dato)
    {
        raiz = new NodoBinario(dato);
    }

    /**
     * Constructor por defecto
     *
     */
    public ArbolBinario()
    {
        this.raiz = null;
    }
    /**
     * Metodo recursivo para agregar un nodo a un arbol binario de busqueda
     *
     * @param n Nuevo nodo a ingresar
     * @param dato dato a ingresar en el arbol
     */
    public void Agregar(NodoBinario n, int dato)
    {
        if (dato < n.dato)
        {
            if (n.hijoIzquierdo == null)
            {
                n.hijoIzquierdo = new NodoBinario(dato);
            }
            else
            {
                Agregar(n.hijoIzquierdo, dato);
            }
        }

        if (dato > n.dato)
        {
            if (n.hijoDerecho == null)
            {
                n.hijoDerecho = new NodoBinario(dato);
            }
            else
            {
                Agregar(n.hijoDerecho, dato);
            }
        }

    }
    public NodoBinario getRaiz() {
        return raiz;
    }
    public boolean estaVacio()
    {
        return raiz == null;
    }
    /**
     *
     * metodo para recorrer el arbol Inorden
     *
     * @param padre raiz de mi arbol
     */
    public void inorden(NodoBinario padre)
    {
        if (padre != null)
        {
            inorden(padre.getHijoIzquierdo());
            System.out.println(padre.getDato());
            inorden(padre.getHijoDerecho());
        }
    }
    /**
     *
     * metodo para recorrer un arbol en Preorden
     *
     * @param r raiz de mi arbol
     */
    public void PreOrden(NodoBinario r)
    {
        if (r != null)
        {
            System.out.println(r.dato);
            PreOrden(r.hijoIzquierdo);
            PreOrden(r.hijoDerecho);
        }
    }
    /**
     *
     * metodo para recorrer un arbol en Postorden
     *
     * @param r raiz de mi arbol
     */
    public void PostOrden(NodoBinario r)
    {
        if (r != null)
        {
            PostOrden(r.hijoIzquierdo);
            PostOrden(r.hijoDerecho);
            System.out.println(r.dato);
        }
    }
    public ArrayList<Object> inOrdenLis(NodoBinario Padre, ArrayList lista)
    {
        if (Padre != null) {
        inOrdenLis(Padre.getHijoIzquierdo(),lista);
        lista.add(Padre.getDato());
        inOrdenLis(Padre.getHijoDerecho(),lista);
       }
      return lista;
    }
    public ArrayList<Object> preOrdenLis(NodoBinario Padre, ArrayList lista)
    {
        if (Padre != null) {
        lista.add(Padre.getDato()); inOrdenLis(Padre.getHijoIzquierdo(),lista);
        inOrdenLis(Padre.getHijoDerecho(),lista);
        }
        return lista;
    }
    public ArrayList<Object> postOrdenLis(NodoBinario Padre, ArrayList lista){
        if (Padre != null) {
            inOrdenLis(Padre.getHijoIzquierdo(),lista);
            inOrdenLis(Padre.getHijoDerecho(),lista);
            lista.add(Padre.getDato());
        }
        return lista; }

    public void Anchura(NodoBinario r)
    {
        Queue<NodoBinario> cola = new LinkedList<>();
        NodoBinario aux;

        cola.add(r);

        while (!cola.isEmpty())
        {
            aux = cola.poll();

            System.out.print(aux.dato + "-");

            if (aux.hijoIzquierdo != null)
            {
                cola.add(aux.hijoIzquierdo);;
            }

            if (aux.hijoDerecho != null)
            {
                cola.add(aux.hijoDerecho);
            }
        }

    }
    /**
     * Calcular el peso o cantidad de nodo de un arbol binario de busqueda
     *
     * @param n raiz del arbol
     * @return numero de nodos del arbol (Peso)
     */
    public int Peso(NodoBinario n)
    {
        if (n == null)
        {
            return 0;
        }
        else
        {
            return Peso(n.hijoIzquierdo) + Peso(n.hijoDerecho) + 1;
        }
    }

    /**
     * Calcular la altura o la cantidad maxima de nodos que hay desde la raiz
     * hasta las hojas
     *
     * @param n raiz del arbol
     * @return altura del arbol
     */
    public int Altura(NodoBinario n)
    {
        if (n == null)
        {
            return 0;
        }
        else
        {
            return Math.max(Altura(n.hijoIzquierdo) + 1, Altura(n.hijoDerecho) + 1);
        }
    }

     public NodoBinario BuscarNodo(int elemento)
    {
        NodoBinario aux = raiz;

        while (aux.dato != elemento)
        {
            if (elemento < aux.dato)
            {
                aux = aux.hijoIzquierdo;
            }
            else
            {
                aux = aux.hijoDerecho;
            }

            if (aux == null)
            {
                return null;
            }
        }

        return aux;
    }
/*
    public boolean EliminarNodo(int elemento)
    {
        NodoBinario aux = raiz;
        NodoBinario padre = raiz;
        boolean esHijoIzquierdo = true;

        while (aux.dato != elemento)
        {
            padre = aux;

            if (elemento < aux.dato)
            {
                esHijoIzquierdo = true;
                aux = aux.hijoIzquierdo;
            }
            else
            {
                esHijoIzquierdo = false;
                aux = aux.hijoDerecho;
            }

            if (aux == null)
            {
                return false;
            }
        }//Fin del while

        if (aux.hijoIzquierdo == null && aux.hijoDerecho == null)
        {
            if (aux == raiz)
            {
                raiz = null;
            }
            else if (esHijoIzquierdo)
            {
                padre.hijoIzquierdo = null;
            }
            else
            {
                padre.hijoDerecho = null;
            }
        }
        else if (aux.hijoDerecho == null)
        {
            if (aux == raiz)
            {
                raiz = aux.hijoIzquierdo;
            }
            else if (esHijoIzquierdo)
            {
                padre.hijoIzquierdo = aux.hijoIzquierdo;
            }
            else
            {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        }
        else if (aux.hijoIzquierdo == null)
        {
            if (aux == raiz)
            {
                raiz = aux.hijoDerecho;
            }
            else if (esHijoIzquierdo)
            {
                padre.hijoIzquierdo = aux.hijoDerecho;
            }
            else
            {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        }
        else
        {
            NodoBinario reemplazo = obtenerNodoReemplazo(aux);

            if (aux == raiz)
            {
                raiz = reemplazo;
            }
            else if (esHijoIzquierdo)
            {
                padre.hijoIzquierdo = reemplazo;
            }
            else
            {
                padre.hijoDerecho = reemplazo;
            }

            reemplazo.hijoIzquierdo = aux.hijoIzquierdo;//importante
        }

        return true;
    }*/

   /* public NodoBinario obtenerNodoReemplazo(NodoBinario nodo)
    {
        NodoBinario reemplazarPadre = nodo;
        NodoBinario reemplazo = nodo;
        NodoBinario aux = nodo.hijoDerecho;

        while (aux != null)
        {
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.hijoIzquierdo;

        }

        if (reemplazo != nodo.hijoDerecho)
        {
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodo.hijoDerecho;
        }

        System.out.println("El Nodo reemplazo es " + reemplazo);
        return reemplazo;
    }
*/
    private int arbolSuma(ArbolBinario res, NodoBinario p)
    {
        if (p == null)
        {
            return 0;
        }
        else
        {
            int sum = p.dato;
            //NodoBinario tmp = res.AgregarNodo(sum);
            sum += arbolSuma(res, p.hijoIzquierdo);
            sum += arbolSuma(res, p.hijoDerecho);
            //tmp.dato = sum;
            return sum;
        }
    }

    /*
    public static NodoBinario Reconstruir(List<String> in, List<String> pos)
    {
        NodoBinario tmp = null;
        if (!in.isEmpty() && !pos.isEmpty())
        {
            if (in.size() == 1 && pos.size() == 1)
            {
                tmp = new NodoBinario(in.get(0));
                suma += Integer.parseInt(tmp.dato);
                if (suma < menorSuma)
                {
                    menorSuma = suma;
                    nodo = Integer.parseInt(tmp.dato);
                }
                suma -= Integer.parseInt(tmp.dato);
                return tmp;
            }
            else
            {
                String raiz = pos.get(pos.size() - 1);
                tmp = new Nodo(raiz);
                List<String> inIzq = in.subList(0, in.indexOf(raiz));
                List<String> posIzq = pos.subList(0, inIzq.size());
                List<String> inDer = in.subList(in.indexOf(raiz) + 1, in.size());
                List<String> posDer = pos.subList(inIzq.size(), pos.size() - 1);
                suma += Integer.parseInt(tmp.dato);
                tmp.izq = reconstruir(inIzq, posIzq);
                tmp.der = reconstruir(inDer, posDer);
                suma -= Integer.parseInt(tmp.dato);
                return tmp;
            }
        }
        return null;
    }
     */

    public void setRaiz(NodoBinario raiz) {

        this.raiz = raiz;
    }
    public boolean esRaiz(int dato){
        return raiz.getDato()==dato;
    }
    public boolean eshoja(NodoBinario n){

        return n.getHijoIzquierdo()==null && n.getHijoDerecho()==null;
    }
    public boolean esNodo(NodoBinario n){

        return !eshoja(n);
    }
    public int nHojas(NodoBinario r){
        if(r==null){
            return 0;
        }else{
            if(eshoja(r)){
                return 1;
            }
            return nHojas(r.getHijoIzquierdo()) + nHojas(r.getHijoDerecho());
        }
    }
    private int menor(int a,int b){
        if(b<a){
            return b;
        }else
        {
            return a;
        }
    }
    public int minSuma(NodoBinario n, int suma){
        if(n==null){
            return 0;
        }else{
            if(!eshoja(n)){
                return 1 + menor(minSuma(n.getHijoIzquierdo(),suma+n.getDato())
                        ,minSuma(n.getHijoDerecho(),suma+n.getDato()));
            }
            else{
                return suma + n.getDato();
            }
        }
    }
    public int datomenor(NodoBinario r) {
        if (r.getHijoIzquierdo()!=null){
            return datomenor(r.getHijoIzquierdo());
        }else
            return r.getDato();
        }
    public int datomayor(NodoBinario r) {
        if (r.getHijoDerecho()!=null){
            return datomayor(r.getHijoDerecho());
        }else
            return r.getDato();
    }
    /*public void ingresarPI(NodoBinario nuevo) {
        if (this.raiz == null) {
            this.raiz = nuevo;
        } else {
            ingresarPIR(nuevo, this.raiz);
        }
    }

    public boolean ingresarPIR(NodoBinario nuevo, NodoBinario padre) {

        if (padre == null) {
            return true;
        }

        if (nuevo.dato < padre.getDato() && esPrimo(nuevo.dato)==false)
        {
            if (ingresarR(nuevo, padre.getHijoIzquierdo())) {
                padre.setHijoIzquierdo(nuevo);
                return false;
            }
        }

        if (nuevo.dato > padre.getDato() && esPrimo(nuevo.dato)==true) {
            suma+=nuevo.getDato();
            if (ingresarR(nuevo, padre.getHijoDerecho())) {
                padre.setHijoDerecho(nuevo);
                return false;
            }
        }

        return false;
    }
    */
    //Ejercicio 12
    public ArrayList<Object> Hojas(NodoBinario r, ArrayList<Object> lista) {

        if (r == null ) {
            return new ArrayList<>();
        }if(eshoja(r)){
            lista.add(r.getDato());

        }else if(eshoja(r)){
            lista.add(r.getDato());

        }else{
            Hojas(r.getHijoDerecho(), lista);
            Hojas(r.getHijoIzquierdo(), lista);
        }
        return lista;
    }
    public static void main(String[] args)
    {
        ArbolBinario arbol = new ArbolBinario(20);
        arbol.Agregar(arbol.raiz, 18);
        arbol.Agregar(arbol.raiz, 40);
        arbol.Agregar(arbol.raiz, 15);
        arbol.Agregar(arbol.raiz, 60);
        arbol.Agregar(arbol.raiz, 11);
        arbol.Agregar(arbol.raiz, 17);
        arbol.Agregar(arbol.raiz, 50);
        arbol.Agregar(arbol.raiz, 80);
        arbol.Agregar(arbol.raiz, 50);
        System.out.println("Inorden");
        arbol.inorden(arbol.raiz);
        System.out.println("-----------------");
        System.out.println("la altura del arbol es: "+arbol.Altura(arbol.raiz));
        System.out.println("el arbol esta vacio: " + arbol.estaVacio());
        System.out.println("postorden");
        arbol.PostOrden(arbol.raiz);
        System.out.println("------------------");
        System.out.println("preorden");
        arbol.PreOrden(arbol.raiz);
        System.out.println("------------------");
        System.out.println("anchura");
        arbol.Anchura(arbol.raiz);
        System.out.print("\n"+"Peso del arbol: " +arbol.Peso(arbol.raiz));
        System.out.println("\n"+"la suma de los elementos en los nodos del arbol es: "+
                arbol.arbolSuma(arbol,arbol.raiz));
        //System.out.println(arbol.esRaiz(10));
        System.out.println("La cantidad de hojas del árbol es: " + arbol.nHojas(arbol.raiz));
        //int s=0;
        //System.out.println("Suma minima del arbol: "arbol.minSuma(arbol.raiz,s));
        ArrayList<Object> r = new ArrayList<>();
        arbol.inOrdenLis(arbol.raiz,r);
        for(int i = 0; i < r.size(); i++) {
            System.out.print("-"+ r.get(i));
        }
        System.out.println("\n"+"El menor del arbol es: "+ arbol.datomenor(arbol.raiz));
        System.out.println("\n"+"El mayor del arbol es: "+ arbol.datomayor(arbol.raiz));
        ArrayList<Object> l = new ArrayList<>();
        System.out.println("\n"+"las hojas del arbol son: "+ arbol.Hojas(arbol.raiz,l));
    }
}
