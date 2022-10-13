package PracticeInterviewBit.Math.DigitOP;

/**
 * @author njain
 */
public class ReverseInteger {
    public static int reverse(int A) {
        int ans = 0;
        int tempA = A;
        boolean isNeg = (A <= 0);
        if(isNeg){
            tempA = -A;
        }
        int lastans;
        while(tempA > 0){
            lastans = ans;
            ans = ans * 10 + tempA%10;
            if(ans < 0 || ans/10 != lastans){
                ans = 0;
                break;
            }
            tempA = tempA/10;
            System.out.println("ans = " + ans);
        }

        System.out.println("A = " + A);
        System.out.println("ans = " + ans);
        if(isNeg){
            ans = -ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("reverse(366245711) = " + reverse(1103467312));
        System.out.println("reverse(-256) = " + reverse(-1146467285));

    }
}
