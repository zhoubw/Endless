import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame{
    //protected TitleScreen current;
    protected GameControl gc;
    
    //Constructor
    public Window(){
	int width = 1024, height = 768;
	//TO DO: make a panel in TITLE MODE
	///////////////////////////////////
	//panel in GAME MODE.
	//set default close
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(width,height);
	//centers window
	setLocationRelativeTo(null);
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
