import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.Color;

public class BlackScreen extends JPanel implements MouseListener, MouseMotionListener, KeyListener{	
    
    private Set<KeyEvent> Keys;

    private ArrayList<RectBullet> RectBullets;
    private static int delayTime = 0; //out of 1000

    private static Player player = new Player(100, 100, 3, 18, 36, new Color(255, 0, 0));

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
	if (e.getKeyCode() == KeyEvent.VK_X) Keys.add(e);
	if (e.getKeyCode() == KeyEvent.VK_LEFT) Keys.add(e);
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) Keys.add(e);
	if (e.getKeyCode() == KeyEvent.VK_UP) Keys.add(e);
	if (e.getKeyCode() == KeyEvent.VK_DOWN) Keys.add(e);
	
	//iterate over multiple keys
	for (KeyEvent ke : Keys) {
	    if (ke.getKeyCode() == KeyEvent.VK_X) RectBullets.add( new RectBullet(player.x_cor + 24, player.y_cor + 18, new Color(0, 0, 255), System.currentTimeMillis(), 10000));
	    if (ke.getKeyCode() == KeyEvent.VK_LEFT) player.dx -= player.speed;
	    if (ke.getKeyCode() == KeyEvent.VK_RIGHT) player.dx += player.speed;
	    if (ke.getKeyCode() == KeyEvent.VK_UP) player.dy -= player.speed;
	    if (ke.getKeyCode() == KeyEvent.VK_DOWN) player.dy += player.speed;

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
	if (e.getKeyCode() == KeyEvent.VK_X) Keys.remove(e);
	if (e.getKeyCode() == KeyEvent.VK_LEFT) {player.dx = 0; Keys.remove(e);}
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {player.dx = 0; Keys.remove(e);}
	if (e.getKeyCode() == KeyEvent.VK_UP) {player.dy = 0; Keys.remove(e);}
	if (e.getKeyCode() == KeyEvent.VK_DOWN) {player.dy = 0; Keys.remove(e);}
	}
    public void keyTyped(KeyEvent e) {
	//omit
    }
    
    
    //Constructor
    public BlackScreen() {
	Keys = new HashSet<KeyEvent>();
	RectBullets = new ArrayList<RectBullet>();
	addMouseListener(this);
	addMouseMotionListener(this);
       	setFocusable(true);
       	addKeyListener(this);
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
	    long currenttime = System.currentTimeMillis();
	    if ( (currenttime - b.getSpawntime()) < b.getLifespan() ) { //valid
		b.spawn(g);
	    }
	    else {
		RectBullets.remove(b);

	    }
	}

    }

}
