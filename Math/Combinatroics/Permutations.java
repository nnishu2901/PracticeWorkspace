package PracticeInterviewBit.Math.Combinatroics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author njain
 */
public class Permutations {
    public static HashMap<Integer,Long> positionPermutationCount = new HashMap<>();
    public static Long factorial(int num){
        long ans = 1L;
        for(int i = 2 ; i<= num ; i++){
            ans *= i;
        }
        return ans;
    }

    public static int findCurrentPostion(int A, Long B){

        int ans = 0;
        int lastIndex = 1;
        positionPermutationCount.put(0,1L);
        for(int i = 1 ; i <= A ; i++ ){
            B = B - i * factorial(i);
            positionPermutationCount.put(i, lastIndex+  i * factorial(i));
            if(B <= 0){
                ans = i;
                break;
            }
        }
        return ans;
    }
    public static ArrayList<Integer> findPerm(int A, Long B) {

        /*
        Constraints :
        1 <= A <= 10^5 ie.. 100000 ie positions can be 1 lakhs here
        1 <= B <= min(1018, A!), where A! denotes the factorial of A.

        Positions as per understanding :
        4 3 2 1 0

        1 2 3 4 5 -> 1 -> start
        1 2 3 5 4 -> 1*1! -> 1
        1 2 4 3 5 -> 2*2!
        1 2 4 5 3
        1 2 5 3 4
        1 2 5 4 3 -> 2 + 4 = 6
        1 3 2 4 5 -> 3 * 3!
        1 3 2 5 4
        1 3 4 2 5
        1 3 4 5 2
        1 3 5 2 4 -> 11 and curpos = 3
        1 3 5 4 2 -> 2 + 4 + 1*3! = 2+4+6 = 12
        1 4 2 3 5 -> 2+4+6+1 = 13
        1 4 2 5 3
        1 4 3 2 5
        1 4 3 5 2
        1 4 5 2 3 ->
        1 4 5 3 2 -> 2 + 4 + 2*3! = 2 + 4 + 12 = 18
        .
        .
        .
        */

        Integer[] ansArr = new Integer[A];

        int tempA = A;
        for(int i = 0 ; i<A ; i++){
            ansArr[i] = tempA;
            tempA--;
        }
        ArrayList<Integer> ansList = new ArrayList<>(List.of(ansArr));
        if(B == 1){
            return ansList;
        }

        long curB = B - 1; // -1 for starting permutation
        int curPosition = findCurrentPostion(A,curB);
        System.out.println("curPosition = " + curPosition);
        System.out.println("B = " + B);

        int left = 0, right = curPosition; // only these numbers in the array will be changed
        while(true){
            // find digit at currentPosition first by dividing by factorial n * n!
            if(B == positionPermutationCount.get(curPosition)){
                // reverse from left to right

                break;
            }
            int digitCur = (int) ((B - positionPermutationCount.get(curPosition-1))/factorial(curPosition));
            System.out.println("digitCur = " + digitCur);
            break;

//            if(curB >= curPosition * factorial(curPosition+1)){
//                curB -= curPosition * factorial(curPosition+1);
//            }
//
//            if(curB == 0){
//                System.out.println("curB = " + curB);
//                System.out.println("curPosition = " + curPosition);
//                break;
//            }
//            curPosition++;
//            if(curPosition > A){
//                break;
//            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        System.out.println("findPerm(6,1) = " + findPerm(5, 3L));

    }
}
