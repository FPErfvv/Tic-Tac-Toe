package testing;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener {
    String name;
    JButton test;
    JButton test2;

    public Panel(String name) {
        
        this.name = name;
        test = new JButton(name);
        test2 = new JButton(name + "!!!");
        setLayout(new FlowLayout());
        test.setOpaque(false);
        test.setContentAreaFilled(false);
        //test2.setOpaque(false);
        test2.setContentAreaFilled(false);
        //test.setBorderPainted(false);
        test.addActionListener(this);
        test2.addActionListener(this);
        Dimension d = new Dimension(50,500);
        test.setPreferredSize(d);
        add(test);
        add(test2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object source = arg0.getSource();
        if(source == test)
            System.out.println(name);
        else
            System.out.println(name + "!!!");
        

    }
}
