/*  David Twyman, Andrew LeDawson
 **  dtwyman@calpoly.edu, aledawson@calpoly.edu
 **  CSC 349-03
 **  Project 1
 **  1-19-2018
 */

import java.security.InvalidParameterException;
import java.util.Random;

public class SortCounts {
    private static int[] selectArray = new int[12800];
    private static int[] mergeArray = new int[12800];
    private static int[] quickArray = new int[12800];

    public static void main(String[] args){
        for (int testLength = 100; testLength <= 12800; testLength*=2) { // Go through every possible array size
            float selectTotal = 0;
            float mergeTotal = 0;
            float quickTotal = 0;
            for (int i = 0; i < 100 ; i++) { // Run each test 5 times
                generateRand(testLength); // Generate random arrays
                // Save start time, run sort, save end time, note duration
                selectTotal += Sorts1.selectionSort(selectArray, testLength);
                if(!checkSorted(selectArray, testLength)) {
                    System.out.println("ERROR: List not sorted!");
                }
                mergeTotal += Sorts1.mergeSort(mergeArray, testLength);
                if(!checkSorted(mergeArray, testLength)) {
                    System.out.println("ERROR: List not sorted!");
                }
                quickTotal += Sorts1.quicksort(quickArray, testLength);
                if(!checkSorted(quickArray, testLength)) {
                    System.out.println("ERROR: List not sorted!");
                }
            }
            System.out.println("N = " + testLength + ": T_ss = " + selectTotal/100 + ", T_ms = " + mergeTotal/100 + ", T_qs = " + quickTotal/100);
        }
    }

    private static void generateRand(int length){
        Random randomGenerator = new Random();
        if(length > selectArray.length){
            throw new InvalidParameterException("Desired length is longer than array capacity!");
        }
        for(int i = 0; i < length; i++){
            selectArray[i] = mergeArray[i] = quickArray[i] =  randomGenerator.nextInt(selectArray.length - 1);
        }
    }

    private static boolean checkSorted(int[] arr, int N)
    {
        for (int i = 0; i < N - 1; i++)
        {
            if (arr[i] > arr[i + 1])
            {
                return false;
            }
        }
        return true;
    }
}