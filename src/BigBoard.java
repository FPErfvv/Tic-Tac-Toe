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
