package GUI;
import Game.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// mouselistener used to detect each mouseclick and shows the stones on the board
public class StoneListener implements MouseListener, Util{
    GamePanel gp;
    // connects the gameboard with the current listener
    // needed to repaint the board after every click
    public void matchPanel(GamePanel x){gp = x;}
    int color = 0;
    // object used to check if the win condition has met
    GameMode game = null;
    @Override
    // enable actions performed by mouse clicks
    public void mouseClicked(MouseEvent e) {
        // calculates the position on the array from the coordinates of each click
        int x = e.getX()/20 * 20;
        int y = e.getY()/20 * 20;
        int arrX=(x-20)/30;
        int arrY=(y-20)/30;
        // clicks are only enabled in empty array positions
        if (gp.gomokuArray[arrX][arrY] == 0) {
            // creates a new point object and push into the stack
            Point pos = new Point(arrX,arrY);
            gp.posStack.push(pos);
            // sets the array position to black or white, then repaint the board
            gp.gomokuArray[arrX][arrY] = color;
            gp.repaint();
            // check if the win condition has met ** only the gomoku mode has been implemented for now
            game = new GomokuMode(arrX, arrY, gp.gomokuArray);
            if (game.modify(color)){
                    gp.victory(color);
                    return;
            }
            // switch the color
            if (color == 1){
                color = 2;
            }
            else{
                color = 1;
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
