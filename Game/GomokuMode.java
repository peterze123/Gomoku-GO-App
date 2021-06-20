package Game;

import GUI.*;

import javax.sound.sampled.Line;

public class GomokuMode implements Util{
    int x = 0;
    int y = 0;
    int [][] arr = null;

    public GomokuMode(int x, int y, int[][] arr){
        this.x = x;
        this.y = y;
        this.arr = arr;
    }

    public boolean win(int color){
        System.out.println(x + ' ' + y);
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
                continue;
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
                continue;
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
                continue;
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
                continue;
            }
        }
        return false;
    }

}
