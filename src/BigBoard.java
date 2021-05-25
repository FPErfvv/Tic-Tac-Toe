import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

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
    public BigBoard() {
        one = new SmallBoardContainer();
        nine = new SmallBoardContainer();
        two = new SmallBoardContainer();
        three = new SmallBoardContainer();
        four = new SmallBoardContainer(); 
        five = new SmallBoardContainer();
        six = new SmallBoardContainer();
        seven = new SmallBoardContainer();
        eight = new SmallBoardContainer();
        grid = new GridLayout(3,3,15,15);

        setLayout(grid);
        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(seven);
        add(eight);
        add(nine);

        setBackground(Color.BLACK);
        setVisible(true);
        
    }


}
