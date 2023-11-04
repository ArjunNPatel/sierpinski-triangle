import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class STFrame extends JFrame
{

    public STFrame()
    {
        setTitle("Sierpinski Triangle");
        add(new STPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}