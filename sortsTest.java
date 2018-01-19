/*  David Twyman, Andrew LeDawson
**  dtwyman@calpoly.edu, aledawson@calpoly.edu
**  CSC 349-03
**  Project 1
**  1-10-2018
*/

import java.util.*;

public class sortsTest
{
   public static void main(String[] args)
   {
      int[] selection = new int[25];
      int[] merge = new int[25];
      int[] quick = new int[25];
      int rand = 0;
      Random random = new Random();
      for (int i = 0; i < 25; i++)
      {
      	 rand = (random.nextInt(2*25) + 1);
         selection[i] = rand;
         merge[i] = rand;
         quick[i] = rand;
         System.out.println(rand);
      } // TODO: Check every sorting algorithm
      sortsTest.checkSorted(merge, 25);
      Sorts.selectionSort(selection, 25);
      Sorts.mergeSort(merge, 25);
      Sorts.quicksort(quick, 25);
      System.out.println("\nAfter quick run");
      for (int i = 0; i < 25; i++)
      {
         //System.out.println(selection[i]);
         System.out.println(quick[i]);
      }
      sortsTest.checkSorted(quick, 25);
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