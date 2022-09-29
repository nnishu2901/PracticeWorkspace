package PracticeInterviewBit.Math.Adhoc;

/**
 * @author njain
 */
public class PowerOf2Integers {
    public static int isPower(int A) {
        int n = A;
        int p = 0;
        if(A == 1) return 1;
        // a^b = x ==> b = log(x) / log(a)
        for(int a=2; a<= Math.sqrt(n); a++)
        {
            p = (int)(Math.log(n) / Math.log(a));
            if(Math.pow(a,p) == A)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("isPower(1024000000) = " + isPower(1024000000));

    }
}
