
//import these 3 header files
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener {
    private BigBoardContainer game;
    private JButton play;
    private JComboBox options;
    private JButton startButton;
    private JPanel controlBoard;
    
    public Main() {
        super("Fred Probst and Stefan's Nested Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setSize(700, 700);
        controlBoard = new JPanel();
        play = new JButton("Play");
        options = new JComboBox<>(new String[] {"Two Player", "Random AI"});
        startButton = new JButton("Start");
        startButton.setBackground(Color.GREEN);
        startButton.setEnabled(false);
        options.setEnabled(false);
        options.setSelectedIndex(0);
        controlBoard.add(play);
        controlBoard.add(startButton);
        controlBoard.add(options);
        controlBoard.setMaximumSize(new Dimension(300,50));
        play.addActionListener(this);
        game = new BigBoardContainer(this, options, startButton);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(controlBoard);
        add(game);
        setVisible(true);
    }
    
    public static void main(String[] args) throws Exception {
        Main main = new Main();
    }
    /**
     * When the play button is pressed, the change panel method is called, which changes the
     * the panel from the title page to the actual gameboardContainer, which contains the
     * bigBoard.
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        game.changePanel(play,startButton);
    }


}

