package GUI;
import Game.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StoneListener implements MouseListener, Util{
    GamePanel gp;
    public void matchPanel(GamePanel x){gp = x;}
    int color = 0;
    GameMode game = null;
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()/20 * 20;
        int y = e.getY()/20 * 20;
        int arrX=(x-20)/30;
        int arrY=(y-20)/30;
        if (gp.gomokuArray[arrX][arrY] == 0) {
            Point pos = new Point(arrX,arrY);
            gp.posStack.push(pos);
            gp.gomokuArray[arrX][arrY] = color;
            gp.repaint();
            //
            game = new GomokuMode(arrX, arrY, gp.gomokuArray);
            if (game.modify(color)){
                    gp.victory(color);
                    return;
            }
            //
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
