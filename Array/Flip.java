package PracticeInterviewBit.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author njain
 */
public class Flip {
    public static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> ansIndices = new ArrayList<>();
        int[] arr = A.chars().toArray();
        for(int i = 0; i<A.length(); i++){
            //System.out.println("arr[i] = " + arr[i]);
            if(arr[i] == 48){
                arr[i] = -1;
            }else if(arr[i] == 49){
                arr[i] = 1;
            }else{
                return ansIndices;
            }
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        int left = -1, right = -1, prefixSum = 0 , minSoFar = 1,curleft=-1,curright=-1;
        boolean isPart = false;
        for(int i = 0 ; i < arr.length ; i++){
            prefixSum += arr[i];
            if(prefixSum < 0){
                if(isPart){
                    curright = i;
                }else{
                    curleft = i;
                    curright = i;
                    isPart = true;
                }

                if(prefixSum < minSoFar){
                    minSoFar = prefixSum;
                    left = curleft;
                    right = curright;
                }
            }

            // >= 0 when we want the difference between indices least
            // >0 when we don't care about difference in indices and want the first occurring pair with maximum digits
            // Ex : 01001 -> if need answer 001 (then put >=0) if need answer 01001(then >0)
            if(prefixSum > 0){
                isPart = false;
                curleft = -1;
                curright = -1;
                prefixSum = 0;
            }
        }

//        System.out.println("minSoFar = " + minSoFar);
//        System.out.println("left = " + left);
//        System.out.println("right = " + right);

        if(minSoFar < 0){
            ansIndices.add(left);
            ansIndices.add(right);
        }

        return ansIndices;
    }

    public static void main(String[] args) {
        String A = "1101010001";
        System.out.println("flip(A) = " + flip(A));


    }

}
