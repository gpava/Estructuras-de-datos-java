package Modelos;

/**
 * Creado por @author: GustavoP
 * el 16/06/20
 **/
public class Nreinas
{

    private final int[][] solucion = new int[8][8];

    public Nreinas()
    {
        for (int i = 0; i < solucion.length; i++)
        {
            for (int j = 0; j < solucion.length; j++)
            {
                solucion[i][j] = 0;
            }
        }
    }

    public void imprimir()
    {
        System.out.println();
        for (int i = 0; i < solucion.length; i++)
        {
            for (int j = 0; j < solucion.length; j++)
            {
                System.out.print(solucion[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public void vuelta_atras(int etapa)
    {
        for (int i = 0; i < solucion.length; i++)
        {
            if (aceptable(i, etapa))
            {
                solucion[i][etapa] = 1;

                if (etapa == solucion.length - 1)
                {
                    imprimir();
                }
                else
                {
                    vuelta_atras(etapa + 1);
                }

                solucion[i][etapa] = 0;
            }
        }
    }

    public boolean aceptable(int i, int etapa)
    {   //filas
        for (int j = 0; j <= i ; j++)
        {
            if (solucion[j][etapa] == 1)
            {
                return false;
            }
        }
        //columnas
        for (int j = 0; j <= etapa; j++)
        {
            if (solucion[i][j] == 1)
            {
                return false;
            }
        }
        int h = i;
        //diagonal izquierda
        for (int j = etapa; j >= 0 && h >= 0; j--)
        {
            if (solucion[h][j] == 1)
            {
                return false;
            }
            h--;
        }
        //diagonal derecha
        h = i;
        for (int j = etapa; j >= 0 && h < solucion.length; j--)
        {
            if (solucion[h][j] == 1)
            {
                return false;
            }
            h++;
        }

        return true;
    }

    public void resolver()
    {
        imprimir();
        vuelta_atras(0);
    }

    public static void main(String[] args)
    {
        Nreinas nr = new Nreinas();
        nr.resolver();
    }
}
