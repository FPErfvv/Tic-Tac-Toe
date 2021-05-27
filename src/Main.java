
//import these 3 header files
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener {
    BigBoardContainer game;
    JButton play;
    JButton start;
    JPanel controlBoard;

    public Main() {
        super("Fred Probst and Stefan's Nested Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setSize(700, 700);
        controlBoard = new JPanel();
        play = new JButton("Play");
        start = new JButton("Start");
        start.setEnabled(false);
        controlBoard.add(play);
        controlBoard.add(start);
        controlBoard.setMaximumSize(new Dimension(200,50));
        play.addActionListener(this);
        play.setBackground(Color.GREEN);
        game = new BigBoardContainer(this, start);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(controlBoard);
        add(game);
        setVisible(true);
    }
    
    public static void main(String[] args) throws Exception {
        Main main = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        game.changePanel(play,start);
    }


}

