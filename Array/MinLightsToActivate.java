package PracticeInterviewBit.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author njain
 */
public class MinLightsToActivate {
    public static int solve(ArrayList<Integer> A, int B) {
        int ans = 0;
        int window = B-1;
        int nums[] = new int[A.size()];

        for(int i = 0 ; i < A.size() ;i++ ){
            nums[i] = -1;
        }

        for(int i = 0 ; i < A.size() ;i++ ){

            if(A.get(i) == 1){
                System.out.println("i-window = " + (i - window));
                System.out.println("i+window = " + (i + window));

                for(int j = Math.max(i-window,0) ; j < Math.min(A.size(), i+window+1); j++){
                    if(nums[j] == -1){
                        nums[j] = j;
                    }
                }
            }

        }

        System.out.println("A = " + A);
        System.out.println("nums.toString() = " + Arrays.toString(nums));

        for (int integer : nums) {
            if (integer == -1) {
                return -1;
            }
        }
        ans= 0;
        for(int i=0; i<A.size()-1 ; i++){
            if(nums[i] != nums[i+1]){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1};

        ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());

        System.out.println("A = " + A);
        System.out.println("solve(A,2) = " + solve(A, 3));

    }

}
