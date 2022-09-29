package PracticeInterviewBit.Math.Combinatroics;

/**
 * @author njain
 */
public class CityTour {
    public static Long factorial(int num){
        long ans = 1L;
        for(int i = 2 ; i<= num ; i++){
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("factorial(7) = " + factorial(6));
    }
}
