package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class mouseex extends WindowAdapter implements MouseListener,MouseMotionListener
{
Label label1, label2;
Frame frame;
String str;

mouseex()
{
frame = new Frame("Window");
label1= new Label("Handling mouse events in the Frame window", Label.CENTER);
label2= new Label();
Point p;

frame.setLayout(new FlowLayout());
frame.add(label1);
frame.add(label2);

//Registering class MouseEx1 to catch and respond to mouse events 
frame.addMouseListener(this); 
frame.addMouseMotionListener(this);



//Registering class MouseEx3 to catch and respond to window event i.e. window closing event
frame.addWindowListener(this);
frame.setSize(340,200);
frame.setVisible(true);
}


public void mouseClicked(MouseEvent we)
{
str+=" and Mouse button was clicked";
label2.setText(str);
frame.setVisible(true);
}

public void mouseEntered(MouseEvent we)
{
label2.setText("Mouse has entered the window area");
frame.setVisible(true);
}

public void mouseExited(MouseEvent we)
{
label2.setText("Mouse has exited the window area");
frame.setVisible(true);
}


public void mousePressed(MouseEvent we)
{
label2.setText("Mouse button is being pressed");
frame.setVisible(true);
}

public void mouseReleased(MouseEvent we)
{
str="Mouse button is released";
label2.setText(str);
frame.setVisible(true);
}

public void windowClosing(WindowEvent we)
{
    System.exit(0);
}


//Method of MouseMotionListener interface
public void mouseDragged(MouseEvent me)
{
String s = me.getX() + "," + me.getY();
label2.setText("Mouse dragged "+ s);
frame.setVisible(true);
}


//Method of MouseMotionListener interface
public void mouseMoved(MouseEvent me)
{
String s = me.getX() + "," + me.getY();
label2.setText("Mouse moved "+ s);
frame.setVisible(true);
}


public static void main(String... ar)
{
new mouseex();
}

}