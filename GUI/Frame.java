package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

//
public class Frame<FrameListener> extends JFrame implements Util {
    public GamePanel board = new GamePanel();
    public Frame() {
        this.setTitle("Gomoku app");
        this.setSize(620, 690);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //
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
        //
        String[] choices = {"Gomoku","Go"};
        JComboBox mode = new JComboBox(choices);
        mode.setPreferredSize(new Dimension(120, 40));
        panel.add(mode);
        //
        this.add(board, BorderLayout.CENTER);
        this.setVisible(true);
        //
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = 0;
                if (mode.getSelectedItem().equals("Gomoku")){
                    board.reset();
                    board.gameInitialize(1);
                }
                else{
                    board.reset();
                    board.gameInitialize(2);
                }
            }
        });
        //
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                catch(EmptyStackException ev){
                }
            }
        });
        //
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.reset();
            }
        });
    }

}
