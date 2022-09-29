package PracticeInterviewBit.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author njain
 */
public class Partitions {
    public static int solve(int A, ArrayList<Integer> B) {

        if(A < 3){
            return 0;
        }
        int ans = 0;
        long[] sumArray = new long[A];
        Long totalSum = Long.valueOf(B.get(0));
        sumArray[0] = B.get(0);

        for(int i = 1; i < A; i++){
            sumArray[i] = B.get(i) + sumArray[i-1];
            totalSum += B.get(i);
        }

        if(totalSum == 0){
            int numZeroes = 0;
            for(int i = 0 ; i<A ; i++){
                if(sumArray[i] == 0){
                    numZeroes++;
                }
            }
            if(numZeroes < 3){
                return 0;
            }
        }
//        System.out.println("sumArray = " + Arrays.toString(sumArray));
        if(totalSum % 3 != 0){
            return 0;
        }
        long dividedBy3 = totalSum / 3;
        int freqOfDiv3 = 0;
        if(sumArray[0] == dividedBy3){
            freqOfDiv3 = 1;
        }
        int countZeroSection1=0;
        int countZeroSection2=0;
        for(int i = 1; i < A; i++){
            if(sumArray[i-1] == dividedBy3){
                sumArray[i] = B.get(i);
            }else{
                sumArray[i] = B.get(i) + sumArray[i-1];
            }
            if(sumArray[i] == dividedBy3){
                freqOfDiv3++;
            }
            if(freqOfDiv3 == 1 && sumArray[i] == 0){
                countZeroSection1++;
            }
            if(freqOfDiv3 == 2 && sumArray[i] == 0){
                countZeroSection2++;
            }
        }

//        System.out.println("Arrays.toString(sumArray) = " + Arrays.toString(sumArray));

        if(freqOfDiv3 != 3){
            return 0;
        }

        ans = (countZeroSection1+1) * (countZeroSection2+1) ;

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0,1,-1,0,0));
        System.out.println("solve(A.size(), A) = " + solve(A.size(), A));

    }
}
