/*  David Twyman, Andrew LeDawson
**  dtwyman@calpoly.edu, aledawson@calpoly.edu
**  CSC 349-03
**  Project 1
**  1-10-2018
*/

import java.util.*;

public class sortsTest_timing
{
   public static void main(String[] args)
   {
      int[] selection = new int[160000];
      int[] merge = new int[160000];
      int[] quick = new quick[160000]
      int rand = 0;
      Random random = new Random();
      for (int i = 5000; i <= 160000; i*=2)
      {
         for (int j = 0; j < i; j++)
         {
         	for (int k = 0; k < 5; k++)
         	{
      	       rand = (random.nextInt(320000) + 1);
               selection[i] = rand;
               merge[i] = rand;
               quick[i] = rand;
               int start = System.nanoTime();
               Sorts.selectionSort(selection, i);
               int end = System.nanoTime();
               int selectionTime = (end - start)/1000000;
               start = System.nanoTime();
               Sorts.mergeSort(merge, i);
               end = System.nanoTime();
               int mergeTime = (end - start)/1000000;
               start = System.nanoTime();
               Sorts.quickSort(quick, i);
               end = System.nanoTime();
               int quickTime = (end - start)/1000000;
               System.out.println("N = " + i + ": T_ss = " + selectionTime + ", T_ms = " + mergeTime + "T_qs = " + quickTime);
            }
            System.out.println("");
         }
      }
   }

   private static void checkSorted(int[] arr, int N)
   {
      int stop = N - 1;
      boolean sorted = true;
      for (int i = 0; i < stop; i++)
      {
         if (arr[i] > arr[i + 1])
         {
            sorted = false;
            System.out.println("Not sorted");
            return;
         }
      }
      if (sorted)
      {
         System.out.println("The list is properly sorted");
      }
      else
      {
         System.out.println("Not sorted");
      }
   }
}