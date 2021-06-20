package GUI;
import Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.AbstractCollection.*;
import java.util.Stack;

public class GamePanel extends JPanel implements Util {
    int[][] gomokuArray = new int[LINE][LINE];
    StoneListener x = new StoneListener();
    Stack<Point> posStack = new Stack<Point>();
    //
    public GamePanel(){
        this.setBackground(new Color(150,139,100));
    }
    //
    public void gameInitialize(){
        posStack.clear();
        x.color = 1;
        x.matchPanel(this);
        this.addMouseListener(x);
    }
    //
    public void reset(){
        posStack.clear();
        this.gomokuArray = new int[LINE][LINE];
        x.color = 1;
        this.repaint();
    }
    //
    public void victory(int color){
        if(color == 1) {
            JOptionPane.showMessageDialog(this, "black win");
        }
        else{
            JOptionPane.showMessageDialog(this, "white win");
        }
       this.reset();
    }
    //
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < LINE; i++) {
            g.drawLine(X, Y + i * GAP, (LINE - 1) * GAP + X, Y + i * GAP);
            g.drawLine(X + i * GAP, Y, X + i * GAP, (LINE - 1) * GAP + Y);
        }

        for(int i=0;i<LINE;i++) {
            for(int j=0;j<LINE;j++) {
                if(gomokuArray[i][j] == 1) {
                    int xLine=GAP*i+48;
                    int yLine=GAP*j+48;
                    g.setColor(new Color(22,22,22));
                    g.fillOval(xLine - 20, yLine - 20, 25, 25);
                }

                else if(gomokuArray[i][j] == 2) {
                    int xLine=GAP*i+48;
                    int yLine=GAP*j+48;
                    g.setColor(new Color(225,225,225));
                    g.fillOval(xLine - 20, yLine - 20, 25, 25);
                }
            }
        }
    }

}
