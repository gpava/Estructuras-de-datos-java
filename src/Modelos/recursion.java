package Modelos;
import javax.swing.*;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Creado por @author: GustavoP
 * el 31/05/20
 **/
public class recursion {
    /**
     * Metodo recursivo que saluda 10 veces
     *
     * @param nombre nombre
     * @param veces  veces a iniciar es decir 0 y va hasta 10.
     */
    public void saludarR(String nombre, int veces) {
        if (veces == 10) {
            return;
        }
        System.out.println("Hola: " + nombre);
        saludarR(nombre, veces + 1);
    }

    public static boolean esPrimo(int numero)
    {
        int contador=2;
        boolean primo = true;

        while((primo)&&(contador!=numero))
        {
            if(numero% contador == 0)
            {
                primo = false;
                contador++;
            }
        }

        return primo;
    }

    /**
     * Suma los datos enteros de un arraylist
     *
     * @param datos     arraylist
     * @param pos       posicion a iniciar
     * @param sumatoria suma de los datos del arraylist.
     */
    public void sumarA(ArrayList<Integer> datos, int pos, int sumatoria) {
        if (datos.size() == pos) {
            System.out.println("la sumatoria es: " + sumatoria);
            return;
        }
        sumatoria = sumatoria + datos.get(pos);
        sumarA(datos, pos + 1, sumatoria);
    }

    /**
     * Suma los num numeros desde num hasta cero.
     *
     * @param num       numeros a sumar
     * @param sumatoria suma  de los num numeros
     */
    public void sumaN(int num, int sumatoria) {
        if (num <= 0) {
            System.out.println("el total es: " + sumatoria);
            return;
        }
        sumatoria = sumatoria + num;
        sumaN(num - 1, sumatoria);
    }

    /**
     * Sumas los num numeros de cero en adelante con recursion
     *
     * @param num       numeros a sumas
     * @param sumatoria suma de los num numeros.
     */
    public void sumaN2(int num, int sumatoria) {
        if (num > 0) {
            sumatoria = sumatoria + num;
            if (num == 1) {
                System.out.println("sumatoria es: " + sumatoria);
            }
            sumaN2(num - 1, sumatoria);
        }
    }

    /**
     * Invierte los datos de un Linkedlist
     *
     * @param numeros Linkedlist
     * @param pos     posicion a iniciar
     * @return un nuevo Linkedlist pero con los elementos invertidos
     */
    public LinkedList<Object> invertir(LinkedList<Integer> numeros, int pos) {
        //recursion
        if (pos == numeros.size()) return new LinkedList<>();

        LinkedList<Object> datos = invertir(numeros, pos + 1);
        //backtracking
        datos.add(numeros.get(pos));
        return datos;
    }

    /**
     * Suma los n numeros con backtracking
     *
     * @param n el numero a sumar, es decir si n=100 me sumas los primeros 100
     *          numeros.
     * @return la suma de los n numeros.
     */
    public int sumarback(int n) {
        if (n == 0) {
            return 0;
        }
        int dato = sumarback(n - 1);
        return (dato + n);
    }

    /**
     * Metodo backtracking para determinar cuantas veces se repite un
     * elemento de una linkedlist
     *
     * @param numeros linkedlist de enteros
     * @param pos     posicion a iniciar
     * @param nbuscar numero a buscar
     * @return el numero de veces que se encuentra nbuscar
     */
    public int BuscarL(LinkedList<Integer> numeros, int pos, int nbuscar) {
        if (pos == numeros.size()) return 0;

        int veces = BuscarL(numeros, pos + 1, nbuscar);
        if (numeros.get(pos) == nbuscar) {
            veces = veces + 1;
        }
        return veces;
    }

    /**
     * Metodo recursivo con backtracking para encontrar el elemento
     * menor en un arreglo
     *
     * @param a   arreglo
     * @param pos posicion a iniciar
     * @return el elemento menor del arreglo
     */
    public int menorarray(int a[], int pos) {
        if (pos == a.length) {
            return a[pos - 1];
        }
        //backtracking
        int l = menorarray(a, pos + 1);
        if (l > a[pos]) {
            l = a[pos];
        }
        return l;
    }

    /**
     * Metodo recursivo para calular las tablas de multiplicar
     *
     * @param tabla  numero a calcular la tabla de multiplicar
     * @param numero hasta donde hacer la tabla de multiplicar
     */
    public static void tablamultiplicar(int tabla, int numero) {
        if (numero > 1) {
            tablamultiplicar(tabla, numero - 1);
        }
        System.out.println(tabla + "x" + numero + "=" + tabla * numero);
    }

    /**
     * Invierte numero con recursion y backtracking
     *
     * @param num numero a invertir
     * @return numero invertido
     */
    public String invertirNumero(int num) {
        String T = "";
        if (num > 10) {
            T = invertirNumero(num / 10);
        }
        return (num % 10 + "" + T);
    }

    public void imprimirvector(double[] array, int pos) {
        if (pos == array.length) return;
        System.out.println(array[pos]);
        imprimirvector(array, pos + 1);
    }

    public void imprimirArraylist(ArrayList<Integer> array, int pos) {
        if (pos == array.size()) return;
        System.out.println(array.get(pos));
        imprimirArraylist(array, pos + 1);
    }

    public void imprimirLinkedlist(LinkedList<Integer> lista, int pos) {
        if (pos == lista.size()) return;
        System.out.println(lista.get(pos));
        imprimirLinkedlist(lista, pos + 1);
    }

    /**
     * Método Quicksort recursivo que ordena el vector de
     * menor a mayor (Complejidad algoritmica: cuando el pivote es el elemento menor del array
     * el tiempo de ejecución del método Quicksort es O(n).
     * En general el tiempo medio de ejecución del Quicksort es O(n log n).)
     *
     * @param A   arreglo a ordenar
     * @param izq pivote a izquierda será 0 ya que el pivote a
     *            izquierda es en el main es arreglo[0]
     * @param der pivote a derecha sera el índice mayor del arreglo el cual
     *            como sabemos es arreglo.length -1
     */
    public static void quicksort(int A[], int izq, int der) {
        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;
        while (i < j) {            // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) { // busca elemento mayor que pivote
                i++;
            }
            while (A[j] > pivote) { // busca elemento menor que pivote
                j--;
            }
            if (i < j) {                      // si no se han cruzado
                aux = A[i];                  // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1)
            quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
        if (j + 1 < der)
            quicksort(A, j + 1, der); // ordenamos subarray derecho
    }

    /**
     * Método recursivo por pila para calcular el factorial de un número
     *
     * @param n número a calcularle el factorial
     * @return el factorial de n
     */
    public long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Método recursivo para calcular los números de fibonacci
     *
     * @param n el número a calcular fibonacci
     * @return el número de fibonacci de n
     */
    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /**
     * Método recursivo por cola del factorial de un número
     *
     * @param n         número a calcular el fact
     * @param resultado almace el resultado del factorial de cada llamado por cola
     * @return el factorial de n en resultado
     */
    public int factCola(int n, int resultado) {
        if (n == 1 || n == 0) {
            return resultado;
        } else {
            return factCola(n - 1, resultado * n);
        }
    }

    /**
     * Método recursivo por pila para calcular el cuadrado de un número entero usando
     * la suma de los n numeros impares.
     *
     * @param n número a calcularle su cuadrado
     * @return el cuadrado de n
     */
    public int cuadrado(int n) {
        if (n < 0) {
            n = n * (-1);
        }
        if (n == 1) {
            return 1;
        } else {
            return (2 * n - 1) + cuadrado(n - 1);
        }
    }

    /**
     * Método recursivo por pila para convertir número decimal en binario
     *
     * @param n número decimal
     * @return número binario de n.
     */
    public long binario(int n) {
        if (n < 2) {
            return n;
        } else {
            return n % 2 + binario(n / 2) * 10;
        }
    }

    /**
     * Mensaje que me imprime un triángulo rectángulo apuntando
     * hacia abajo
     *
     * @param n numero mayor de asteriscos
     */
    public void mensaje(int n) {
        String l = "*";
        if (n < 10) {
            mensaje(n + 1);
            System.out.println(l.repeat(n));
        }
    }

    public String serie1(int n, String cadena) {
        if (n == 1) {
            return "1, " + cadena;
        } else {
            cadena = "1/" + n + ", " + cadena;
            return serie1(n - 1, cadena);
        }
    }

    public String serie2(int n, String cadena) {
        if (n == 1) {
            return n + "/" + (n + 1) + ", " + cadena;
        } else {
            cadena = n + "/" + (n + 1) + ", " + cadena;
            return serie2(n - 1, cadena);
        }
    }

    public String serie3(int n, String cadena) {
        if (n == 1) {
            return (n - 4) + "/" + n + ", " + cadena;
        } else {
            cadena = (n - 4) + "/" + n + ", " + cadena;
            return serie3(n - 1, cadena);
        }
    }

    public String serie4(int n, String cadena) {
        if (n == 1) {
            return (int) (Math.pow(-1, n) * n) + ", " + cadena;
        } else {
            cadena = (int) (Math.pow(-1, n) * n) + ", " + cadena;
            return serie4(n - 1, cadena);
        }
    }

    public String serie5(int n, String cadena) {
        if (n == 1) {
            return (int) (Math.pow(-1, n + 1)) * (n + 2) + "/" + n + ", " + cadena;
        } else {
            cadena = (int) (Math.pow(-1, n + 1)) * (n + 2) + "/" + n + ", " + cadena;
            return serie5(n - 1, cadena);
        }
    }

    public String serie6(int n, String cadena) {
        if (n == 1) {
            return "1, " + cadena;
        } else {
            if (n % 2 == 0) {
                cadena = "1/" + n + ", " + cadena;
            } else {
                cadena = n + ", " + cadena;
            }
            return serie6(n - 1, cadena);
        }
    }

    public String serie7(int n, String cad) {
        if (n == 1) {
            return (int) (Math.pow(n + 1, 2) * (Math.pow(-1, n))) + ", " + cad;
        } else {
            cad = (int) (Math.pow(n + 1, 2) * (Math.pow(-1, n))) + ", " + cad;
            return serie7(n - 1, cad);
        }
    }

    public String serie8(int n, String cadena) {
        if (n == 1) {
            return ((int) (Math.pow(n, 2))) + "/" + (((int) (Math.pow(n, 2))) + 3) + ", " + cadena;
        } else {
            if (n % 2 == 0) {
                cadena = "1, " + cadena;
            } else {
                cadena = ((int) (Math.pow(n, 2))) + "/" + (((int) (Math.pow(n, 2))) + 3) + ", " + cadena;
            }
            return serie8(n - 1, cadena);
        }
    }

    /**
     * Método recursivo por pila Calcular la suma de pares n + (n-2) + (n-4) + ...
     *
     * @param n máximo de numeros
     * @return suma de los n pares
     */
    public int sumaenteros(int n) {
        if (n < 1) {
            return 0;
        } else {
            return n + sumaenteros(n - 2);
        }
    }

    /**
     * Método recursivo por pila para calcular la suma de dos numeros
     *
     * @param num1 numero 1
     * @param num2 numero 2
     * @return la suma de num1 y num2
     */
    public int operar(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else if (num2 < 0) {
            return operar(num1 - 1, num2 + 1);
        } else {
            return operar(num1 + 1, num2 - 1);
        }
    }
    /**
     * Algoritmo recursivo de las torres de hanoi
     * @param discos cantidad de discos
     * @param torre1 torre 1
     * @param torre2 torre 2
     * @param torre3 torre 3
     */
    public void torresHanoi(int discos, int torre1, int torre2, int torre3) {   //caso base
        if (discos == 1) {
            System.out.println("Mover disco de la torre " + torre1 + " a torre " + torre3);
        }
        //dominio
        else {
            torresHanoi(discos - 1, torre1, torre3, torre2);
            System.out.println("Mover disco de la torre " + torre1 + " a torre " + torre3);
            torresHanoi(discos - 1, torre2, torre1, torre3);
        }
    }
    /**
     *  suma los digitos de un numero n no negativo hacia atras
     * @param n numero
     * @return suma de los dígitos de n
     */
    public int sumadigitos(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n % 10 + sumadigitos((int) n / 10);
        }

    }

    /**
     * Suma los elementos del vector
     * @param v vector
     * @param i indice de iteración
     * @return suma de los elementos de v
     */
    public int sumar(int[] v, int i) {
        if (i == v.length) {
            return 0;
        } else {
            return v[i] + sumar(v, i + 1);
        }
    }

    /**
     * Invertir un número recursivo
     * @param n numero a invertir
     * @param potencia longitud del número menos 1
     * @return numero invertido
     */
    public int Invertir(int n, int potencia) {
        if (n < 10) {
            return n;
        } else {
            return (n % 10) * (int) Math.pow(10, potencia) + Invertir(n / 10, potencia - 1);
        }
    }

    /**
     * Invertir una palabra o cadena de caracteres recursivo
     * @param cadena cadena a invertir
     * @param longitud longitud de la cadena
     * @return la cadena invertida
     */
    public String InvertirPalabra(String cadena, int longitud) {
        if (longitud == 0) {
            return cadena.charAt(longitud) + "";
        } else {
            return cadena.charAt(longitud) + InvertirPalabra(cadena, longitud - 1);
        }
    }

    /**
     * Dado un numero n obtiene la suma de sus digitos recursivo hacia adelante
     * @param n numero
     * @return la suma de sus digitos
     */
    public int Suma(int n) {
        if (n <= 9) {
            return n;
        } else {
            return Suma(n / 10) + n % 10;
        }
    }

    /**
     *  máximo común divisor recursivo
     * @param x num 1
     * @param y num 2
     * @return máximo común divisor de x y y
     */
    public int Mcd(int x, int y) {
        if (y <= x && x % y == 0) {
            return y;
        } else if (x < y) {
            return Mcd(y, x);
        } else {
            return Mcd(y, x % y);
        }
    }
    /**
     *  máximo común divisor recursivo por cola
     * @param a num 1
     * @param b num 2
     * @return máximo común divisor de x y y
     */
    public int mcdCola(int a, int b){
        if (b==0){
            return a;
        }else{
            return mcdCola(b,a%b);
        }

    }

    /**
     *  Eleva un numero en base b a la n recursivo
     * @param b base
     * @param n numero a elevar b, es decir se tiene que es b^n
     * @return b^n
     */
    public float potencia(float b, float n) {
        if (n == 0) {
            return 1;
        }else if(n==1){
            return b;
        }else if(n<0){
            return potencia(b,n+1) / b;
        }else{
            return b*potencia(b,n-1);
        }
    }

    /**
     * Calcular función de Ackerman recursivo
     * @param m numero 1
     * @param n numero 2
     * @return A(m,n) Ackerman de m y n
     */
    public int Ack(int m, int n) {
        if (m == 0)
        {
            return n + 1;
        }
        else if (m > 0 & n == 0)
        {
            return Ack(m - 1, 1);
        }
        else
        {
            return Ack(m - 1, Ack(m, n - 1));
        }
    }

    /**
     * Calcular el producto de los valores de un arreglo de
     *  enteros que sean mayores a b recursivo
     * @param v vector
     * @param b numero a comparar
     * @param i variable de iteración
     * @return el producto de los valores de un arreglo de
     *          enteros que sean mayores a b
     */
    public int product(int[] v, int b, int i) {
        if (i == v.length - 2)
        {
            return v[i] * v[i + 1];
        }

        int valor = v[i];

        if (v[i] <= b)
        {
            valor = 1;
        }
        return valor * product(v, b, i + 1);
    }

    /**
     * Encontrar el valor mayor en un arreglos de reales recursivo
     * @param v vector
     * @param i variable de iteración
     * @return el elemento mayor del vector
     */
    public float Mayor(float[] v, int i) {
        if (i == v.length - 2)
        {
            return v[i];
        }

        float x = Mayor(v, i + 1);

        if (v[i] > x)
        {
            return v[i];
        }
        else
        {
            return x;
        }
    }

    /**
     * Imprimir el alfabeto con recursion indirecta
     * @param c carácter 'Z'
     */
    public static void alfabetoA(char c){
        if (c>'A'){
            alfabetoB(c);
        }
        System.out.println(c);
    }
    public static void alfabetoB(char c){
        alfabetoA(--c);
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /** Escribir un programa que retorne la suma de los enteros positivos pares desde N hasta 2.
     * Chequear que si N es impar se guarde en una lista un mensaje de error por cada número impar
     *
     * @param n cantidad maxima de pares
     * @param a lista de errores
     * @return suma de los pares desde n hasta 2
     */
    public int sumaPares(int n, ArrayList<String> a){
        if(n==2){
            return 2;
        }
        int suma=sumaPares(n-1,a);
        if(n%2==0){
            suma+=n;
        }else{
            a.add("Error"+ n+ " Es impar");
            System.out.println("Error"+ n+ " Es impar");
        }
        return suma;
    }

    /**
     *    función recursiva llamada Merge que, a partir de dos listas ordenadas L1 y L2,
     *     retorne una lista ordenada L3, a través de un proceso de intercalación de elementos. 
     * @param dat1 lista 1
     * @param dat2 lista 2
     * @param pos posicion a iniciar
     * @return lista 3 ordenada intercalada
     */
    public LinkedList<Object> merge(LinkedList<Integer> dat1, LinkedList<Integer> dat2, int pos)
    {
        if (pos == dat1.size())
        {
            return new LinkedList<>();
        }
        LinkedList<Object> temp = merge(dat1, dat2, pos + 1);
        temp.add(dat1.get(pos));
        temp.add(dat2.get(pos));
        return temp;
    }

    /**
     *  Producto de dos números mediante sumas sucesivas
     * @param a numero a
     * @param b numero b
     * @return producto de a y b con sumas sucesivas
     */
    public static int productosumasucesivas(int a,int b){
        if (b==1){
            return a;
        }else{
            return  a + productosumasucesivas(a,b-1);
        }
    }

    /**
     * Algoritmo recursivo de busqueda Binaria
     * @param a arreglo ordenado de n elementos
     * @param clave clave explora el arreglo de n elementos hasta que encuentra o decide
     *                 que no la encuentra
     * @param inf limite superior del arreglo
     * @param sup limite inferior del arreglo
     * @return  posición de un valor en un array ordenado.
     */
    public static int busquedaBinaria(double a[],double clave, int inf, int sup){
        int central;
        if (inf > sup){
            return -1;
        }else{
            central = (inf+sup)/2;
            if (a[central]==clave){
                return central;
            }else if (a[central]<clave){
                return busquedaBinaria(a,clave,central+1,sup);
            }else{
                return busquedaBinaria(a,clave,inf,sup-1);
            }
        }
    }

    /**
     * Algoritmo mergesort para ordenar array por "mezclas"
     * @param a arreglo
     * @param primero indice inicial
     * @param ultimo indice final (longitud de a -1)
     */
    public static void mergesort(double a[], int primero,int ultimo){
        int central;
        if(primero<ultimo){
            central=(primero+ultimo)/2;
            mergesort(a,primero,central);
            mergesort(a,central+1,ultimo);
            mezcla(a,primero,central,ultimo);
        }
    }
    //mezcla las dos subarreglos ordenadas
    public static void mezcla(double a[],int izq,int medio,int dere){
        double [] tmp = new double[a.length];
        int i, k, z;
        i=z=izq;
        k=medio+1;
        //bucle para la mezcla, utiliza tmo[] como arreglo auxiliar
        while (i<=medio && k <= dere){
            if(a[i]<=a[k]){
                tmp[z++]=a[i++];
            }else {
                tmp[z++]=a[k++];
            }
        }
        //se mueven elementos no mezclados de subarreglos
        while (i<=medio)
            tmp[z++]=a[i++];
        while (k<=dere)
            tmp[z++]=a[k++];
        //copia de elementos de tmp[] al arreglo a[]
        System.arraycopy(tmp,izq,a,izq,dere-izq+1);
    }
    
     public void e3(int a[], int b[], int n) {
        if (n < a.length) {
            b[a.length - 1 - n] = a[n];
            e3(a, b, n + 1);
        } else {
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + ", ");
            }
        }
    }
    
      public void e4(int a[], int n, int k) {
        int aux;
        if (k < a.length - 1) {
            if (n < a.length - 1) {
                if (a[n] > a[n + 1]) {
                    aux = a[n];
                    a[n] = a[n+1];
                    a[n+1] = aux;
                }
                e4(a, n+1,k);
            } else if(n>= a.length -1){
                e4(a,k,k+1);
            }
        }else{
            for(int i=0; i<a.length; i++){
                System.out.println(a[i]+",");
            }
        }
      }
    
     public void e5(int[]x, int aux){
         if(aux>x.length-1){
             return;
         }  
         System.out.print(x[aux]+",");
         e5(x,aux+1);
     }
     
    public void e6(LinkedList<Integer> x, int aux){
         if(aux<x.size()){
         System.out.print(x.get(aux)+",");
         e6(x,aux+1);
         }
    }
    public void e7(LinkedList<Integer> x, int aux){
         if(aux<x.size())
         {
         System.out.print(x.get(aux)+",");
         e6(x,aux+1);
     	 }
    }
    
     public int e9 (int[] y, int x){
        if(x==y.length){
            return 0;
        }
        int suma=e9(y, x+1);
        if(y[x] % 1 ==0){
            suma+=y[x];
        }
        return suma;
    }
        
        public ArrayList<Integer> e10(ArrayList<Integer> a, ArrayList<Integer> c, int n) {
        if (n == a.size()) {
            return c;
        }
        ArrayList<Integer> b = e10(a, c, n + 1);
        b.add(a.get(n));

        return b;
       }
       
        public String e11(int a, int p, int b) {

        if ((10 * a / p) < 1) {
            return Integer.toString(100 * a / p);
        }
        String k = e11(a, p * 10, (a % p) / (p / 10));
        System.out.println(b);

        return b + "" + k;
       }
        public int trece(int a[], int pos) {
        if (pos == a.length) {
            return a[pos - 1];
        }
        int k = trece(a, pos + 1);
        if (k > a[pos]) {
            k = a[pos];
        }
        return k;
       }
    
     public int e14(int[] x, int r, int n){
         if(n==x.length){
             return 0;
         }
        int veces =e14(x,r,n+1);
        if(x[n]==r) {
            veces++;
        }
        return veces;
      }
    //ejercicio16

    /*public LinkedList<Object> merge(LinkedList<Integer> dat1, LinkedList<Integer> dat2, int pos)
    {
        if (pos == dat1.size())
        {
            return new LinkedList<>();
        }
        LinkedList<Object> temp = merge(dat1, dat2, pos + 1);
        temp.add(dat1.get(pos));
        temp.add(dat2.get(pos));
        return temp;
    }*/

   /* public LinkedList<Integer> invertir(LinkedList<Integer> dat1, int pos)
    {
        if (pos == dat1.size())
        {
            return new LinkedList<>();
        }
        LinkedList<Integer> temp = invertir(dat1,pos+1);
        temp.add(dat1.get(pos));
        return temp;
    }*/

    public String invertirNum(String palabra, int pos)
    {
        if (pos == palabra.length())
        {
            return new String();
        }
        String temp = invertirNum(palabra, pos + 1);
        temp += palabra.charAt(pos);

        return temp;
    }

    /*public int sumaMatriz(int[][] a, int fil, int col)
    {
        if (fil == a.length)

            return 0;
        
        int c = sumaMatriz(a, fil + 1, col + 1);
        if
        c += a[fil][col];

      return c;
    }*/
    
    public int menorVector(int[] a, int pos)
    {
        if (pos == a.length)
        {
            return -1;
        }
        int temp = menorVector(a, pos + 1);
        if (temp > a[pos] || temp < 0)
        {
            temp = a[pos];
        }

        return temp;
    }

    public int cuantasVeces(int[] a, int pos, int num)
    {
        if (pos == a.length)
        {
            return 0;
        }
        int cant = cuantasVeces(a, pos + 1, num);
        if (num == a[pos])
        {
            cant += 1;
        }
        return cant;
    }

    public String esPrimo(int num, int aux, int cant)
    {

        if (aux > num)
        {
            return new String();
        }
        String primo = esPrimo(num, aux + 1, cant);
         if (aux!=0 &&num % aux == 0)
        {
            cant = cant + 1;
        }
        if (cant > 2)
        {
            primo ="SI";
        }
        else
        {
            primo = "NO";
        }
        return primo;

    }

    public int sumaNnum(String num, int pos)
    {
        if (pos == num.length())
        {
            return 0;
        }
        int cantPar = sumaNnum(num, pos + 1);
        if (num.charAt(pos) % 2 == 0 || num.charAt(pos) == 0)
        {
            cantPar += 1;
        }
        return cantPar;
    }

    public int factorialNum(int num, int pos)
    {
        if (pos > num)
        {
            return 1;
        }
        int factorial = factorialNum(num, pos + 1);
        if (pos > 0)
        {
            factorial *= pos;
        }
        return factorial;
    }

    public int sumaNum(int num, int pos)
    {
        if (pos > num)
        {
            return 0;
        }
        int suma = sumaNum(num, pos + 1);
        suma += pos;
        return suma;
    }

    public String existeElemento(LinkedList<String> datos, String x, int pos)
    {
        int cont=0;
        if (pos == datos.size())
            return new String();
        
        String texto = existeElemento(datos, x, pos + 1);
        if (datos.get(pos).contains(x)){
            cont+=1;
        }
        if(cont>0){
            texto="Existe";
        }
        else{
            texto="No Existe";
        }
        
        return texto;
    }
    
    public boolean sonIguales(LinkedList<Integer> dat1, LinkedList<Integer> dat2, int pos){
        int cont=0;
        if(pos==dat1.size())
            return false;
        boolean iguales=sonIguales(dat1, dat2, pos+1);
        if(dat1.get(pos)==dat2.get(pos)){
            cont+=1;
        }
        if(cont>0){
            iguales=true;
        }
        return iguales;
    }
    public String numBinario(int num){
  
        if(num<1){
            return new String();
        }
        String temp=numBinario(num/2);
        temp+=num%2;
        return temp;
    }


}
