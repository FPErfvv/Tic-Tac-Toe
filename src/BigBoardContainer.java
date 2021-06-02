import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
    JComboBox comboBox;

    public BigBoardContainer(JFrame f, JComboBox cBox, JButton sButton) {
        this.f = f;
        layout = new CardLayout();
        t = new Timer(100, this);
        this.setLayout(layout);
        setPreferredSize(new Dimension(f.getHeight()-78,f.getHeight()-78));
        gameBoard = new BigBoard();
        gameBoard.setFocusable(true);
        TitlePage instructions = new TitlePage();
        comboBox = cBox;
        add(instructions);
        add(gameBoard);
        sButton.addActionListener(this);
        setBackground(Color.WHITE);
        setVisible(true);
        t.start();
    }
    /**
     * This is the code that is run when the start/stop button is pressed.
     * It also periodically resizes the size of the BigBoardContainer to 
     * match up with the size of the JFrame.
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() instanceof JButton) { // code run when start button is pressed 
            JButton b = (JButton) arg0.getSource();
            /**
             * if the button has not been pressed yet and reads "start" it 
             *      >starts the game
             *      >changes the text to stop
             *      >changes the color to red
             * if the button has been pressed and reads "stop" it
             *      >changes the text to start
             *      >sets the color to green
             *      >TODO: add end method that is ends the game when this button is pressed
             */
            if (b.getText().equals("Start")) {
                gameBoard.startGame(comboBox.getSelectedItem());
                b.setText("Stop");
                b.setBackground(Color.RED);
            } else {
                b.setText("Start");
                b.setBackground(Color.GREEN);
            }
            System.out.println(comboBox.getSelectedItem());
            


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
            comboBox.setEnabled(false);
        } else {
            layout.next(this);
            b.setText("Back");
            s.setEnabled(true);
            comboBox.setEnabled(true);
        }
    }
}
