import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class BigBoard extends JPanel{

    GridLayout grid;

    ArrayList<SmallBoardContainer> smallBoards;

    JButton startButton;

    public BigBoard(JButton sButton) {
        smallBoards = new ArrayList<SmallBoardContainer>();
        startButton = sButton;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                smallBoards.add(new SmallBoardContainer(new Point(i, j)));
            }
        }

        grid = new GridLayout(3,3,15,15);

        setLayout(grid);
        for (SmallBoardContainer e : smallBoards)
        {
            add(e);
        }

        setBackground(Color.BLACK);
        setVisible(true);
        
    }

    public void startGame() { // This is the method that starts the game off

    }


}
