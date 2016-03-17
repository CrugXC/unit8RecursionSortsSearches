
import java.awt.geom.Line2D;
import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;

public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 1920;
   private final int PANEL_HEIGHT = 1080;

   private final double RATIO = 0.87;

   private int current; 
   
   private final double BTHETA = Math.toRadians(30.0);
   private final double BTHETA2 = Math.toRadians(10.0);
   
   public TreePanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }


   public void drawFractal (int order, double x1, double y1, double theta, double distance,
                            Graphics2D g2)
   {
      double deltaXPlus, deltaYPlus, deltaXMinus, deltaYMinus, x2, y2, x3, y3, plusTheta, minusTheta;
      Random r1 = new Random();
      
      distance *= RATIO;
      plusTheta = theta + BTHETA;
      minusTheta = theta - BTHETA2;
      
      if(order >= 20 || order == 1)
      {
          return;
      }
      else
      {
          deltaXPlus = (distance * Math.sin(plusTheta));
          deltaYPlus = (distance * Math.cos(plusTheta));
          
          deltaXMinus = (distance * Math.sin(minusTheta));
          deltaYMinus = (distance * Math.cos(minusTheta));
          
          x2 = x1 - deltaXPlus;
          y2 = y1 - deltaYPlus;
          
          x3 = x1 - deltaXMinus;
          y3 = y1 - deltaYMinus;
          
          g2.setColor(new Color(0, (int)(255 * (y2/1080)>1?1:(x2/1080)), (int)(255 * (y2/1920)>1?1:(y2/1920)))); 
          g2.draw(new Line2D.Double(x1, y1, x2, y2));
          
          g2.setColor(new Color(0, (int)(255 * (x3/1080)>1?1:(x3/1080)), (int)(255 * (y3/1920)>1?1:(y3/1920))));
          g2.draw(new Line2D.Double(x1, y1, x3, y3));
          
          drawFractal(order - 1, x2, y2, plusTheta, distance, g2);
          drawFractal(order - 1, x3, y3, minusTheta, distance, g2);
      }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      Graphics2D g2 = (Graphics2D) page;
      Random r1 = new Random();
      super.paintComponent (g2);
      Color[] colorList = {Color.RED, Color.GREEN, Color.BLUE};
      g2.setColor (colorList[r1.nextInt(3)]);
      
      g2.draw(new Line2D.Double(970, 800, 970, 1000));
      drawFractal (current, 970, 800, 0, 100.0, g2);
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
