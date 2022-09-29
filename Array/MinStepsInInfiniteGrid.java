package PracticeInterviewBit.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author njain
 */
public class MinStepsInInfiniteGrid {
    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int ans = 0;
        for(int i = 0 ; i < A.size()-1 ; i ++ ) {
            int startx = A.get(i);
            int starty = B.get(i);
            int destx = A.get(i+1);
            int desty = B.get(i+1);

            int distx = (destx - startx) > 0 ? destx - startx : startx - destx;
            int disty = (desty - starty) > 0 ? desty - starty : starty - desty;

            ans += (distx > disty) ? distx : disty;
            System.out.println("dist b/w " + A.get(i) + "," + B.get(i) + " and " + A.get(i+1) + "," + B.get(i+1)  + " is ans = " + ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] x = new int[]{4, 8, -7, -5, -13, 9, -7, 8};
        ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(x).boxed().collect(Collectors.toList());
        int[] y = new int[]{4, -15, -10, -3, -13, 12, 8, -8};
        ArrayList<Integer> B = (ArrayList<Integer>) Arrays.stream(y).boxed().collect(Collectors.toList());
        System.out.println("coverPoints(A,B) = " + coverPoints(A, B));
    }
}
