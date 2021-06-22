package Game;

// this class checks whether the win condition has met
public abstract class GameMode {
    int x;
    int y;
    int [][] arr;
    // with each new stone placed, a new gamemode is constructed to check if the win condition has met
    public GameMode(int x, int y, int[][] arr){
        this.x = x;
        this.y = y;
        this.arr = arr;
    }
    // Gomoku mode: checks if the game has been won
    // **Go mode: checks if there needs to be a modification (stones that lost breathes)
    public abstract boolean modify(int color);
    // **would be used by the Go mode to return a modified 2-D array
    public abstract int[][] arrReturn();
}
