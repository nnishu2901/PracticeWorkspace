package PracticeInterviewBit.Array;

import java.math.BigInteger;

/**
 * @author njain
 */
public class LargeFactorial {
    public static String sumOfNumbers(int A) {
        return String.valueOf(((A*(A+1))/2));
    }

    public static String factorial(int A) {
        if(A<0 || A>100) {
            return "0" ;
        }

        if (A==0 || A==1){
            return "1";
        }

        if(A==2){
            return "2";
        }
        BigInteger ans = new BigInteger(factorial(A-1));
        //ans.multiply(BigInteger.valueOf(A));
        return String.valueOf(ans.multiply(BigInteger.valueOf(A)));
    }

    public static String factorialTough(int A) {
        char[] chars = new char[200];
        chars[0] = '1';
        String ans = "1";
        if(A >= 2 && A <= 100){
            for(int i = A ; i > 1 ; i--){
                int res=1,carry=0,j=0;
                while(chars[j] != '\0'){
                    res = ((int) (chars[j] - '0') * i) + carry;
                    carry = res/10;
                    res = res%10;
                    chars[j] = (char)(res + '0');
                    j++;
                    while(chars[j] == '\0' && carry > 0){
                            chars[j] = (char) (carry%10 + '0');
                            carry = carry/10;
                            j++;
                    }
                }
            }
        }
        String string = "";
        for(int i = 0 ; chars[i] != '\0' ; i++){
            string = chars[i] + string;
        }
        ans = string;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("sum of numbers till 6 is = " + sumOfNumbers(6));
        System.out.println("factorialTough 1 is = " + factorialTough(100));
        System.out.println("factorial of 100 is = " + factorial(100));
        System.out.println("length of factorial of 100 is = " + factorial(100).length());
    }
}
