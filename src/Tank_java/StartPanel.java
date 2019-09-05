package Tank_java;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.red);
        g.drawString("Welcome To Play Tank Game",150,250 );
        setBackground(Color.black);
    }
}

