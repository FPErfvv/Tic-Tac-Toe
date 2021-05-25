import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component; //import these 3 header files
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame implements ActionListener {
    BigBoardContainer game;
    JButton play;
    public Main() {
        super("Fred Probst and Stefan's Nested Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setSize(700,700);
        play = new JButton("Play");
        play.addActionListener(this);
        play.setBackground(Color.GREEN);
        game = new BigBoardContainer(this);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(play);
        add(game);
        setVisible(true);
    }
    
    public static void main(String[] args) throws Exception {
        Main eConfigGame = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        game.changePanel(play);
    }


}

