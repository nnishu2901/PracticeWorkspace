package PracticeInterviewBit.Array.Arrangement;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author njain
 */
public class SortArrayWithSquares {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> squaresArray = new ArrayList<>();
        int mid;
        int left = 0 , right = A.size();
        mid = left + (right-left)/2;
        int leastNumIndex = -1;
        if(A.get(0) >= 0){
            leastNumIndex = 0;
        }else if(A.get(A.size()-1) <= 0){
            leastNumIndex = A.size()-1;
        }else{
            while(left <= right){
                if(A.get(mid) >= 0 && A.get(mid-1) < 0){
                    leastNumIndex = mid;
                    break;
                }else if(A.get(mid) < 0){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
                mid = left + (right-left)/2;
            }
        }
//        System.out.println("A.toString() = " + A.toString());
//        System.out.println("leastNumIndex = " + leastNumIndex);
        int negSideCurrent = leastNumIndex -1;
        int posSideCurrent = leastNumIndex;
        while(negSideCurrent >= 0 && posSideCurrent <= A.size()-1){
            int val = 0;
//            System.out.println("A.get(posSideCurrent) = " + A.get(posSideCurrent));
//            System.out.println("A.get(negSideCurrent) = " + A.get(negSideCurrent));
            if(A.get(posSideCurrent) < -A.get(negSideCurrent)){
                val = A.get(posSideCurrent) * A.get(posSideCurrent);
//                System.out.println("Considering A.get(posSideCurrent) = " + A.get(posSideCurrent));
                posSideCurrent++;
            }else{
                val = A.get(negSideCurrent) * A.get(negSideCurrent);
//                System.out.println("Considering A.get(negSideCurrent) = " + A.get(negSideCurrent));
                negSideCurrent--;
            }
            squaresArray.add(val);
        }

        while(negSideCurrent >= 0){
            int val = A.get(negSideCurrent) * A.get(negSideCurrent);
//            System.out.println("Considering A.get(negSideCurrent) = " + A.get(negSideCurrent));
            negSideCurrent--;
            squaresArray.add(val);
        }

        while (posSideCurrent <= A.size()-1){
//            System.out.println("Considering A.get(posSideCurrent) = " + A.get(posSideCurrent));
            int val = A.get(posSideCurrent) * A.get(posSideCurrent);
            posSideCurrent++;
            squaresArray.add(val);
        }


        return squaresArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-5, -4, -2, 0, 1));
        System.out.println("solve(A) = " + solve(A));

    }

}
