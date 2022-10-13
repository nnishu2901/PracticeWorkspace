package PracticeInterviewBit.Math.DigitOP;

/**
 * @author njain
 */
public class IsPaliandrome {
    public static int isPalindrome(int A) {
        boolean isPalindrome = false;
        int revA = 0;
        int tempA = A;
        while(tempA > 0){
            revA = revA*10 + tempA%10;
            tempA = tempA/10;
        }
//        System.out.println("revA = " + revA);
//        System.out.println("A = " + A);

        if(revA == A){
            isPalindrome = true;
        }

        return isPalindrome ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println("isPalindrome(43676) = " + isPalindrome(43676));
        System.out.println("isPalindrome(76567) = " + isPalindrome(76567));
        System.out.println("isPalindrome(0) = " + isPalindrome(0));

    }
}
