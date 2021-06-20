/*
package Game;

public class GoMode extends GameMode{
    public GoMode(int x, int y, int[][] arr){
        super(x,y,arr);
    }

    private boolean noBreathe(int x , int y, int color){
        int opposite = 0;
        if (color == 1){
            opposite = 2;
        }
        else{
            opposite = 1;
        }
        //
        int left;
        if (x - 1 < 0){
            left = opposite;
        }
        else{
            left = arr[x - 1][y];
        }
        //
        int right;
        if (x + 1 > 18){
            right = opposite;
        }
        else{
            right = arr[x + 1][y];
        }
        //
        int up;
        if (y + 1 > 18){
            up = opposite;
        }
        else{
            up = arr[x][y + 1];
        }
        //
        int down;
        if (y - 1 < 0){
            down = opposite;
        }
        else{
            down = arr[x][y - 1];
        }
        //
        if (left == opposite && right == opposite && up == opposite && down == opposite){
            return true;
        }
        return false;
    }

    public int[][] arrReturn(){
        return arr;
    }

    @Override
    public boolean modify(int color) {
        //left of current position
        try {
            if (noBreathe(x - 1, y, arr[x - 1][y])) {
                arr[x + 1][y] = 0;
            }
            //right of current postion
            if (noBreathe(x + 1, y, arr[x + 1][y])) {
                arr[x + 1][y] = 0;
            }
            //below current position
            if (noBreathe(x, y - 1, arr[x][y - 1])) {
                arr[x][y - 1] = 0;
            }
            //above current position
            if (noBreathe(x, y + 1, arr[x][y + 1])) {
                arr[x][y + 1] = 0;
            }
        }
        catch(IndexOutOfBoundsException e){}
        //self check
        if (noBreathe(x,y,arr[x][y])){
            arr[x][y] = 0;
            return true;
        }
        return false;
    }
}
*/