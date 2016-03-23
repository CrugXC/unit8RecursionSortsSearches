import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FractalViewer implements ActionListener
{
    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;

    private final int MIN = 1, MAX = 20;
    
    private JButton increase, decrease;
    private JLabel titleLabel, orderLabel;
    private TreePanel drawing;
    private JPanel panel, tools;
    private JFrame frame;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        FractalViewer viewer = new FractalViewer();
    }

    public FractalViewer()
    {
        tools = new JPanel ();
        tools.setLayout (new BoxLayout(tools, BoxLayout.X_AXIS));
        tools.setBackground (Color.blue);
        tools.setOpaque (true);

        titleLabel = new JLabel ("Fractal Tree");
        titleLabel.setForeground (Color.black);
        
        increase = new JButton (new ImageIcon ("increase.gif"));
        increase.setPressedIcon (new ImageIcon ("increasePressed.gif"));
        increase.setMargin (new Insets (0, 0, 0, 0));
        increase.addActionListener (this);
        decrease = new JButton (new ImageIcon ("decrease.gif"));
        decrease.setPressedIcon (new ImageIcon ("decreasePressed.gif"));
        decrease.setMargin (new Insets (0, 0, 0, 0));
        decrease.addActionListener (this);
        
        orderLabel = new JLabel ("Order: 1");
        orderLabel.setForeground (Color.black);

        tools.add (titleLabel);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (decrease);
        tools.add (increase);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (orderLabel);

        drawing = new TreePanel (1);
        drawing.addKeyListener(new KeyList());
        
        panel = new JPanel();
        panel.add (tools);
        panel.add (drawing);

        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
        drawing.requestFocusInWindow();
    }
    
    public class KeyList implements KeyListener
    {
        public void keyPressed (KeyEvent event)
        {
            int order = drawing.getOrder();
            System.out.println(event.getKeyCode());
            if (event.getKeyCode() == 38)
            {
                order++;
                System.out.println("Up");
            }
            else if (event.getKeyCode() == 40)
            {
                order--;
                System.out.println("Down");
            }
            order(order);
        }
        
        public void keyReleased (KeyEvent event)
        {
        
        }
    
        public void keyTyped (KeyEvent event)
        {
        
        }
    }
    
    public void actionPerformed (ActionEvent event)
    {
        int order = drawing.getOrder();
        
        if (event.getSource() == increase)
            order++;
        else
            order--;

        this.order(order);
    }
    
    public void order(int order)
    {

        if (order >= MIN && order <= MAX)
        {
            orderLabel.setText ("Order: " + order);
            drawing.setOrder (order);
            frame.repaint();
        }
        
        drawing.requestFocusInWindow();
    }
}
