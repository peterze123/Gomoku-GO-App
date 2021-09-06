package Game;

import GUI.*;
// extends GameMode, checks if the new stone placed has won the game (Gomoku)
public class GomokuMode extends winChecker implements Util{
    public GomokuMode(int x, int y, int[][] arr){
        super(x,y,arr);
    }
    // checks every possible win conditions of the new stone placed
    @Override
    public boolean modify(int color){
        int cons = 0;
        //five consecutive horizontally
        for(int i = 0; i < x + 5; i++){
            try {
                if (arr[i][y] == color) {
                    cons++;
                } else {
                    cons = 0;
                }
                if (cons == 5) {
                    return true;
                }
            }
            catch(IndexOutOfBoundsException e){
            }
        }
        // five consecutive vertically
        cons = 0;
        for(int i = 0; i < y + 5; i++){
            try {
                if (arr[x][i] == color) {
                    cons++;
                } else {
                    cons = 0;
                }
                if (cons == 5) {
                    return true;
                }
            }
            catch(IndexOutOfBoundsException e){
            }
        }
        // five consecutive diagonal
        cons = 0;
        for(int i = 0; i < 9; i++){
            try {
                if (arr[x + (i - 4)][y + (i - 4)] == color) {
                    cons++;
                }
                else {
                    cons = 0;
                }
                if (cons == 5) {
                    return true;
                }
            }
            catch(IndexOutOfBoundsException e){
            }
        }
        // five consecutive alt-diagonal
        cons = 0;
        for(int i = 0; i < 9; i++){
            try {
                if (arr[x + (i - 4)][y - (i - 4)] == color) {
                    cons++;
                }
                else {
                    cons = 0;
                }
                if (cons == 5) {
                    return true;
                }
            }
            catch(IndexOutOfBoundsException e){
            }
        }
        return false;
    }
    // not used for gomoku mode
    @Override
    public int[][] arrReturn() {
        return null;
    }

}
