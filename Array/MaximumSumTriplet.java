package PracticeInterviewBit.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author njain
 */
public class MaximumSumTriplet {
    public static int solve(ArrayList<Integer> A) {
        int ans = 0,tempans=0;
        int i;
        int lasthigh = A.size()-1;
//        System.out.println("A.size() = " + A.size());
        ArrayList<Integer> rightMax = new ArrayList<Integer>(A);
//        System.out.println("rightMax.size() = " + rightMax.size());
        rightMax.set((A.size()-1) , -1);

        for(i = A.size()-2; i>= 0 ; i--){
            // for any ith element find the largest element in right of it
            // it will be among 2 either the next number(when next number is largest) or rightMax of next number
            if(A.get(i)  < rightMax.get(i+1) || A.get(i) < A.get(i+1)){
                int val = rightMax.get(i+1) > A.get(i+1) ? rightMax.get(i+1) : A.get(i+1);
                rightMax.set(i , val);
            }else{
                rightMax.set(i,-1);
            }
        }
        System.out.println("A        = " + A);
        System.out.println("rightMax = " + rightMax);
        SortedSet<Integer> leftMax = new TreeSet<>();
        leftMax.add(A.get(0));

        for(i = 1 ; i < A.size()-1 ; i++){
            // left is 0->i And right max is present at rightMax[i]
            // find left max in 0->i using binary search
            if(rightMax.get(i) > -1){
                int maxleft = -1;
                for(int j = 0 ; j < i ; j++){
                    if(A.get(j) > maxleft && A.get(j) < A.get(i)){
                        maxleft = A.get(j);
                    }
                }

                int last = -1 , cur = A.get(0);
                Iterator<Integer> iter = leftMax.iterator();
                while (iter.hasNext()){
                    if(iter.next() > A.get(i) && A.get(i) > last){


                    }
                }

                leftMax.add(A.get(i));

                if(maxleft > -1) {
                    tempans = maxleft + A.get(i) + rightMax.get(i);
                    if (ans < tempans) {
                        ans = tempans;
//                        System.out.println("maxleft = " + maxleft);
//                        System.out.println("A.get(i) = " + A.get(i));
//                        System.out.println("rightMax.get(i) = " + rightMax.get(i));
                    }
                }
            }

        }

        if(tempans == 0){
            ans = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,7,4,3,5,2,1,5,0,4,8,3,2,1,0};

        ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());

        System.out.println("solve(A) = " + solve(A));
    }
}
