package PracticeInterviewBit.Math.Adhoc;

/**
 * @author njain
 */
public class IsRectangle {
    public static int solve(int A, int B, int C, int D) {

        boolean isRectangle = false;
        if((A == B && C == D) || (A==C && B==D) || (A==D && B==C)){
            isRectangle = true;
        }
        return isRectangle ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println("solve(1,2,3,4) = " + solve(1, 2, 2, 5));

    }
}
