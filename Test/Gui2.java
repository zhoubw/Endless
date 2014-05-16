import java.io.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;

// This is the basic frame.

/**************************************************
 *
 *  Timer implementation
 *
 **************************************************/

public class Gui2 {
    private JFrame frame;
    //private Graphics g;
    private JPanel panel;
    // private boolean running = true;
    
    public Gui2() {
	//inittime = System.currentTimeMillis(); //subject to be moved
        frame = new JFrame("Gui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024,768);

	frame.setResizable(false);
        frame.setVisible(true);
	
	       
    }       

    

   public static void main(String[] args) {
        Gui2 g2 = new Gui2();
	
        BlackScreen2 scrn = new BlackScreen2();
	g2.frame.add(scrn);	
   }
    
}