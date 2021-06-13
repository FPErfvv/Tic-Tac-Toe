
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BigBoard extends JPanel implements ActionListener {

    GridLayout grid;

    ArrayList<SmallBoardContainer> smallBoards;

    int currentPlayer;
    String gameMode;
    int targetBoardIndex;
    Timer timer;
    BigBoardContainer container;

    public BigBoard(BigBoardContainer c) {
        container = c;
        smallBoards = new ArrayList<SmallBoardContainer>();
        /**
         * this loop creates a new 1D arraylist of the small boards it's indexes on the
         * board are set up like this {0, 1, 2, 3, 4, 5, 6, 7, 8} use this command to
         * highlight a smallBoard: smallBoards.get(index).setColor(Color.GREEN);
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                smallBoards.add(new SmallBoardContainer(this));
            }
        }

        grid = new GridLayout(3, 3, 15, 15);
        setLayout(grid);
        // adds all of the smallBoardContainers to the BigBoard itself
        for (SmallBoardContainer e : smallBoards) {
            add(e);
            e.getSmallBoard().disable();
        }
        setBackground(Color.BLACK);
        setVisible(true);
        currentPlayer = 1; // x starts first
        targetBoardIndex = 0;
        gameMode = "Two Player";
        timer = new Timer(500, this);
    }

    public void move() // consolidates a move, im not sure about some of the internals you did cattail
                       // so ill have to finish this with you, this is just an outline
    {
        // locks/unlocks relevant tiles
        // changes tile based on player click
        // calls .winner() and determines if the board is complete, acts accordingly
        // calls .largeWinner() to see if the game is over
        // changes player

    }

    public int largeWinner() // returns 0 if no winner, 1 if 1 won, 2 if 2 won, -1 if tie
    {
        for (int i = 0; i < 7; i += 3) // rows
        {
            if (smallBoards.get(i).getSmallBoard().isWon() && smallBoards.get(i).getSmallBoard().getWinner() != -1
                    && smallBoards.get(i).getSmallBoard().getWinner() == smallBoards.get(i + 1).getSmallBoard()
                            .getWinner()
                    && smallBoards.get(i).getSmallBoard().getWinner() == smallBoards.get(i + 2).getSmallBoard()
                            .getWinner()) {
                int winner = smallBoards.get(i).getSmallBoard().getWinner();
                container.swapToWin(winner);
                return winner;
            }
        }

        for (int i = 0; i < 3; i++) // columns
        {
            if (smallBoards.get(i).getSmallBoard().isWon() && smallBoards.get(i).getSmallBoard().getWinner() != -1
                    && smallBoards.get(i).getSmallBoard().getWinner() == smallBoards.get(i + 3).getSmallBoard()
                            .getWinner()
                    && smallBoards.get(i).getSmallBoard().getWinner() == smallBoards.get(i + 6).getSmallBoard()
                            .getWinner()) {
                int winner = smallBoards.get(i).getSmallBoard().getWinner();
                container.swapToWin(winner);
                return winner;
            }
        }

        if (smallBoards.get(0).getSmallBoard().isWon() && smallBoards.get(0).getSmallBoard().getWinner() != -1
                && smallBoards.get(0).getSmallBoard().getWinner() == smallBoards.get(4).getSmallBoard().getWinner()
                && smallBoards.get(0).getSmallBoard().getWinner() == smallBoards.get(8).getSmallBoard().getWinner()) {
            int winner = smallBoards.get(0).getSmallBoard().getWinner(); // first diagonal
            container.swapToWin(winner);
            return winner;
        }

        if (smallBoards.get(2).getSmallBoard().isWon() && smallBoards.get(2).getSmallBoard().getWinner() != -1
                && smallBoards.get(2).getSmallBoard().getWinner() == smallBoards.get(4).getSmallBoard().getWinner()
                && smallBoards.get(2).getSmallBoard().getWinner() == smallBoards.get(6).getSmallBoard().getWinner()) {
            int winner = smallBoards.get(2).getSmallBoard().getWinner();
            container.swapToWin(winner);
            return winner; // second diagonal
        }

        for (SmallBoardContainer board : smallBoards) // checks to see if there are any unwon boards
        {
            if (!board.getSmallBoard().isWon()) {
                return 0;
            }
        }
        container.swapToWin(-1);
        return -1; // all boards are won but no player has won overall, returns tie
    }

    public void startGame(Object m) { // This is the method that starts the game off
        gameMode = (String) m; // this is the mode that the game is in (random AI or two player)

        for (SmallBoardContainer e : smallBoards) {
            e.resetContainer();
            e.getSmallBoard().enable();
            e.getSmallBoard().setGameMode(gameMode);
        }
        currentPlayer = 1;
        container.reset();
    }

    public void stopGame() {
        for (SmallBoardContainer e : smallBoards) {
            e.getSmallBoard().disable();
        }
    }

    public void resizeBigIcons() { // resize the bigIcons of all the boards.
        for (SmallBoardContainer board : smallBoards) {
            board.resizeBigIcon();
        }
    }

    public void checkBigWin(int prevClickLocation, int currentPlayer) {
        this.currentPlayer = currentPlayer;
        targetBoardIndex = prevClickLocation;
        for (SmallBoardContainer e : smallBoards) {
            e.getSmallBoard().setCurrentPlayer(currentPlayer);
        }
        lockAllBoards(prevClickLocation);

    }

    public void lockAllBoards(int exeption) {
        resetHighlight();
        if (smallBoards.get(exeption).getSmallBoard().isWon()) { // if the whole smallBoard has been won, the whole
                                                                 // board is enabled
            for (SmallBoardContainer smc : smallBoards) {
                smc.getSmallBoard().enable();
            }
        } else { // if the targeted smallBoard has not been won, then it is highlighted and only
                 // it is set to be enabled.
            smallBoards.get(exeption).highlight();

            for (int i = 0; i < 9; i++) {
                smallBoards.get(i).getSmallBoard().disable();
                if (!gameMode.equals("Random AI") || currentPlayer == 1) { // makes it so the board is all locked when its the AIs turn
                    if (i == exeption) { // however, if it is not the AIs turn the target board is unlocked
                        smallBoards.get(i).getSmallBoard().enable();
                    }
                }

            }
        }
        System.out.println(currentPlayer);
        if (gameMode.equals("Random AI")) {
            if (currentPlayer == 2) {
                timer.start();
            }
 
        }
    }

    public void resetHighlight() {
        for (SmallBoardContainer e : smallBoards) {
            e.clearHighlight();
        }
    }

    public ArrayList<SmallBoardContainer> getSmallBoardContainers() {
        return smallBoards;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        // TODO: when the AI plays it still can choose from the finished boards. ADD logic so that when it can choose anywhere, it does not choose from a completed board.
        int randomBoard = targetBoardIndex;
        while (smallBoards.get(randomBoard).getSmallBoard().isWon()) // this detects of the targetedSmallBoard has been already won
            randomBoard = (int)(Math.random() * 9); // if it has been one a random clear board is chosen

        int AIRandomIndexRow = (int) (Math.random() * 3); // gets a random row index
        int AIRandomIndexCol = (int) (Math.random() * 3); // gets a random col index
        // if the random coordinate is already full, a new one is chosen
        while (smallBoards.get(randomBoard).getSmallBoard().getBoard()[AIRandomIndexRow][AIRandomIndexCol] != 0) { 
            AIRandomIndexRow = (int) (Math.random() * 3); 
            AIRandomIndexCol = (int) (Math.random() * 3);
        }
        smallBoards.get(randomBoard).getSmallBoard().buttonClicked(smallBoards.get(randomBoard).getSmallBoard().getButtons()[AIRandomIndexRow][AIRandomIndexCol]);
        timer.stop();
    }
}
