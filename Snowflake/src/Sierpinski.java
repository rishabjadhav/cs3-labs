import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SierpinskiPanel extends JPanel
{
    public SierpinskiPanel()
    {
        super.setPreferredSize(new Dimension(600, 600));
        super.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)
    {
        int width  = getWidth();
        int height = getHeight();

        super.paintComponent(g);
        Sierpinski s = new Sierpinski();

        /*
         * DRAWING CODE BELOW
         */
        //int size = width<height?width:height;
        int size = 0;

        if(width<height) {
            size = width;
        }
        else
        {
            size = height;
        }
        s.sierpinski(g, 0, 0, size);
    }
}

public class Sierpinski
{
    public static void main ( String[] args )
    {
        /*
         * A frame is a container for a panel
         * The panel is where the drawing will take place
         */
        JFrame frame = new JFrame("Sierpinski");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SierpinskiPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public void sierpinski(Graphics g, int x, int y, int size) {
        if (size > 1) {
            g.drawLine(x, y, x + size, y);
            g.drawLine(x, y, x, y + size);
            g.drawLine(x + size, y, x, y + size);

            sierpinski(g, x, y, size / 2);
            sierpinski(g, x, y + size / 2, size / 2);
            sierpinski(g, x + size / 2, y, size / 2);
        }
    }
}