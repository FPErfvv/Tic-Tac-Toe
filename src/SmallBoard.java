import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

public class SmallBoard extends JPanel implements ActionListener {
    Point index;
    int[][] board;
    JButton[][] buttons;
    boolean isFilled;
    boolean isActive;
    GridLayout grid;

    JButton one;
    JButton two;
    JButton three;
    JButton four; 
    JButton five;
    JButton six;
    JButton seven;
    JButton eight;
    JButton nine;

    ImageIcon x;
    ImageIcon o;

    public SmallBoard(Point i) {
        x = new ImageIcon("src/images/x.png");
        o = new ImageIcon("src/images/o.png");

        index = i;
        board = new int[][] {{0,0,0},
                            {0,0,0},
                            {0,0,0}};
        isFilled = false;
        isActive = true;
        one = new JButton();
        two = new JButton();
        three = new JButton();
        four = new JButton(); 
        five = new JButton();
        six = new JButton();
        seven = new JButton();
        eight = new JButton();
        nine = new JButton();

        buttons = new JButton[3][3];
        buttons[0][0] = one;
        buttons[0][1] = two;
        buttons[0][2] = three;
        buttons[1][0] = four;
        buttons[1][1] = five;
        buttons[1][2] = six;
        buttons[2][0] = seven;
        buttons[2][1] = eight;
        buttons[2][2] = nine;

        grid = new GridLayout(3,3,5,5);
        setLayout(grid);

        for (JButton[] bArr: buttons) {
            for (JButton b: bArr) {
                add(b);
                b.setBorderPainted(false);
                b.addActionListener(this);
                b.setBackground(Color.WHITE);
            }
        }

        //setBackground(Color.BLACK);

        setVisible(true);

    }

    @Override
    public void paintComponent(Graphics arg0) {
        // TODO Auto-generated method stub
        super.paintComponent(arg0);
        arg0.setColor(Color.BLACK);
        arg0.fillRect(5, 5, getWidth()-10, getHeight()-10);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton b = (JButton) arg0.getSource();
        b.setDisabledIcon(x);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (buttons[r][c].equals(b)) {
                    board[r][c] = 1;
                    
                    buttons[r][c].setEnabled(false);
                    
                }
            }
        }
        System.out.println(board);
    }

    public void toggleActive() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] != 0) {
                    buttons[r][c].setEnabled(!isActive);
                }
            }
        }
        isActive = !isActive;
    }
    
}
