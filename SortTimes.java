/*  David Twyman, Andrew LeDawson
 **  dtwyman@calpoly.edu, aledawson@calpoly.edu
 **  CSC 349-03
 **  Project 1
 **  1-19-2018
 */

import java.security.InvalidParameterException;
import java.util.Random;

public class SortTimes {
    private static int[] selectArray = new int[160000];
    private static int[] mergeArray = new int[160000];
    private static int[] quickArray = new int[160000];

    public static void main(String[] args){
        long startTime;
        long endTime;
        for (int testLength = 5000; testLength <= 160000; testLength*=2) { // Go through every possible array size
            for (int i = 0; i < 5; i++) { // Run each test 5 times
                generateRand(testLength); // Generate random arrays
                // Save start time, run sort, save end time, note duration
                startTime = System.nanoTime();
                Sorts.selectionSort(selectArray, testLength);
                endTime = System.nanoTime();
                long selectionTime = (endTime - startTime) / 1000000;
                startTime = System.nanoTime();
                Sorts.mergeSort(mergeArray, testLength);
                endTime = System.nanoTime();
                long mergeTime = (endTime - startTime) / 1000000;
                startTime = System.nanoTime();
                Sorts.quicksort(quickArray, testLength);
                endTime = System.nanoTime();
                long quickTime = (endTime - startTime) / 1000000;
                System.out.println("N = " + testLength + ": T_ss = " + selectionTime + ", T_ms = " + mergeTime + "T_qs = " + quickTime);
            }
            System.out.println();
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
}