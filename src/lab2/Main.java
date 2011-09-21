/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



/**
 *
 * @author lucian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.print("Введите количество элементов последовательности:\n");
        int n = readInt();
        System.out.print ("Введите последовательность:\n");
        int [] sequence = new int [n];
        for (int i=0;i<n;i++)
        {
            sequence[i] = readInt();
        }
        maxRising(sequence, n);

        boolean[] flags = new boolean [n];

        for (int i=0;i<n;i++)
            for (int j=i+1;j<n;j++)
            {
                if (sequence[i]==sequence[j])
                {
                    flags[i]=true;
                    flags[j]=true;
                }
            }
       for (int i=0;i<n;i++)
       {
           if (flags[i])
               System.out.print (sequence[i]+" ");
       }
       System.out.print ("\n");

    }

    public static int readInt ()
    {
        InputStreamReader iStr = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (iStr);
        String inStr = "";
        try
        {
            inStr = br.readLine();
        }
        catch (IOException e)
        {
             System.out.println ("Err::IOError "+e+"\n");
        }

        try
        {
            return Integer.parseInt(inStr);
        }
        catch (NumberFormatException e)
        {
            System.out.println ("Err::NumberFormatError::"+e+"\n");
        }
        return 0;      
    }

    public static void maxRising (int [] sequence, int n)
    {
        System.out.print("Максимальная возрастающая подпоследовательность:\n");
        int arr[][] = new int [n][n];
        boolean flags [] = new boolean[n];
        for (int i=0;i<n;i++) flags[i]=false;

        int level = 0;
        for (int i=0;i<n;i++)
        {
            if (!flags[i])
            {
                flags[i]=true;
                arr[level][i]=sequence[i];
                int last = sequence [i];
                for (int j=i+1;j<n;j++)
                {
                    if (last>=sequence[j] && !flags[j])
                    {
                        arr[level][j]=sequence[j];
                        flags[j]=true;
                        last = sequence[j];
                    }
                }
                level++;
            }
        }
       for (int i=0;i<n;i++)
       {
           for (int j=0;j<n;j++)
           {
               System.out.print(arr[i][j]+" ");

           }
           System.out.print("\n");
       }
      
    }

    

}
