package PracticeInterviewBit.Math.Adhoc;

/**
 * @author njain
 */
public class StepByStep {
    public static int solve(int A) {
        // main easy part is we dont have to find the exact positions just print the number of steps
//        ArrayList<Integer> positionsList = new ArrayList<>();

        if(A < 0){
            A = A * -1;
        }
        int countStep = -1, cur = 0;
        for(int i = 0; i<=A+2; i++){

            cur += i;
            countStep++;
            if(cur >= A){
                break;
            }
//            positionsList.add(cur);
//            System.out.println("cur on count = " + cur + " " + countStep );
        }


        if(cur > A){
            while(true){
                if((cur-A)%2 != 0){
                    countStep++;
                    cur += countStep;
//                    System.out.println("cur on count = " + cur + " " + countStep );
                }else{
                    break;
                }
            }
        }

        return countStep;
    }

    public static void main(String[] args) {
        System.out.println("solve(0) = " + solve(0));
    }
}
