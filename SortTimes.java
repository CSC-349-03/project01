import java.security.InvalidParameterException;
import java.util.Random;

/**
 * Created by Andrew LeDawson on 1/17/2018.
 */
public class SortTimes {
    private long startTime;
    private long endTime;
    private int[] selectArray = new int[160000];
    private int[] mergeArray = new int[160000];
    private int[] quickArray = new int[160000];
    private Random randomGenerator = new Random();

    public static void main(String[] args){
        // TODO
    }

    private void generateRand(int length){
        if(length > selectArray.length){
            throw new InvalidParameterException("Desired length is longer than array capacity!");
        }
        for(int i = 0; i < length; i++){
            selectArray[i] = mergeArray[i] = quickArray[i] =  randomGenerator.nextInt(selectArray.length - 1);
        }
    }
}