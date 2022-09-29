package PracticeInterviewBit.Math.Adhoc;

import java.util.ArrayList;

/**
 * @author njain
 */
public class PrimeSum {
    public static int isPrime(int A) {
        if(A==2 || A==3 || A==5 || A==7 || A==11 || A==13 || A==17 || A==19){
            return 1;
        }
        if(A<22){
            return 0;
        }
        int upperLimit = (int)(Math.sqrt(A));
        for (int i = 2; i <= upperLimit; i++) {
            if (i < A && A % i == 0) return 0;
        }
        return 1;
    }

    public static ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> ansList = new ArrayList<>(A);


        for(int i = 1; i <= A/2 ; i++){
            if(isPrime(i) == 1 && isPrime(A-i) == 1){
                ansList.add(i);
                ansList.add(A-i);
                break;
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        System.out.println("primesum(6) = " + primesum(78));

    }
}
