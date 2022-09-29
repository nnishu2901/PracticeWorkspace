package PracticeInterviewBit.Math.Adhoc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author njain
 */
public class PairwiseHammingDistanceSum {
    public static int calcHammingDistance(int a, int b){
        int dist = 0;
        int cur;
        while(a > 0 || b > 0){
            dist += (b%2 == a%2) ? 0 : 1;
            a = a/2;
            b = b/2;
        }
        return dist;
    }

    public static int longHammingDistance(final List<Integer> A) { // brute force
        int ans =0;

        for(int i = 0; i<A.size() ; i++){
            for(int j = i+1 ; j<A.size(); j++){
                ans += calcHammingDistance(A.get(i),A.get(j));
            }
        }
        return ans*2;
    }

    public static int hammingDistance(final List<Integer> A) { // optimal
        long ans = 0;
        ArrayList<Integer> copyArr = new ArrayList<>(A);

        int count0;
        int count1;
        boolean anyLeft;
        while(true){
            anyLeft = false;
            count0 = 0;
            count1 = 0;
            for(int i = 0 ; i< A.size(); i++){
                if(copyArr.get(i)%2 == 0){
                    count0++;
                }else{
                    count1++;
                }
                copyArr.set(i,copyArr.get(i)/2);
                if(copyArr.get(i)>0 && !anyLeft){
                    anyLeft = true;
                }
            }
            // calculating max hamming distance
            count0 = count0 % 1000000007;
            count1 = count1 % 1000000007;
            ans = (ans + ((long) count0 * count1)%1000000007)% 1000000007;
            if(!anyLeft){ // breaking while loop
                break;
            }
        }


        return (int) ((ans*2)% 1000000007);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(2,4,8,6));
        System.out.println("hammingDistance(A) = " + hammingDistance(A));

    }
}
