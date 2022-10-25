import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
    public SnowFlakePanel()
    {
        super.setPreferredSize(new Dimension(400, 400));
        super.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)
    {
        int width  = getWidth();
        int height = getHeight();

        super.paintComponent(g);
        Snowflake s = new Snowflake();

        Random rng = new Random();
        for (int i = 0; i < 30; i++) {
            Color c = new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
            g.setColor(c);
            s.drawStar(g, rng.nextInt(width), rng.nextInt(height), rng.nextInt(width / 10));
        }

    }
}

//

public class Snowflake
{
    public static void main ( String[] args )
    {
        /*
         * A frame is a container for a panel
         * The panel is where the drawing will take place
         */
        JFrame frame = new JFrame("Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SnowFlakePanel());
        frame.pack();
        frame.setVisible(true);
    }


    public void drawStar(Graphics g, int x, int y, int size) {
        int newX = 0;
        int newY = 0;
        if (size > 5) {
            for (int i = 0; i < 6; i++) {
                newX = (int) (size * Math.cos(i*((2*Math.PI) / 6)));
                newY = (int) (size * Math.sin(i*((2*Math.PI) / 6)));
                g.drawLine(x, y, (int) (x + newX), (int) (y - newY));
                drawStar(g, x - newX, y + newY, size/3);
            }
        }
    }
}