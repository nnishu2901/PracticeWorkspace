package PracticeInterviewBit.Math.NumberTheory;

import java.util.ArrayList;

/**
 * @author njain
 */
public class DivisibleBy60 {
    public static int divisibleBy60(ArrayList<Integer> A) {
        // 60 = 12 * 5
        //     = 2 * 2 * 3 * 5

        //     for div by 4 : even -> 4 , 8 , 12 , 16, 20 , 24 (ending in 4,8,2,6,0)
        //     for div by 3 : sum of digits divisible by 3
        //     for div by 5 : end in 0 or by 5

        //     common is end in 0 and sum of digits is div by 3 and last 2 digits divisible by 4

        int countOfZero = 0;
        int sumOfA  = 0;
        if(A.size() == 1 && A.get(0) == 0){
            return 1;
        }
        if(A.size() < 2){
            return 0;
        }
        if(A.size() == 2 && (!A.contains(6) || !A.contains(0)) ) {
            return 0;
        }
        for(int i = 0; i<A.size() ; i++){
            sumOfA += A.get(i);
            if(A.get(i) == 0){
                countOfZero++;
            }
        }
        if(sumOfA%3 != 0 || !A.contains(0)){
            return 0;
        }

        if(!(A.contains(2) || A.contains(4) || A.contains(6) || A.contains(8) || countOfZero < 2)){ // 00 covered by zero count
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {

    }
}
