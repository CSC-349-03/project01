/*  David Twyman, Andrew LeDawson
**  dtwyman@calpoly.edu, aledawson@calpoly.edu
**  CSC 349-03
**  Project 1
**  1-10-2018
*/

import java.util.*;

public class Sorts
{
	public static void selectionSort (int[] arr, int N)
	{
		for (int i = 0; i < N; i++)
		{
			int min = arr[i];
			int index = i;
			for (int j = i; j < N; j++)
			{
               if (arr[j] < min)
               {
                  min = arr[j];
                  index = j;
               }
			}
			arr[index] = arr[i];
			arr[i] = min;
		}
	}

	public static void mergeSort (int[] arr, int N)
	{
       mergeSort(arr, 0, N - 1);
	}

	private static void mergeSort(int[] arr, int start, int end)
	{
       if ((end - start + 1) > 1)
       {
          mergeSort(arr, start, (end - start)/2 + start);
          mergeSort(arr, (end - start)/2 + 1 + start, end);
          merge(arr, start, end);
       }
	}

	public static void merge(int[] arr, int start, int end)
	{
	   int half = (end - start)/2 + start;
       int[] temp = new int[1 + end - start];
       int index1 = start;
       int index2 = half + 1;
       int tmpInd = 0;
       for (int index = 0; index <= (end - start); index++)
       {
       	   if (index1 > half)
       	   {
               temp[index] = arr[index2];
       	   	   index2++;
       	   }
       	   else if (index2 > end || (arr[index1] < arr[index2]))
       	   {

       	       temp[index] = arr[index1];
       	       index1++;
       	   }
       	   else
       	   {
       	   	   temp[index] = arr[index2];
       	   	   index2++;
       	   }
       }
       for (int i = start; i <= end; i++)
       {
           arr[i] = temp[tmpInd];
           tmpInd++;
       }
	}
}
