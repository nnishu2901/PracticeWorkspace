package PracticeInterviewBit.Math.NumberTheory;

/**
 * @author njain
 */
public class Fibonacci {
    public static int solve(int A) {
        int ans = 0;

        if(A == 1 || A == 2){
            return 1;
        }

        int last2 = 1, last1 = 1;
        for(int i = 3 ; i<=A ; i++ ){
            ans = (last2 + last1) % 1000000007;
            last2 = last1 % 1000000007;
            last1 = ans % 1000000007;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("solve(4) = " + solve(4));
//        System.out.println("solve(15) = " + solve(15));
        System.out.println("solve(1000000005) = " + solve(999999999));
    }
}
