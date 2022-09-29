package PracticeInterviewBit.Math.BasicConversions;

import java.util.Arrays;

/**
 * @author njain
 */
public class ExcelNumberToColumnTitle {
    public static String convertToTitle(int A) {
        char[] str = new char[10];
        int ctr = 0;
        while(A>0){
            if(A%26 == 0){
                //str[ctr] = 26;
                A = A-26;
                str[ctr] = 26 + 64;
            }else {
                str[ctr] = (char) ((A % 26) + 64);
            }
            A = A/26;
            ctr++;
        }
        System.out.println("str = " + Arrays.toString(str));
        StringBuilder strAns = new StringBuilder();

        for(int i = ctr-1 ; i>=0 ; i--){
            strAns.append(str[i]);
        }
        strAns.append("\n");

        return strAns.toString();
    }

    public static void main(String[] args) {
        System.out.println("convertToTitle(52) = " + convertToTitle(210615));

    }
}
