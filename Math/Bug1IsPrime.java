package PracticeInterviewBit.Math;

/**
 * @author njain
 */
public class Bug1IsPrime {
    public static int isPrime(int A) {
        int upperLimit = (int)(Math.sqrt(A));
        if(A <= 1){
            return 0;
        }
        for (int i = 2; i <= upperLimit; i++) {
            if (i < A && A % i == 0) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("isPrime(3) = " + isPrime(3));
        System.out.println("isPrime(6) = " + isPrime(6));
        System.out.println("isPrime(2) = " + isPrime(2));
        System.out.println("isPrime(1) = " + isPrime(1));
    }
}
