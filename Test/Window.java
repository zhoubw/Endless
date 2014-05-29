import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main window
 * 
 * Includes main methods
 **/

public class Window extends JFrame{
    //protected TitleScreen current;

    //Adds the game onto the window
    protected GameControl gc;
    
    //Constructor
    public Window(){
	//Window width and height
	int width = 1040, height = 768;
	//TO DO: make a panel in TITLE MODE
	///////////////////////////////////
	//panel in GAME MODE.

	//Logistic stuff...
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(width,height);
	//centers window
	setLocationRelativeTo(null);

	//Title - Fix this later
	setTitle("Test");
	setResizable(false);
	setVisible(true);	
    }
    
    /**
     *add TitleScreen
     *
     public void addPanel(){
	current = new TitleScreen();
	
	current.setFrame(this);
	add(current);
	current.repaint();
	this.validate();
	current.requestFocusInWindow();
    }
    */

    //Put everything in one place
    public void addGameControl(GameControl gc){
	this.gc=gc;
	this.add(gc);
	this.validate();
	gc.repaint();
	gc.requestFocusInWindow();
    }
    
    public static void main(String[] args){
	Window w = new Window();
	//w.addPanel();
	w.addGameControl(new GameControl());
    }
}
