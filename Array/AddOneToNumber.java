package PracticeInterviewBit.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author njain
 */
public class AddOneToNumber {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int sum = 0 , carry = 1; // for the first time only we are getting carry
        ArrayList<Integer> ansList = new ArrayList<>(A);
        int ansctr = 0;
        for(int i = A.size()-1 ; i>= 0 ; i--){
            sum = A.get(i) + carry;
            carry = sum/10;
            sum = sum%10;
            ansList.set(ansctr, sum);
            ansctr++;
        }
        if(carry > 0){
            ansList.add(ansctr,carry);
        }

        ArrayList<Integer> revans = new ArrayList<>();
        sum = 0;
        for(int i = ansList.size()-1 ; i>= 0 ; i--){
            sum += ansList.get(i);
            if(sum != 0){
                revans.add(ansList.get(i));
            }
        }

        return revans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(9,9,9,9));
        System.out.println("plusOne(A).toString() = " + plusOne(A));
    }
}
