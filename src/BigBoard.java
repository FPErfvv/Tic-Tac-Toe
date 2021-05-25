import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class BigBoard extends JPanel{

    GridLayout grid;
    SmallBoardContainer one;
    SmallBoardContainer nine;
    SmallBoardContainer two;
    SmallBoardContainer three;
    SmallBoardContainer four; 
    SmallBoardContainer five;
    SmallBoardContainer six;
    SmallBoardContainer seven;
    SmallBoardContainer eight;
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


}
