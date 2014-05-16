import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.Color;

public class BlackScreen2 extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener{	
    
    //private Set<KeyEvent> Keys;
    
    /*****************************************
     * Timer Implementation
     *
     *
     *****************************************/

    private ArrayList<RectBullet> RectBullets;
    //private static int delayTime = 0; //out of 1000

    private Timer timer;
    private int fps = 1000 / 50; //the 50 is the actual fps
    private long initTime;
    private long currentTime;
    
    //Control which keys are pressed
    boolean keyUP, keyDOWN, keyLEFT, keyRIGHT, keyX;
    

    //testing with static
    private static Player player = new Player(100, 100, 3, 18, 36, new Color(255, 0, 0));
    
    //Constructor
    public BlackScreen2() {
	timer = new Timer(fps, this);
	initTime = System.currentTimeMillis();
	currentTime = System.currentTimeMillis();

	//Keys = new HashSet<KeyEvent>();
	RectBullets = new ArrayList<RectBullet>();

	addMouseListener(this);
	addMouseMotionListener(this);
       	setFocusable(true);
       	addKeyListener(this);
    
	timer.start();
    }

    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {
	
    }
    public void mouseEntered(MouseEvent e) {
	
    }
    public void mouseExited(MouseEvent e) {
	
    }
    public void mouseClicked(MouseEvent e) {
	
    }
    public void mouseMoved(MouseEvent e) {
	//player.x_cor = e.getX() - (player.getWidth()/2);
	//player.y_cor = e.getY() - (player.getHeight()/2);
    }
    public void mouseDragged(MouseEvent e) {
	//player.x_cor = e.getX() - (player.getWidth()/2);
	//player.y_cor = e.getY() - (player.getHeight()/2);
    }
    public void keyPressed(KeyEvent e) {
	/*
	if (e.getKeyCode() == KeyEvent.VK_X) { 
	    if (delayTime == 0) RectBullets.add( new RectBullet(player.x_cor + 24, player.y_cor + 18, new Color(0, 0, 255), System.currentTimeMillis(), 10000));
	    delayTime += RectBullet.delay;
	    
	}
	
	if (e.getKeyCode() == KeyEvent.VK_LEFT) player.dx -= player.speed;
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) player.dx += player.speed;
	if (e.getKeyCode() == KeyEvent.VK_UP) player.dy -= player.speed;
	if (e.getKeyCode() == KeyEvent.VK_DOWN) player.dy += player.speed; 
	*/
	switch (e.getKeyCode()) {
	case KeyEvent.VK_X: keyX = true; break;
	case KeyEvent.VK_UP: keyUP = true; break;
	case KeyEvent.VK_DOWN: keyDOWN = true; break;
	case KeyEvent.VK_LEFT: keyLEFT = true; break;
	case KeyEvent.VK_RIGHT: keyRIGHT = true; break;
	}
	
    }
    public void keyReleased(KeyEvent e) {
	/*
	if (e.getKeyCode() == KeyEvent.VK_X) {
	    if (delayTime == 1000) delayTime = 0;
	}
	if (e.getKeyCode() == KeyEvent.VK_LEFT) player.dx = 0;
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) player.dx = 0;
	if (e.getKeyCode() == KeyEvent.VK_UP) player.dy = 0;
	if (e.getKeyCode() == KeyEvent.VK_DOWN) player.dy = 0;
	*/
	switch (e.getKeyCode()) {
	case KeyEvent.VK_X: keyX = false; break;
	case KeyEvent.VK_UP: keyUP = false; break;
	case KeyEvent.VK_DOWN: keyDOWN = false; break;
	case KeyEvent.VK_LEFT: keyLEFT = false; break;
	case KeyEvent.VK_RIGHT: keyRIGHT = false; break;
	}
    }
    public void keyTyped(KeyEvent e) {
	//omit
    }    

    public void actionPerformed(ActionEvent e) {
	repaint();
	currentTime = System.currentTimeMillis();
	if (keyX) RectBullets.add( new RectBullet(player.x_cor + 24, player.y_cor + 18, new Color(0, 0, 255), currentTime, 10000));
	
	if (!keyUP || !keyDOWN) player.dy = 0;
	if (!keyLEFT || !keyRIGHT) player.dx = 0;
	if (keyUP) player.dy -= player.speed;
	if (keyDOWN) player.dy += player.speed;
	if (keyLEFT) player.dx -= player.speed;
	if (keyRIGHT) player.dx += player.speed;

    }

    //this needs to be done per frame
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	this.setSize(1024, 768);
	this.setLocation(0,0);
	this.setBackground(Color.black);

	//draw player box
	g.setColor(player.getColor());
	g.drawRect(player.x_cor, player.y_cor, player.getWidth(), player.getHeight());
	player.x_cor += player.dx;
	player.y_cor += player.dy;

	//passively add bullets
	//if (System.currentTimeMillis() % 153 == 0) RectBullets.add(new RectBullet(player.x_cor + 24, player.y_cor + 18, new Color(0, 0, 255), System.currentTimeMillis(), 1000));

	//draw bullet box
	for (RectBullet b: RectBullets) {
	    if ( (currentTime - b.getSpawntime()) < b.getLifespan() ) { //valid
		b.spawn(g);
	    }
	    else {
		RectBullets.remove(b);

	    }
	}

    }

}
