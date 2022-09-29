package PracticeInterviewBit.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author njain
 */
public class MaximumAreaOfTriangle {
    public static int solve(ArrayList<String> A) {

        int rows = A.size();
        int columns = A.get(0).length();
//        System.out.println("A = " + A);
//        System.out.println("rows = " + rows);
//        System.out.println("columns = " + columns);
        if(rows < 2 || columns < 2){
            return 0;
        }

        int[][] matrix = new int[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j<columns; j++){
                if(A.get(i).charAt(j) == 'r'){
                    matrix[i][j] = -1;
                }else if(A.get(i).charAt(j) == 'g'){
                    matrix[i][j] = 0;
                }else if(A.get(i).charAt(j) == 'b'){
                    matrix[i][j] = 1;
                }else{
                    matrix[i][j] = 200;
                }

            }
        }

//        for(int i=0; i<rows; i++){
//            System.out.println(Arrays.toString(matrix[i]));
//        }

        int[][] min = new int[columns][3];
        int[][] max = new int[columns][3];

        for(int j = 0 ; j<columns ; j++){
            min[j] = new int[]{-1, -1, -1};
            max[j] = new int[]{-1, -1, -1};

            for(int i = 0; i<rows; i++){
                if(matrix[i][j] == -1){
                    if(min[j][0] == -1 || min[j][0] > i){
                        min[j][0] = i;
                    }

                    if(max[j][0] == -1 || max[j][0] < i){
                        max[j][0] = i;
                    }
                }else if(matrix[i][j] == 0){
                    if(min[j][1] == -1 || min[j][1] > i){
                        min[j][1] = i;
                    }

                    if(max[j][1] == -1 || max[j][1] < i){
                        max[j][1] = i;
                    }
                }else if(matrix[i][j] == 1){
                    if(min[j][2] == -1 || min[j][2] > i){
                        min[j][2] = i;
                    }

                    if(max[j][2] == -1 || max[j][2] < i){
                        max[j][2] = i;
                    }
                }
            }
        }

//        System.out.println("Arrays.toString(minr) = " + Arrays.toString(min[0]));
//        System.out.println("Arrays.toString(ming) = " + Arrays.toString(min[1]));
//        System.out.println("Arrays.toString(minb) = " + Arrays.toString(min[2]));

        int[] left = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] right = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int i = 0; i<columns; i++){
            if(min[i][0] != -1) {
                left[0] = Math.min(left[0], i);
                right[0] = Math.max(i,right[0]);
            }
            if(min[i][1] != -1) {
                left[1] = Math.min(left[1], i);
                right[1] = Math.max(i,right[1]);
            }
            if(min[i][2] != -1) {
                left[2] = Math.min(left[2], i);
                right[2] = Math.max(i,right[2]);
            }
        }
//        System.out.println("leftr = " + left[0]);
//        System.out.println("rightr = " + right[0]);
//
//        System.out.println("leftg = " + left[1]);
//        System.out.println("rightg = " + right[1]);
//
//        System.out.println("leftb = " + left[2]);
//        System.out.println("rightb = " + right[2]);

        int ans = 0, curans = 0;
        for(int currentColumn = 0; currentColumn<columns; currentColumn++){
            for(int color1 = -1; color1 < 2; color1++){
                for(int color2 = -1; color2 < 2; color2++){
                    if(color1 == color2){
                        continue;
                    }
                    int color3 = - color1 - color2;
                    //find base of color1(in min) and color2(in max) and right side area and left side are with color3









                }

            }

        }


        return -1;
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("rrrrr", "rrrrg", "rrrrr", "bbbbb"));
        System.out.println("solve(A) = " + solve(A));

    }
}
