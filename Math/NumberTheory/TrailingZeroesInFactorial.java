package PracticeInterviewBit.Math.NumberTheory;

/**
 * @author njain
 */
public class TrailingZeroesInFactorial {
    public static int trailingZeroes(int A) {
        int ans = 0;
        int c2=0,c5=0;

        for(int i = 1 ; i<= A; i++){
            int temp2 = i;
            while(temp2%2 == 0){
                c2++;
                temp2 = temp2/2;
            }

            int temp5 = i;
            while(temp5%5 == 0){
                c5++;
                temp5 = temp5/5;
            }
        }

//        System.out.println("Math.min(c2, c5) = " + Math.min(c2, c5));
        ans = Math.min(c2, c5);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("trailingZeroes(10) = " + trailingZeroes(10));
        System.out.println("trailingZeroes(50) = " + trailingZeroes(50));
        System.out.println("trailingZeroes(99) = " + trailingZeroes(99));
    }

}
