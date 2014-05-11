import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RectBullet extends JPanel {
    
    protected int x_cor;
    protected int y_cor;
    private int width;
    private Color color;

    private long spawntime;
    private long lifespan;

    protected static int delay = 100;

    public RectBullet() {
	this.setVisible(true);
    }

    public RectBullet(int x_cor, int y_cor, Color color, long spawntime, long lifespan ) {
	this.setVisible(true);
	this.x_cor = x_cor;
	this.y_cor = y_cor;
	this.width = 6; //change this!
	this.color = color;
	this.spawntime = spawntime;
	this.lifespan = lifespan;
	
    }
    
    public long getLifespan() {
	return lifespan;
    }

    public long getSpawntime() {
	return spawntime;
    }

    public Color getColor() {
	return color;
    }

    public int getWidth() {
	return width;
    }

    public void spawn(Graphics g) {
	g.setColor(getColor());
	g.drawRect(x_cor, y_cor, getWidth(), getWidth());
	x_cor += 6;
    }
}