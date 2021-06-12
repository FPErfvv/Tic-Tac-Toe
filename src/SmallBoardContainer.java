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
    JLabel bigIcon;
    boolean hasBigIcon;
    public SmallBoardContainer(BigBoard b) {
        setLayout(new BorderLayout());
        fillLeft = new JPanel();
        fillRight = new JPanel();
        fillTop = new JPanel();
        fillBottom = new JPanel();
        smallBoard = new SmallBoard(this, b);
        add(fillLeft, BorderLayout.EAST);
        add(fillRight, BorderLayout.WEST);
        add(fillTop, BorderLayout.NORTH);
        add(fillBottom, BorderLayout.SOUTH);
        add(smallBoard, BorderLayout.CENTER);
        bigIcon = new JLabel();
        clearHighlight();
        setBackground(Color.WHITE);
        hasBigIcon = false;
    }
    /**
     * Sets the color of the rim around the SmallBoard to highlight certain boards.
     * Since the player often has only one board to choose from, it is helpful to 
     * highlight the board that he/she needs to focus on. 
     */
    public void highlight() {
        fillLeft.setBackground(Color.GREEN);
        fillRight.setBackground(Color.GREEN);
        fillTop.setBackground(Color.GREEN);
        fillBottom.setBackground(Color.GREEN);
    }

    public void clearHighlight() {
        fillLeft.setBackground(Color.WHITE);
        fillRight.setBackground(Color.WHITE);
        fillTop.setBackground(Color.WHITE);
        fillBottom.setBackground(Color.WHITE);
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
        ImageIcon bigImage = new ImageIcon("src/images/largeX.png");
        // depending on the winnner, a bigIcon is chosen to display
        if (winner == 1) {
            bigImage = new ImageIcon("src/images/largeX.png");
        } else if (winner == 2) {
            bigImage = new ImageIcon("src/images/largeO.png");
        } else if (winner == -1) {
            bigImage = new ImageIcon("src/images/tie.png");
        } else {
            // TODO: code for the tie goes here
            return;
        }
        // creates a new image that is scaled up from the image icon
        Image newImage = bigImage.getImage().getScaledInstance(smallBoard.getWidth()-20, smallBoard.getHeight(), Image.SCALE_SMOOTH);

        if (winner == -1)
            newImage = bigImage.getImage().getScaledInstance(smallBoard.getWidth()-70, smallBoard.getHeight()-50, Image.SCALE_SMOOTH);
        // removes the smallBoard that was added
        if (hasBigIcon) {
            remove(bigIcon);
        }else {
            remove(smallBoard);
        }
        
        bigIcon = new JLabel(new ImageIcon(newImage));
        // adds the new image in its place
        add(bigIcon, BorderLayout.CENTER);
        hasBigIcon = true;
    }

    public void resizeBigIcon() {
        if (hasBigIcon) { // only resize the image if it has been put in place.
            ImageIcon bigImage = (ImageIcon) bigIcon.getIcon();
            Image newImage = bigImage.getImage().getScaledInstance(this.getHeight()-30, this.getHeight()-30, Image.SCALE_SMOOTH);
            remove(bigIcon);
            bigIcon = new JLabel(new ImageIcon(newImage));
            // adds the new image in its place
            add(bigIcon, BorderLayout.CENTER);
        }

    }

    public void resetContainer() {
        clearHighlight();
        smallBoard.resetBoard();
        smallBoard.disable();
        if (hasBigIcon) {
            hasBigIcon = false;
            remove(bigIcon);
            add(smallBoard, BorderLayout.CENTER);
            repaint();
        }
        
    }

}