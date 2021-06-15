import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class BigBoardContainer extends JPanel implements ActionListener {
    private CardLayout layout;
    private Timer t;
    private JFrame f;
    private BigBoard gameBoard;
    private JComboBox comboBox;
    private JPanel superBigIconPanel;
    private boolean gameFinished;
    private JButton startButton;
    private int frameWidth;
    private int frameHeight;

    final int RESIZE_TIME_BUFFER = 3;
    int resizeIterator; 

    public BigBoardContainer(JFrame f, JComboBox cBox, JButton sButton) {
        this.f = f;
        layout = new CardLayout();
        t = new Timer(300, this);
        this.setLayout(layout);
        setPreferredSize(new Dimension(f.getHeight()-78,f.getHeight()-78));
        frameWidth = f.getWidth();
        frameHeight = f.getHeight();
        resizeIterator = 16;
        gameBoard = new BigBoard(this);
        gameBoard.setFocusable(true);
        TitlePage instructions = new TitlePage(f);
        comboBox = cBox;
        add(instructions);
        add(gameBoard);
        sButton.addActionListener(this);
        startButton = sButton;
        setBackground(Color.WHITE);
        setVisible(true);
        t.start();
        gameFinished = false;
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
                gameBoard.stopGame();
            }
        }
        if (resizeIterator < RESIZE_TIME_BUFFER) {
            resizeIterator++;
        }
        if (frameWidth != f.getWidth() || frameHeight != f.getHeight()) {
            setMaximumSize(new Dimension(f.getHeight()-30,f.getHeight()-70));
            layout.previous(this);
            layout.next(this);
            gameBoard.resizeBigIcons(); // TODO: check if it actually resizes
            frameWidth = f.getWidth();
            frameHeight = f.getHeight();
            resizeIterator = 0;
        }
    }

    public void changePanel(JButton b,JButton s) {
        if (b.getText().equals("Back")) {
            layout.next(this);
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

    public void swapToWin(int winner) {
        remove(gameBoard);
        superBigIconPanel = new JPanel();
        ImageIcon bigImage = new ImageIcon("src/images/largeX.png");
        // depending on the winnner, a bigIcon is chosen to display
        if (winner == 1) {
            bigImage = new ImageIcon("src/images/largeX.png");
        } else if (winner == 2) {
            bigImage = new ImageIcon("src/images/largeO.png");
        } else if (winner == -1) {
            bigImage = new ImageIcon("src/images/tie.png");
        } else {
            // TODO: code for the tie goes here
            return;
        }

        Image newImage = bigImage.getImage().getScaledInstance(this.getHeight()-30, this.getHeight()-30, Image.SCALE_SMOOTH);
        JLabel superBigIconLabel = new JLabel(new ImageIcon(newImage));
        superBigIconPanel.add(superBigIconLabel);
        add(superBigIconPanel);
        layout.next(this);
        gameFinished = true;
        startButton.setText("Start");
        startButton.setBackground(Color.GREEN);
    }

    public void reset() {
        if (gameFinished) {
            remove(superBigIconPanel);
            add(gameBoard);
            layout.next(this);
        }
    }
}
