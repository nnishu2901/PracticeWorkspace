package PracticeInterviewBit.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author njain
 */


/*

Hint :

Case 1: A[i] > A[j] and i > j
|A[i] - A[j]| = A[i] - A[j]
|i -j| = i - j
hence, f(i, j) = (A[i] + i) - (A[j] + j) = Ai-Aj

Case 2: A[i] < A[j] and i < j
|A[i] - A[j]| = -(A[i]) + A[j]
|i -j| = -(i) + j
hence, f(i, j) = -(A[i] + i) + (A[j] + j) = - (Ai - Aj)

Case 3: A[i] > A[j] and i < j
|A[i] - A[j]| = A[i] - A[j]
|i -j| = -(i) + j
hence, f(i, j) = (A[i] - i) - (A[j] - j) = Ap - Aq

Case 4: A[i] < A[j] and i > j
|A[i] - A[j]| = -(A[i]) + A[j]
|i -j| = i - j
hence, f(i, j) = -(A[i] - i) + (A[j] - j) = - (Ap-Aq)

max of above 4 will give the ans

MAX(maxDiff(A[i]-i) , maxDiff(A[i]+i))
 */
public class MaxAbsoluteDifference {

    public static int maxArr(ArrayList<Integer> A) {
        int ans = 0,elemdiff=0,indexdiff=0 , curans = 0;
        int maxAdd = Integer.MIN_VALUE;
        int minAdd = Integer.MAX_VALUE;
        int maxSub = Integer.MIN_VALUE;
        int minSub = Integer.MAX_VALUE;
        int curAdd = 0; // A[i] + i
        int curSub = 0; // A[i] - i
        for(int i = 0 ; i<A.size() ; i++){
            curAdd = A.get(i) + i;
            curSub = A.get(i) - i;
            if(minAdd > curAdd){
                minAdd = curAdd;
            }

            if(maxAdd < curAdd){
                maxAdd = curAdd;
            }

            if(minSub > curSub) {
                minSub = curSub;
            }

            if(maxSub < curSub){
                maxSub = curSub;
            }
        }

        // max of Add and Sub is the ans
        ans = Math.max((maxAdd - minAdd) , (maxSub - minSub));
        ans = ans > 0 ? ans : (ans*-1);


        // Brute Force using 2 loops and O(n^2) complexity
//        for(int i = 0 ; i < A.size()-1 ; i++) {
//            for(int j = i+1 ; j < A.size() ; j++){
//                elemdiff = A.get(i) - A.get(j);
//                indexdiff = j-i;
//
//                elemdiff = elemdiff > 0 ? elemdiff : (elemdiff * -1) ;
//                indexdiff = indexdiff > 0 ? indexdiff : (indexdiff * -1);
//                curans = indexdiff + elemdiff;
//                if(curans > ans){
//                    ans = curans;
//                }
//            }
//        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(900,-100,-90,9));
        System.out.println("maxArr(A) = " + maxArr(A));

    }
}
