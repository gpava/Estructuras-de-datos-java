package Modelos;

/**
 * Creado por @author: GustavoP
 * el 15/06/20
 **/
public class Back {
    public void inicializarLaberinto()
    {
        int jugada=1;
        int laberinto[][]={ {0,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,0},
                {0,0,0,0,0,0,0,0},
                {0,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,1000}
        };
        laberinto[0][0]=jugada;
        buscarSolucion(laberinto, jugada+1, 0, 0);
    }

    public void mostrarSolucion(int laberinto[][])
    {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                if(laberinto[i][j]<10)
                    System.out.print(" | "+laberinto[i][j]+" | ");
                else
                    System.out.print(" | "+laberinto[i][j]+" |");

            }
            System.out.println("");
        }
    }

    public boolean buscarSolucion(int laberinto[][],int jugada,int fila,int col)
    {
        boolean solucion=false;
        if(laberinto[fila][col]==1000)//condicion de escape
        {
            laberinto[fila][col]=jugada-1;
            mostrarSolucion(laberinto);
            solucion=true;
            return true;
        }

        //mover derecha
        if(!solucion)
            if((col+1>=0 && col+1<laberinto[0].length) && (laberinto[fila][col+1]==0  || laberinto[fila][col+1]==1000))
            {
                if(laberinto[fila][col+1]!=1000)
                    laberinto[fila][col+1]=jugada;
                solucion=buscarSolucion(laberinto, jugada+1, fila, col+1);
                laberinto[fila][col+1]=0;
            }
        //mover izquierda
        if(!solucion)
            if((col-1>=0 && col-1<laberinto[0].length) && (laberinto[fila][col-1]==0  || laberinto[fila][col-1]==1000))
            {
                if(laberinto[fila][col-1]!=1000)
                    laberinto[fila][col-1]=jugada;
                solucion=buscarSolucion(laberinto, jugada+1, fila, col-1);
                laberinto[fila][col-1]=0;
            }
        //mover arriba
        if(!solucion)
            if((fila-1>=0 && fila-1<laberinto.length) && (laberinto[fila-1][col]==0  || laberinto[fila-1][col]==1000))
            {
                if(laberinto[fila-1][col]!=1000)
                    laberinto[fila-1][col-1]=jugada;
                solucion=buscarSolucion(laberinto, jugada+1, fila-1, col);
                laberinto[fila-1][col]=0;

            }

        //mover abajo
        if(!solucion)
            if((fila+1>=0 && fila+1<laberinto.length) && (laberinto[fila+1][col]==0  || laberinto[fila+1][col]==1000))
            {
                if(laberinto[fila+1][col]!=1000)
                    laberinto[fila+1][col]=jugada;
                solucion=buscarSolucion(laberinto, jugada+1, fila+1, col);
                laberinto[fila+1][col]=0;

            }

        return solucion;
    }


}
