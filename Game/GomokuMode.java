package Game;

import GUI.*;

import javax.sound.sampled.Line;

public class GomokuMode extends GameMode implements Util{

    public GomokuMode(int x, int y, int[][] arr){
        super(x,y,arr);
    }

    @Override
    public boolean modify(int color){
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

    @Override
    public int[][] arrReturn() {
        return null;
    }

}
