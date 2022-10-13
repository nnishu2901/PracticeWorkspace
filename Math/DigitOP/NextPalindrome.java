package PracticeInterviewBit.Math.DigitOP;

/**
 * @author njain
 */
public class NextPalindrome {

    //A will always be positive
    public static int reverse(int A) {
        int ans = 0;
        int tempA = A;
        int lastans;
        while(tempA > 0){
            lastans = ans;
            ans = ans * 10 + tempA%10;
            if(ans < 0 || ans/10 != lastans){
                ans = 0;
                break;
            }
            tempA = tempA/10;
        }
        return ans;
    }

    // A will not have any zero at starting
    public static String solve(String A) {
        String ansStr = "";
        int num = Integer.parseInt(A);
        boolean all9 = true;

        int len = A.length();

        for(int i = 0 ; i<len ; i++){
            if(A.charAt(i) != '9'){
                all9 = false;
                break;
            }
        }

        if(all9){
            num = num+2;
        }else if(len == 1){
            num = num+1;
        }else{
            int mid = len/2;
            int rightNum = 0;
            int leftNum = Integer.parseInt(A.substring(0,mid));
            int midNum = -1;

            boolean isRightGreaterThanLeft = false;
            int left = mid-1;
            int right = (len%2 == 0) ? mid : mid+1;
            int revRNum = reverse( Integer.parseInt(A.substring(right, len)));
            if(revRNum == leftNum){
                isRightGreaterThanLeft = true;
            }else {
                for (; left >= 0 && right < len; ) {
                    if (A.charAt(left) < A.charAt(right)) {
                        isRightGreaterThanLeft = true;
                        break;
                    }
                    left--;
                    right++;
                }
            }

            System.out.println("== isRightGreaterThanLeft === = " + isRightGreaterThanLeft);

            // keep middle same if right is less than left else increase middle by 1 and make right = left
            if(len%2 == 0){ // even length like 2305 ans should be 2332 but if num 2332 then ans 2442
                while(mid < len) {
                    rightNum = rightNum * 10 + (A.charAt(mid) - '0');
                    mid++;
                }
            }else{ // 23456 -> 23532 but 23430 -> 23432  but 23954 -> 24042
                midNum = A.charAt(mid) - '0';
                mid = mid +1;
                while(mid < len) {
                    rightNum = rightNum * 10 + (A.charAt(mid) - '0');
                    mid++;
                }
            }

            if(isRightGreaterThanLeft){
                if(midNum != -1){
                    midNum++;
                    if(midNum > 9){
                        midNum = midNum%10;
                        leftNum++;
                    }
                }else{
                    leftNum++;
                }
            }
            ansStr = "";
            ansStr += String.valueOf(leftNum);
            if(midNum != -1){
                ansStr += String.valueOf(midNum);
            }

            ansStr += String.valueOf(reverse(leftNum));

            return ansStr;
        }

        ansStr = String.valueOf(num);
        return ansStr;
    }

    public static void main(String[] args) {
//        System.out.println("solve(\"2\") = " + solve("2"));
//        System.out.println("solve(\"0\") = " + solve("0"));
//        System.out.println("solve(\"9\") = " + solve("9"));
        System.out.println("solve(\"99\") = " + solve("4232"));
        System.out.println("solve(\"34\") = " + solve("34567"));
        System.out.println("solve(\"171152\") = " + solve("171152"));

    }
}
