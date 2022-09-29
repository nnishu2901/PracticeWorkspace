package PracticeInterviewBit.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author njain
 */
public class PickFromBothSide {
    public static int solve(ArrayList<Integer> A, int B) {
        int[] res = new int[2*B];
        for(int i = 0; i<B ; i++){
            res[i] = A.get(B - 1 - i);
        }
        for(int i = 0; i<B ; i++){
            res[B+i] = A.get(A.size() -1 - i);
        }

//        System.out.println("res.toString() = " + Arrays.toString(res));
        int ans = Integer.MIN_VALUE,curmax=0;

        for(int i= 0 ; i<2*B ; i++){
            curmax += res[i];

            if(i >= B){
                curmax -= res[i-B];
            }

//            System.out.println("curmax = " + curmax);

            if( i >= B-1 && ans < curmax){
                ans = curmax;
            }

//            System.out.println("ans = " + ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{200,2,3,60,70,4, 400,50,6};
        ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());

        System.out.println("solve(A,3) = " + solve(A, 5));

    }
}
