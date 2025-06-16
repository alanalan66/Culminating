/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

/**
 * Object is a base class representing a general game entity with a position (x, y)
 * and an optional reference to the PApplet sketch for rendering.
 * 
 * @author 344165857
 */
import processing.core.PApplet;
import processing.core.PImage;

public class Object {

    // X and Y position of the object
    public int x, y;

    // Optional array of images for the object's appearance
    public PImage[] Images;

    // Reference to the main Processing sketch
    public PApplet app;

    /**
     * Constructor to create an Object with specified position.
     *
     * @param x The x-coordinate of the object.
     * @param y The y-coordinate of the object.
     */
    public Object(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor to create an Object with a reference to the Processing app
     * and specified position.
     *
     * @param p  Reference to the Processing PApplet.
     * @param x  The x-coordinate of the object.
     * @param y  The y-coordinate of the object.
     */
    public Object(PApplet p, int x, int y) {
        this.app = p;
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the current x-coordinate.
     *
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the current y-coordinate.
     *
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the reference to the PApplet.
     *
     * @return The PApplet instance.
     */
    public PApplet getApp() {
        return app;
    }

    /**
     * Moves the object by a given amount in both x and y directions.
     *
     * @param dx Change in x-coordinate.
     * @param dy Change in y-coordinate.
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Sets the x-coordinate.
     *
     * @param x New x-coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate.
     *
     * @param y New y-coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the reference to the PApplet.
     *
     * @param app The PApplet instance.
     */
    public void setApp(PApplet app) {
        this.app = app;
    }
    
    
        public void draw() {
    }
}