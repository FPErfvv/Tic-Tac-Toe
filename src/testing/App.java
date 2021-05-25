package testing;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class App extends JFrame implements ActionListener {
    JButton[][] buttons;
    public App() {
        super("test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Panel one = new Panel("One");
        //Panel two = new Panel("Two");
        setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        createBoard();
        //add(cross,BorderLayout.CENTER);
        setSize(715,715);        
        setResizable(false);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(5, 250, 695, 20);
        g.fillRect(5, 470, 695, 20);
        g.fillRect(237, 5, 20, 695);
        g.fillRect(457, 5, 20, 695);
    }

    public void createBoard() {
        buttons = new JButton[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("("+col+","+row+")");
                //buttons[row][col].setBounds(200*col, 200*row, 190, 190);
                buttons[row][col].setPreferredSize(new Dimension(200,200));
                //buttons[row][col].setOpaque(false);
                buttons[row][col].setContentAreaFilled(false);
                buttons[row][col].setBorderPainted(false);
                buttons[row][col].addActionListener(this);
                add(buttons[row][col]);
                System.out.print(buttons[row][col].getBounds().getWidth() + " ");
                System.out.println(buttons[row][col].getBounds().getHeight());
            }
        }

    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        //Panel panel = new Panel("Pane 1");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton b = (JButton) arg0.getSource();
        System.out.println(b.getText());

    }

}
