import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.Color;

public class Player extends JPanel {
    //workaround: follow mouse
    protected int x_cor;
    protected int y_cor;
    protected int speed;
    protected int dx = 0;
    protected int dy = 0;
    private int width;
    private int height;
    private Color color;
    
    public Player() {
	this.setVisible(true);
    }

    public Player(int x_cor, int y_cor, int speed, int width, int height, Color color) {
	this.x_cor = x_cor;
	this.y_cor = y_cor;
	this.speed = speed;
	this.width = width;
	this.height = height;
	this.color = color;
    }

    public Color getColor() {
	return color;
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

}