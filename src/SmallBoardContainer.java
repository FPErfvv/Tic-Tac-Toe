import javax.swing.JPanel;
import java.awt.*;

public class SmallBoardContainer extends JPanel {
    JPanel fillLeft;
    JPanel fillRight;
    JPanel fillTop;
    JPanel fillBottom;
    SmallBoard smallBoard;
    public SmallBoardContainer(Point p) {
        setLayout(new BorderLayout());
        fillLeft = new JPanel();
        fillRight = new JPanel();
        fillTop = new JPanel();
        fillBottom = new JPanel();
        smallBoard = new SmallBoard(p);
        add(fillLeft, BorderLayout.EAST);
        add(fillRight, BorderLayout.WEST);
        add(fillTop, BorderLayout.NORTH);
        add(fillBottom, BorderLayout.SOUTH);
        add(smallBoard, BorderLayout.CENTER);
        setColor(Color.WHITE);
    }
    /**
     * Sets the color of the rim around the SmallBoard to highlight certain boards.
     * Since the player often has only one board to choose from, it is helpful to 
     * highlight the board that he/she needs to focus on. 
     */
    public void setColor(Color c) {
        fillLeft.setBackground(c);
        fillRight.setBackground(c);
        fillTop.setBackground(c);
        fillBottom.setBackground(c);
    }

    public SmallBoard getSmallBoard()
    {
        return smallBoard;
    }
}