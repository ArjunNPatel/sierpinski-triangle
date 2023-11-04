import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class STPanel extends JPanel
{
private int order = -1;
private DPanel drawing;
private JPanel selection;
private JTextField inputOrder;
private JLabel directions;
private int secret = 0;
public STPanel()
{
setPreferredSize(new Dimension(600,600));
setLayout(new BorderLayout());
drawing = new DPanel();
drawing.setBackground(Color.black);
selection = new JPanel();
directions = new JLabel("Enter an order: ");
inputOrder = new JTextField("0", 4);
inputOrder.addActionListener(new OrderListener());
selection.add(directions);
selection.add(inputOrder);
add(drawing, BorderLayout.CENTER);
add(selection, BorderLayout.SOUTH);
}
public class DPanel extends JPanel 
    {



        public void paintComponent(Graphics g)
        {
          super.paintComponent(g);




            Point p1 = new Point(getWidth()/2, 10);
            Point p2 = new Point(10, getHeight()-10);
            Point p3 = new Point(getWidth()-10, getHeight()-10);

            displayTriangles(order, p1, p2, p3, g);

        }
        private void displayTriangles(int order, Point p1, Point p2, Point p3, Graphics g)
        {
            
            int[] x = {p1.x,p2.x,p3.x};
            int[] y = {p1.y,p2.y,p3.y};
            if(order <= 0) {
                int trixm = (x[1]+x[2])/2;
                int triym = (y[0]+y[1])/2;
                g.setColor(new Color((int) (Math.random()*200) + 55, (int) (Math.random()*255), (int) (Math.random()*255)));
                Polygon c = new Polygon(x,y,3);
                g.fillPolygon(c);
                return; 
            }
            Point q1 = new Point((x[0]+x[1])/2,(y[0]+y[1])/2);
            Point q2 = new Point((x[1]+x[2])/2,(y[1]+y[2])/2);
            Point q3 = new Point((x[0]+x[2])/2,(y[0]+y[2])/2);
            displayTriangles(order-1,q2,q3,p3, g);
            displayTriangles(order-1,q1,p2,q2, g);
            displayTriangles(order-1,p1,q1,q3, g);
            //icebergs: replace p1,q1,q3 with: 
            //displayTriangles(order-1,p1,q2,q3, g);

        }
    }

    private class OrderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
          try {
          /*protect against bad inputs
          and large values, which would crash program*/
          order = Math.min(10,Integer.parseInt(inputOrder.getText())); 

        }
          catch(Exception badinput) {

           
            }
          repaint();
        }
    }
}