import javax.swing.JPanel;
import java.awt.*;

public class SmallBoardContainer extends JPanel {
    JPanel fillLeft;
    JPanel fillRight;
    JPanel fillTop;
    JPanel fillBottom;
    public SmallBoardContainer(Point p) {
        setLayout(new BorderLayout());
        fillLeft = new JPanel();
        fillRight = new JPanel();
        fillTop = new JPanel();
        fillBottom = new JPanel();
        SmallBoard smallBoard = new SmallBoard(p);
        add(fillLeft, BorderLayout.EAST);
        add(fillRight, BorderLayout.WEST);
        add(fillTop, BorderLayout.NORTH);
        add(fillBottom, BorderLayout.SOUTH);
        add(smallBoard, BorderLayout.CENTER);
        setColor(Color.WHITE);
    }

    public void setColor(Color c) {
        fillLeft.setBackground(c);
        fillRight.setBackground(c);
        fillTop.setBackground(c);
        fillBottom.setBackground(c);
    }
}