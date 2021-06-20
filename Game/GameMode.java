package Game;

public abstract class GameMode {
    int x;
    int y;
    int [][] arr;

    public GameMode(int x, int y, int[][] arr){
        this.x = x;
        this.y = y;
        this.arr = arr;
    }

    public abstract boolean modify(int color);

    public abstract int[][] arrReturn();
}
