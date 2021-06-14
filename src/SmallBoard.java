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
    int[][] board;
    JButton[][] buttons;
    boolean isFilled;
    boolean isActive;
    boolean won; // .winner() must be called after every move to update these values as of now
    int winner; // 0 if no winner, 1 if 1 won, 2 if 2 won, -1 if tie
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

    int currentPlayer;
    int prevClickLocation;

    SmallBoardContainer container;
    BigBoard bigBoard;

    String gameMode;

    public SmallBoard(SmallBoardContainer c, BigBoard bigBoard) {
        // the image that is placed when the player is x
        x = new ImageIcon("src/images/x.png");
        // the image that is placed when the player is y
        o = new ImageIcon("src/images/o.png");
        board = new int[][] {{ 0, 0, 0 }, 
                             { 0, 0, 0 },
                             { 0, 0, 0 }};
        isFilled = false;
        isActive = true;
        won = false;
        winner = 0;
        currentPlayer = 1; // determines the current player (x is 1, o is 2)
        gameMode = "Two Player";

        container = c;
        this.bigBoard = bigBoard;
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

        grid = new GridLayout(3, 3, 5, 5);
        setLayout(grid);

        for (JButton[] bArr : buttons) {
            for (JButton b : bArr) {
                add(b);
                b.setBorderPainted(false);
                b.addActionListener(this);
                b.setDisabledIcon(x);
                b.setBackground(Color.WHITE);
            }
        }
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics arg0) { // draws the lines for the board. 
        // TODO Auto-generated method stub
        super.paintComponent(arg0);
        arg0.setColor(Color.BLACK);
        arg0.fillRect(5, 5, getWidth() - 10, getHeight() - 10);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton b = (JButton) arg0.getSource();
        buttonClicked(b);
    }

    public void buttonClicked(JButton b) {
        if (currentPlayer == 1) { // sets the button clicked to the right player
            b.setIcon(x);
            b.setDisabledIcon(x);
            currentPlayer = 2;
        } else if (currentPlayer == 2) {
            b.setIcon(o);
            b.setDisabledIcon(o);
            currentPlayer = 1;
        }
        b.setEnabled(false);
        int count = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                
                if (buttons[r][c].equals(b)) { // updates the 2D int[][] array that maps the positions clicked
                    board[r][c] = 3-currentPlayer;
                    prevClickLocation = count;
                }
                count++;
            }
        }
        winner();
        bigBoard.checkBigWin(prevClickLocation, currentPlayer);
        bigBoard.largeWinner();
    }

    public void enable() { // sets all the buttons on the board to be clickable
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == 0) {
                    buttons[r][c].setEnabled(true);
                }
            }
        }
        isActive = true;
    }

    public void disable() { // sets all the buttons on the board to be unclickable
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == 0) {
                    buttons[r][c].setEnabled(false);
                }
            }
        }
        isActive = false;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setCurrentPlayer(int cPlayer) {
        currentPlayer = cPlayer;
    }

    public String legalMoves() //returns a String with the legal squares, works since numbers are all 1 digit, i intend to use .indexOf() 
    {
        String moves = "";
        int count = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == 0)
                {
                    moves += String.valueOf(count); //IF THERES A PROBLEM, CHECK THIS LINE
                }
                count++;
            }
        }

        return moves;
    }

    public int winner() //returns 0 if no winner, 1 if 1 won, 2 if 2 won, -1 if tie
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2])
            {
                if (board[i][0] != 0)
                {
                    winner = board[i][0];
                    won = true;
                    container.setBigIcon();
                    return winner;
                }
            }

            if (board[0][i] == board[1][i] && board[0][i] == board[2][i])
            {
                if (board[0][i] != 0)
                {
                    winner = board[0][i];
                    won = true;
                    container.setBigIcon();
                    return winner;
                }
            }
        }

        if (board[0][0] == board[1][1] && board[0][0] == board[2][2])
        {
            if (board[0][0] != 0)
            {
                winner = board[0][0];
                won = true;
                container.setBigIcon();
                return winner;
            }
        }

        if (board[0][2] == board[1][1] && board[0][2] == board[2][0])
        {
            if (board[0][2] != 0)
            {
                winner = board[0][2];
                won = true;
                container.setBigIcon();
                return winner;
            }
        }

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == 0)
                {
                    return 0;
                }
            }
        }

        winner = -1;
        won = true;
        container.setBigIcon();
        return -1;
    }

    public boolean isWon()
    {
        return won;
    }

    public int getWinner()
    {
        return winner;
    }

    public void setGameMode(String gm) {
        gameMode = gm;
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void resetBoard() {
        board = new int[][] {{0,0,0},
                             {0,0,0},
                             {0,0,0}};
        for (JButton[] bArr : buttons) { // loops through the buttons and sets them removes all the icons.
            for (JButton b : bArr) {
                b.setIcon(null);
            }
        }
        // resets all the variables to their pregame state
        isFilled = false;
        isActive = true;
        won = false;
        winner = 0;
        currentPlayer = 1;
    }
}
