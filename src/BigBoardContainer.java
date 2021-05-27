import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class BigBoardContainer extends JPanel implements ActionListener {
    CardLayout layout;
    Timer t;
    JFrame f;
    BigBoard gameBoard;
    public BigBoardContainer(JFrame f, JButton startButton) {
        this.f = f;
        layout = new CardLayout();
        t = new Timer(100, this);
        this.setLayout(layout);
        setPreferredSize(new Dimension(f.getHeight()-78,f.getHeight()-78));
        gameBoard = new BigBoard(startButton);
        gameBoard.setFocusable(true);
        TitlePage instructions = new TitlePage();

        add(instructions);
        add(gameBoard);
        startButton.addActionListener(this);
        setBackground(Color.WHITE);
        setVisible(true);
        t.start();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() instanceof JButton) {
            System.out.println("Game has Started!");
            gameBoard.startGame();
            JButton b = (JButton) arg0.getSource();
            b.setText("Stop");

        }
        setMaximumSize(new Dimension(f.getHeight()-30,f.getHeight()-70));
        layout.previous(this);
        layout.next(this);
    }

    public void changePanel(JButton b,JButton s) {
        if (b.getText().equals("Back")) {
            layout.previous(this);
            b.setText("Play");
            s.setEnabled(false);
        } else {
            layout.next(this);
            b.setText("Back");
            s.setEnabled(true);
        }
    }
}
