package PracticeInterviewBit.Math.Adhoc;

/**
 * @author njain
 */
public class DistributeInCircle {
    public static int solve(int A, int B, int C) {
        int position;

        int itemsMod = A%B;
        position = itemsMod; // if the distribution started from 1st person then this was the answer ie.. it A == B then next position = 0 and Ath item went to last person
        // As positions are here numbered from 1 not zero
        // But here it started from C

        position = position + (C-1); // (C-1) == offset from start which is 1 here

        if(position > B){
            position = position%B;
        }
        return position;
    }

    public static void main(String[] args) {
        System.out.println("solve(8,5,1) = " + solve(8, 5, 1));
    }
}
