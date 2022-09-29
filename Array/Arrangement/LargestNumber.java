package PracticeInterviewBit.Array.Arrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author njain
 */
public class LargestNumber {
    public static String largestNumber(final List<Integer> A) {
        StringBuilder ans = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>(A);

//        arrayList.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//
//                return 0;
//            }
//        });

        for(int i = 0 ; i<A.size()-1; i++){
            for(int j = i+1; j<A.size() ; j++){
                String ij = arrayList.get(i).toString() + arrayList.get(j).toString();
                String ji = arrayList.get(j).toString() + arrayList.get(i).toString();
                long ijint = Long.parseLong(ij);
                long jiint = Long.parseLong(ji);
                if(ijint < jiint){ // i greater than j then only swap
                    int temp = arrayList.get(i);
                    arrayList.set(i,arrayList.get(j));
                    arrayList.set(j,temp);
                }
            }
        }
        for (int i = 0 ; i<A.size(); i++){
            ans.append(arrayList.get(i).toString());
        }

        int end = -1;
        for(int i = 0 ; i < ans.length() ; i++){
            if(ans.charAt(i) == '0'){
                end++;
            }else{
                break;
            }
        }
        String finalAns = ans.toString();
        if(end > -1){
            if(end == ans.length()-1){
                finalAns = "0";
            }else
                finalAns = ans.substring(end+1,ans.length());
        }

        return finalAns;
    }


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(97750768, 60243460, 63811365, 48584, 13023771, 28241420, 40714170, 4918459, 93732397, 42958767));
        System.out.println("largestNumber(A) = " + largestNumber(A));
    }
}
