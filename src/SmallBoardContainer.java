import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
    /**
     * If a small board has been filled, this method replaces that board with an image
     * signifying who won, if anyone at all.
     * TODO: add functionality to resize these big images when the window is resized. 
     */
    public void setBigIcon() {
        int winner = smallBoard.getWinner();
        ImageIcon bigImage = new ImageIcon("src/images/x.png");
        // depending on the winnner, a bigIcon is chosen to display
        if (winner == 1) {
        } else if (winner == 2) {
            bigImage = new ImageIcon("src/images/o.png");
        } else if (winner == -1) {
            bigImage = new ImageIcon("src/images/x.png");
        } else {
            // TODO: code for the tie goes here
            bigImage = new ImageIcon("src/images/x.png");
        }
        // creates a new image that is scaled up from the image icon
        Image newImage = bigImage.getImage().getScaledInstance(smallBoard.getWidth()-20, smallBoard.getHeight()-20, Image.SCALE_SMOOTH);
        // removes the smallBoard that was added
        remove(smallBoard);
        // adds the new image in its place
        add(new JLabel(new ImageIcon(newImage)), BorderLayout.CENTER);
    }
}