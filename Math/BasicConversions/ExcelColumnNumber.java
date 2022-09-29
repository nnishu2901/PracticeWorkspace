package PracticeInterviewBit.Math.BasicConversions;

/**
 * @author njain
 */
public class ExcelColumnNumber {
    public static int titleToNumber(String A) {
        int ans = 0;
        int len = A.length();
        int pow = 0;

        for(int i = len-1 ; i>= 0 ; i--){
            ans += Math.pow(26,pow) * (A.charAt(i) - 64);
            pow++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("titleToNumber(\"AB\") = " + titleToNumber("AB"));
    }
}
