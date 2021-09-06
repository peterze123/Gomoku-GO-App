package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

// the panel in which the board itself resides
public class GamePanel extends JPanel implements Util {
    // a 2-D array that tracks every stone in the board
    public int[][] gomokuArray = new int[LINE][LINE];
    // the mouselistener tracking clicks
    StoneListener x = new StoneListener();
    // stack to keep track of the coordinates of every stone, used for the 'back' functions
    Stack<Point> posStack = new Stack<Point>();
    public int mode = 0;
    // constructs a default Jpanel
    public GamePanel(){
        this.setBackground(new Color(150,139,100));
    }
    // method to initialize a new GamePanel
    public void gameInitialize(int mode){
        posStack.clear();
        this.gomokuArray = new int[LINE][LINE];
        this.repaint();
        x.color = 1;
        x.matchPanel(this);
        // adds the StoneListener to the panel
        this.addMouseListener(x);
        this.mode = mode;
    }
    // method to reset the panel
    public void reset(){
        posStack.clear();
        this.gomokuArray = new int[LINE][LINE];
        this.repaint();
        x.color = 1;
    }
    // method when a victory is detected
    public void victory(int color){
        // sends the message depending on the color of the last move
        if(color == 1) {
            JOptionPane.showMessageDialog(this, "black win");
        }
        else{
            JOptionPane.showMessageDialog(this, "white win");
        }
        this.removeMouseListener(x);
        this.reset();
    }
    // method used when a stone could not be placed in a position ** only used in the go mode
    public void warning(){
        JOptionPane.showMessageDialog(this, "Could not be placed here");
    }
    // the paint method
    @Override
    public void paint(Graphics g) {
        // paints the board it self 19 x 19
        super.paint(g);
        for (int i = 0; i < LINE; i++) {
            g.drawLine(X, Y + i * GAP, (LINE - 1) * GAP + X, Y + i * GAP);
            g.drawLine(X + i * GAP, Y, X + i * GAP, (LINE - 1) * GAP + Y);
        }
        // paints the stones
        for(int i = 0; i < LINE; i++) {
            for(int j = 0; j < LINE; j++) {
                // 1 representing black
                if(gomokuArray[i][j] == 1) {
                    int xLine = GAP * i + 48;
                    int yLine = GAP * j + 48;
                    g.setColor(new Color(22,22,22));
                    g.fillOval(xLine - 20, yLine - 20, 25, 25);
                }
                // 2 representing white
                else if(gomokuArray[i][j] == 2) {
                    int xLine = GAP * i + 48;
                    int yLine = GAP * j + 48;
                    g.setColor(new Color(225,225,225));
                    g.fillOval(xLine - 20, yLine - 20, 25, 25);
                }
            }
        }
    }

}
