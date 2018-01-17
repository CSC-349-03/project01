/*  David Twyman, Andrew LeDawson
 **  dtwyman@calpoly.edu, aledawson@calpoly.edu
 **  CSC 349-03
 **  Project 1
 **  1-10-2018
 */

public class Sorts1
{
    public static int selectionSort(int[] arr, int N)
    {
        int compares = 0;
        for (int i = 0; i < N; i++)
        {
            int min = arr[i];
            int index = i;
            for (int j = i; j < N; j++)
            {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
                compares++;
            }
            arr[index] = arr[i];
            arr[i] = min;
        }
        return compares;
    }

    public static int mergeSort(int[] arr, int N)
    {
        return mergeSort(arr, 0, N - 1);
    }

    private static int mergeSort(int[] arr, int start, int end)
    {
        int compares = 0;
        if ((end - start + 1) > 1) {
            compares += mergeSort(arr, start, (end - start) / 2 + start);
            compares += mergeSort(arr, (end - start) / 2 + 1 + start, end);
            compares += merge(arr, start, end);
        }
        return compares;
    }

    public static int merge(int[] arr, int start, int end)
    {
        int compares = 0;
        int half = (end - start) / 2 + start;
        int[] temp = new int[1 + end - start];
        int index1 = start;
        int index2 = half + 1;
        int tmpInd = 0;
        for (int index = 0; index <= (end - start); index++)
        {
            compares++;
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
        for (int i = start; i <= end; i++) {
            arr[i] = temp[tmpInd];
            tmpInd++;
        }
        return compares;
    }

    public static int quicksort(int[] list, int N)
    {
        return quicksort(list, 0, N - 1);
    }

    private static int quicksort(int[] list, int first, int last)
    {
        int compares = 0;
        if (first < last)
        { // must be more than one element
            compares += setPivotToEnd(list, first, last);
            int pivotIndex = splitList(list, first, last);
            compares += quicksort(list, first, pivotIndex - 1);
            compares += quicksort(list, pivotIndex + 1, last);
        }
        return compares;
    }

    private static int setPivotToEnd(int[] array, int left, int right) {
        int compares = 0;
        if (right - left <= 2) { // If only 2 entries, put smaller first
            if (array[right] < array[left])
            {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            compares++;
            return compares;
        }
        int[] compare = {array[left], array[left + ((right - left) / 2)], array[right]};
        compares++;
        compares += selectionSort(compare, 3); // TODO: Use a more compare-efficient method?
        array[left] = compare[0]; // left number is lowest of the three
        array[right] = compare[1]; // center number is highest of the three
        array[left + ((right - left) / 2)] = compare[2]; // right number is middle of the three
        return compares;
    }

    private static int splitList(int[] array, int left, int right) {
        int indexLeft = left;
        int indexRight = right - 1;
        int pivot = array[right];
        while (indexLeft <= indexRight)
        {
            while (array[indexLeft] < pivot)
            {
                indexLeft++;
            }
            while (array[indexRight] > pivot && indexRight >= indexLeft)
            {
                indexRight--;
            }
            if (indexLeft <= indexRight)
            {
                int temp = array[indexLeft];
                array[indexLeft] = array[indexRight];
                array[indexRight] = temp;
                indexLeft++;
                indexRight--;
            }
        }
        int temp = array[right];
        array[right] = array[indexLeft];
        array[indexLeft] = temp;
        return indexLeft;
    }
}
