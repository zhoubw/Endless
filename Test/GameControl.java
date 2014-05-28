import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.imageio.*;

/**
 * GameControl
 * Includes ActionListener, KeyAdapter
 * action per frame and paintComponent
 **/

public class GameControl extends JPanel implements ActionListener{
    //timer keeps track of fps and actionPerformed
    protected Timer timer;
    
    //gameMode: playing or not; next for not playing
    protected boolean gameMode,next;
    
    //keeps track of time
    protected double time;

    //Background of game
    //to be used later
    protected ImageIcon background_ii,bgii;
    protected Image background,bg;
    protected Font font;
    protected BufferedImage image;

    //player is attached to game
    protected Player p;

    public GameControl(){
	p = new Player();
	gameMode=true;next=false;
	
	//background_ii = new ImageIcon("background.png");
	//background = background_ii.getImage();
	
	//bgii = new ImageIcon("grid.gif");
	//bg = bgii.getImage();

	//Adds key listener
	setFocusable(true);
	addKeyListener(new TAdapter());

	//Timer for game
	timer = new Timer(20,this);
	time = 0;
	timer.start();
	/**
	 * Font
	 *
	try{
	    font = Font.createFont(Font.TRUETYPE_FONT,new File("Exo.ttf"));
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    ge.registerFont(font);

	    font = font.deriveFont(28f);
	    setFont(font);
	}catch(IOException e){
	    e.printStackTrace();
	}catch(FontFormatException e){
	    e.printStackTrace();
	}
	*/

    }
    
    //handles actions performed per frame
    public void actionPerformed(ActionEvent e) {
	if (gameMode){
	    p.move();
	    p.jump(time);
	    //if (c.shooting)
		//c.shoot(time);
	}
	time+=0.02;
	repaint();
	//System.out.println(time);
    }

    //handles printing
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setColor(Color.BLACK);
	
	Graphics2D g2d = (Graphics2D)g;
	
	if (p.hp > 0) {
	    if (p.right) { //fix direction later
		g2d.drawImage(p.image_runRight,
			  (int)(p.x-p.getDXRun()),(int)(p.y-p.getDYRun()),
			  52,64,this);
	    }
	    else if (p.left) {
		g2d.drawImage(p.image_runLeft,
			  (int)(p.x-p.getDXRun()),(int)(p.y-p.getDYRun()),
			  52,64,this);
	    }
	    else{
		if (p.facingRight) {
		    g2d.drawImage(p.image_standRight,
				  (int)(p.x-p.getDXStand()),(int)(p.y-p.getDYStand()),
				  46,64,this);
		}
		else {
		    g2d.drawImage(p.image_standLeft,
				  (int)(p.x-p.getDXStand()),(int)(p.y-p.getDYStand()),
				  46,64,this);
		}
	    }
	}

	Toolkit.getDefaultToolkit().sync();
	g.dispose();
    }

    //Controls key pressed
    public class TAdapter extends KeyAdapter {
	public void keyReleased(KeyEvent e) {
	    if (gameMode){
		p.keyReleased(e);
		//remove this later
		if (e.getKeyCode() == KeyEvent.VK_P)
		    time +=1;
		//^^^
		return;
	    }
	    int key = e.getKeyCode();
	    if (key == KeyEvent.VK_Z){
		next=true;
	    }
	}
	public void keyPressed(KeyEvent e){
	    if (gameMode){
		p.keyPressed(e);
	    }
	}
    } //end TAdapter
    
} //end class GameControl












