package PracticeInterviewBit.util;

/**
 * @author njain
 */
public class OptimisedPowerExponential {
    // Given that power is always positive and whole
    public static int power(int base, int exponent){
        if(exponent == 0){
            return 1; // base^0
        }
        if(exponent == 1){
            return base; // base^1
        }

        int halfPower = power(base, exponent/2);

        if(exponent % 2 == 0){
            return  halfPower * halfPower;
        }else{
            return  base*halfPower*halfPower;
        }

    }

    public static void main(String[] args) {
        System.out.println("power(5,4) = " + power(2, 30));
    }
}
