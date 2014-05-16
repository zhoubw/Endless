import java.io.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;

// This is the basic frame.

public class Gui {
    private JFrame frame;
    //    private Graphics g;
    private JPanel panel;
    private boolean running = true;
    protected static long inittime;
	
    public Gui() {
	inittime = System.currentTimeMillis(); //subject to be moved
        frame = new JFrame("Gui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024,768);

	frame.setResizable(false);
        frame.setVisible(true);
	
	       
    }       


   public static void main(String[] args) {
        Gui g = new Gui();
	
        BlackScreen scrn = new BlackScreen();
	g.frame.add(scrn);
	while (g.running) {
	    if (System.currentTimeMillis() % 17 == 0) {scrn.repaint();}
	}
   }
    
}