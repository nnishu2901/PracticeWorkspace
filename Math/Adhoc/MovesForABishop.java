package PracticeInterviewBit.Math.Adhoc;

/**
 * @author njain
 */
public class MovesForABishop {
    public static int solve(int A, int B) {
        int moves = 0;
        // bishop moves diagonally
        // 1<=A,B<=8 8x8 chess board
        //column v
        //row > 11,12,13,14,15,16,17,18
        //      21,22,23,24,25,26,27,28
        //      31,32,33,34,35,36,37,38
        //      41,42,43,44,45,46,47,48
        //      51,52,53,54,55,56,57,58
        //      61,62,63,64,65,66,67,68
        //      71,72,73,74,75,76,77,78
        //      81,82,83,84,85,86,87,88

        // covering down rows first
        int column = B;
        int row = A;
        int dist = 1;
        boolean changePossible = false;
        while(true){
            // adding +dist in both ie.. down right
            if(row+dist <= 8 && column+dist <=8){
                moves++;
//                System.out.println("(row+dist) = " + (row + dist));
//                System.out.println("(column+dist) = " + (column+dist));
                if(!changePossible){
                    changePossible = true;
                }
            }
            //down left
            if(row+dist <= 8 && column-dist > 0){
                moves++;
//                System.out.println("(row+dist) = " + (row + dist));
//                System.out.println("(column-dist) = " + (column - dist));
                if(!changePossible){
                    changePossible = true;
                }
            }
            //up left
            if(row-dist > 0 && column-dist > 0){
                moves++;
//                System.out.println("(row-dist) = " + (row-dist));
//                System.out.println("(column-dist) = " + (column-dist));
                if(!changePossible){
                    changePossible = true;
                }
            }
            //up right
            if(row-dist > 0 && column+dist <=8){
                moves++;
//                System.out.println("(row-dist) = " + (row-dist));
//                System.out.println("(column+dist) = " + (column+dist));
                if(!changePossible){
                    changePossible = true;
                }
            }

            if(changePossible){
                dist++;
                changePossible = false;
            }else{
                break;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        System.out.println("solve(4,4) = " + solve(4, 4));

    }
}
