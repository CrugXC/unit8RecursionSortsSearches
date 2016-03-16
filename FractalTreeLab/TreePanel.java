
import java.awt.geom.Line2D;
import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;

public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 1000;
   private final int PANEL_HEIGHT = 1100;

   private final double RATIO = 0.8;

   private int current; 
   
   private final double BTHETA = Math.toRadians(30.0);

   public TreePanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }


   public void drawFractal (int order, double x1, double y1, double theta, double distance,
                            Graphics2D g2)
   {
      double deltaX, deltaY, x2, y2, x3, y3;
      
      distance *= RATIO;
      theta += BTHETA;
      
      if (order == 1)
      { 
        g2.draw(new Line2D.Double(x1, y1, x1, y1 + distance));
      }
      if(order == 10)
      {
      }
      else
      {
          deltaX = x1 + (distance * Math.sin(theta));
          deltaY = y1 + (distance * Math.cos(theta));
          
          x2 = x1 - deltaX;
          y2 = y1 - deltaY;
          
          x3 = x1 - deltaX;
          y3 = y1 - deltaY;
          
          drawFractal(order + 1, x2, y2, theta, distance, g2);
          drawFractal(order + 1, x3, y3, theta, distance, g2);
      }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      Graphics2D g2 = (Graphics2D) page;
      Random r1 = new Random();
      super.paintComponent (page);
      Color[] colorList = {Color.RED, Color.GREEN, Color.BLUE};
      page.setColor (colorList[r1.nextInt(3)]);
      
      drawFractal (current, 500.0, 150.0, BTHETA, 100.0, g2);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
