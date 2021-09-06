package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

// the main Frame of the application
public class Frame<FrameListener> extends JFrame implements Util {
    GamePanel board = new GamePanel();
    // constructs the frame
    public Frame() {
        this.setTitle("Gomoku app");
        this.setSize(620, 690);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        // panel for the buttons
        JPanel panel = new JPanel();
        panel.setBackground(new Color(150, 139, 100));
        this.add(panel, BorderLayout.NORTH);
        JButton b1 = new JButton("Start");
        JButton b2 = new JButton("Back");
        JButton b3 = new JButton("Reset");
        b1.setPreferredSize(new Dimension(90, 40));
        b2.setPreferredSize(new Dimension(90, 40));
        b3.setPreferredSize(new Dimension(90, 40));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        // combo box to choose game mode
        String[] choices = {"Gomoku"};
        JComboBox mode = new JComboBox(choices);
        mode.setPreferredSize(new Dimension(120, 40));
        panel.add(mode);
        // add the components to the frame
        this.add(board, BorderLayout.CENTER);
        this.setVisible(true);
        // add actionListeners to enable start
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // the option is used to distinguish go (1) and gomoku (2) ***Have Not Implemented GO Mode
                int option = 0;
                if (mode.getSelectedItem().equals("Gomoku")){
                    board.gameInitialize(1);
                }
                else{
                    board.gameInitialize(2);
                }
            }
        });
        // add actionListeners to enable back
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // uses a stack to achieve 'back'
                // catch exceptions in which the user pops an empty stack
                try {
                    Point pos = board.posStack.pop();
                    if (board.gomokuArray[pos.x][pos.y] == 1){
                        board.x.color = 1;
                    }
                    else{
                        board.x.color = 2;
                    }
                    board.gomokuArray[pos.x][pos.y] = 0;
                    board.repaint();
                }
                catch(EmptyStackException ev) {
                }
            }
        });
        // add action Listener to enable reset
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.reset();
            }
        });
    }

}
