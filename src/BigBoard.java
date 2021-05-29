import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class BigBoard extends JPanel{

    GridLayout grid;

    ArrayList<SmallBoardContainer> smallBoards;

    public BigBoard() {
        smallBoards = new ArrayList<SmallBoardContainer>();
        /**
         * this loop creates a new 1D arraylist of the small boards
         * it's indexes on the board are set up like this
         * {0, 1, 2,
         *  3, 4, 5,
         *  6, 7, 8}
         * use this command to highlight a smallBoard: smallBoards.get(index).setColor(Color.GREEN);
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                smallBoards.add(new SmallBoardContainer(new Point(i, j)));
            }
        }

        grid = new GridLayout(3,3,15,15);
        setLayout(grid);
        for (SmallBoardContainer e : smallBoards) {
            add(e);
        }
        setBackground(Color.BLACK);
        setVisible(true);
        
        
    }

    public void move() //consolidates a move, im not sure about some of the internals you did cattail so ill have to finish this with you, this is just an outline
    {
        //locks/unlocks relevant tiles
        //changes tile based on player click
        //calls .winner() and determines if the board is complete, acts accordingly
        //calls .largeWinner() to see if the game is over
        //changes player
    }

    public int largeWinner() //returns 0 if no winner, 1 if 1 won, 2 if 2 won, -1 if tie
    {
        //idk how to access the small boards from here but it calls .isWon() on them and checks for win condition
        return 0;
    }

    public void startGame(Object m) { // This is the method that starts the game off
        String mode = (String) m; // this is the mode that the game is in (random AI or two player)
        
    }


}
