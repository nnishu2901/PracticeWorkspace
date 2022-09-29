package PracticeInterviewBit.Array;

import java.util.Arrays;
import java.util.List;

/**
 * @author njain
 */
public class MaximumContiguousSubArray {
    public static int maxSubArray(final List<Integer> A) {
        int ans = Integer.MIN_VALUE;
        int curmax = 0;

        for(int i = 0 ; i < A.size() ; i++){
            curmax += A.get(i);
            if(curmax > ans){
                ans = curmax;
            }
            if(curmax < 0){
                curmax = 0;
            }
//            System.out.println("curmax = " + curmax);
//            System.out.println("ans = " + ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        System.out.println("maxSubArray(A) = " + maxSubArray(A));

    }
}
