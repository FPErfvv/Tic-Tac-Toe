import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Container;
import java.awt.*;

public class TitlePage extends JPanel {
    FlowLayout flow;
    public TitlePage() {
        flow = new FlowLayout(FlowLayout.CENTER);
        flow.setHgap(30);
        setLayout(flow);
        setBackground(Color.WHITE);
        setVisible(true);
    }
}
