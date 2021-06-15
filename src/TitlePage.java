import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class TitlePage extends JPanel {
    public TitlePage(JFrame f) {
        setBackground(Color.WHITE);
        setVisible(true);
        addItems(f);
    }

    public void addItems(JFrame f) {
        
        
        JLabel title = new JLabel("             Ultimate Tic-Tac-Toe");
        title.setPreferredSize(new Dimension(f.getWidth()-40, 40));

        ImageIcon boardIcon = new ImageIcon("src/images/BoardPic.png");
        JLabel spacer = new JLabel("     ");
        spacer.setPreferredSize(new Dimension(20,20));
        JLabel boardLabel = new JLabel(boardIcon);
        boardLabel.setPreferredSize(new Dimension(f.getWidth()-10,200));
        Font labelFont = title.getFont();
        // Set the title's font size to the newly determined size.
        title.setFont(new Font(labelFont.getName(), Font.PLAIN, 40));

        
        JLabel description = new JLabel("<html>  -- Welcome to Ultimate Tic-Tac-Toe!! This is an exiting game that is easy to learn and play. There are two modes, Two Player (player against player) and Random AI (player against AI that chooses randomly). To start the game, go to the game board by pressing play, and then start the game with the start button. The first player, X, goes first and can choose any spot on the board. However, the next player has to choose a spot from the tic-tac-toe board that coresponds with the position chosen by the first player. For example, if the first player chooses bottom left as his target, then the second player has to choose from the bottom left tic-tac-toe board. Have fun playing!</html>");
        description.setPreferredSize(new Dimension(f.getWidth()-40, 100));
        add(spacer);
        add(title);
        add(spacer);
        add(boardLabel);
        add(spacer);
        add(description);
    }
}
