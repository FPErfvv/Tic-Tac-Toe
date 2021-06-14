import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;

public class TitlePage extends JPanel {
    BoxLayout layout;
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

        
        JLabel description = new JLabel("<html>  -- The instructions can go here. thanks for doing all of this. just keep typing and it should wrap around by itself. Keep the html tags as they allow that wrapping.</html>");
        description.setPreferredSize(new Dimension(f.getWidth()-40, 100));
        add(spacer);
        add(title);
        add(spacer);
        add(boardLabel);
        add(spacer);
        add(description);
    }
}
