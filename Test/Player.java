import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Player {
    protected int size_mult = 2;
    protected int hp;
    protected double x,y,spd,jumpSpd;
    protected double gravity;
    protected double g; //acceleration of gravity
    protected double airTime;
    protected double lastJump, lastShot;
    protected boolean left,right,standing,jumping,shooting;
    protected boolean facingLeft,facingRight;
    //protected List<Projectile> projectiles = new ArrayList<Projectile>();
    protected ImageIcon ii_standLeft,ii_standRight,ii_runLeft,ii_runRight;
    protected Image image_standLeft,image_standRight,image_runLeft,image_runRight;
    
    //Image to blit. Default: image_standRight
    protected Image currentImage;

    public Player() {

	//images
	ii_standLeft = new ImageIcon("Megaman_Stand_Left.gif");
	image_standLeft = ii_standLeft.getImage();
	ii_standRight = new ImageIcon("Megaman_Stand_Right.gif");
	image_standRight = ii_standRight.getImage();
	ii_runLeft = new ImageIcon("Megaman_Run_Left.gif");
	image_runLeft = ii_runLeft.getImage();
	ii_runRight = new ImageIcon("Megaman_Run_Right.gif");
	image_runRight = ii_runRight.getImage();

	//default
	currentImage = image_standRight;

	hp= 100;
	x= 512;
	y= 568;
	airTime = 0.0;
	lastJump= 0.0;
	lastShot= 0.0;
	left=false;right=false;
	
	//defaults
	standing=true;
	jumping=false;
	shooting=false;
	facingRight=true;facingLeft=false; //default right
	
	spd=5.0;
	jumpSpd=0.0;
	g=32;
	gravity=0;
    }

    public void move() {
	//check if standing; default y=568
	if (y >= 568 && !left && !right) {
	    standing = true;
	    if (facingLeft) {
		currentImage = image_standLeft;

	    }
	    if (facingRight) {
		currentImage = image_standRight;
	    }	
	}
	
	if (y < 568) 
	    airTime += 0.02;
	else
	    airTime = 0;
	gravity = 0.5 * g * (airTime*airTime);
	
	//System.out.println(gravity);
	if (jumping) 
	    y -= jumpSpd * airTime;
	y += gravity;


	if (y > 568) {
	    y = 568;
	}

	if (left && x>0) {
	    x-=spd;
	}
	if (right && x<1024) {
	    x+=spd;
	}
	/*jumping. edit.
	if (jumping && isStanding && time-lastShot > 1.0) {
	    y -= gravity*2;
	    isStanding = false;
	    lastJump=time;
	}
	*/
    }

    public void jump(double time) {
	if (!jumping) {
	    lastJump = time;
	}
	else {
	    if (time - lastJump < 0.2) {
		jumpSpd = 20.0;
		airTime += 0.02;
	    }
	    else {
		jumping=false;
	    }
	}
    }

    //size is doubled in paint so nothing is halved
    public int getDXStand() {
	return ii_standLeft.getIconWidth();
    }
    public int getDYStand() {
	return ii_standLeft.getIconHeight();
    }
    public int getDXRun() {
	return ii_runLeft.getIconWidth();
    }
    public int getDYRun() {
	return ii_runLeft.getIconHeight();
    }
    

    public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	if (key == KeyEvent.VK_LEFT){
	    standing=false;
            left=true;
	    facingLeft=true;
	    right=false;
	    facingRight=false;
	    //if (jumping){if (shooting)}
	    //else if (shooting)
	    //else
	    currentImage = image_runLeft;
        }
	if (key == KeyEvent.VK_RIGHT){
	    standing=false;
            right=true;
	    facingRight=true;
	    left=false;
	    facingLeft=false;
	    //if (jumping){if (shooting)}
	    //else if (shooting)
	    //else
	    currentImage = image_runRight;
	}
	if (key == KeyEvent.VK_Z){
	    shooting=true;
	}
	//edit.
	if (key == KeyEvent.VK_SHIFT){
	    if (y >=568) //fix this later
		jumping=true;
	}
    }
    public void keyReleased(KeyEvent e) {
	int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            left=false;
	    //if not in air, standing = true
        }
        if (key == KeyEvent.VK_RIGHT){
            right=false;
	}
	if (key == KeyEvent.VK_Z){
	    shooting=false;
	}
    }
}//end class Player