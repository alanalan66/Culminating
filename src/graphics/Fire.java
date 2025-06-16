/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Fire represents a falling fire hazard object in the game.
 * It animates through multiple fire images and respawns at a random horizontal
 * position when it falls off the bottom of the screen.
 * Inherits position and move functionality from the Object class.
 * 
 * @author 344165857, Alan Liu
 */
public class Fire extends Object {

    // Array of fire images for animation
    private PImage[] fireImage;

    // Reference to the Processing sketch
    private PApplet app;

    // Frame counter for image animation cSycling
    private static int count = 0;

    // The frame number at which this fire should start falling
    private  int startFrame;

    /**
     * Constructor to create a new Fire object.
     * 
     * @param p           Reference to the main Processing sketch.
     * @param x           Initial x-coordinate.
     * @param y           Initial y-coordinate.
     * @param fire        Array of file paths to fire images.
     * @param startFrame  The frame number at which the fire should start falling.
     */
    public Fire(PApplet p, int x, int y, String[] fire, int startFrame) {
        super(x, y);
        this.app = p;
        this.startFrame = startFrame;

        // Load fire images from file paths
        fireImage = new PImage[fire.length];
        for (int i = 0; i < fire.length; i++) {
            fireImage[i] = app.loadImage(fire[i]);
        }
    }

    /**
     * Draws the fire on the screen and handles its falling movement and animation.
     * If the fire moves off the bottom of the screen, it resets to a random x-position
     * at the top.
     */
    @Override
    public void draw() {
        // Only start displaying after the designated start frame
        if (app.frameCount >= startFrame) {
            // Get the current image based on frame count for animation
            PImage currentImage = fireImage[count % fireImage.length];
            app.image(currentImage, super.x, super.y);

            // Update animation frame every 8 frames
            if (app.frameCount % 8 == 0) {
                count++;
            }

            // Move the fire downward
            super.move(0, 3);

            // Reset fire to top of screen at random x if it goes off screen
            if (super.y > app.height) {
                super.y = 0;
                super.x = (int) app.random(50, app.width - currentImage.width);
            }
        }
    }

    /**
     * Returns the current image being used for the fire's animation.
     * 
     * @return The current PImage for the fire.
     */
    public PImage getCurrentImage() {
        return fireImage[count % fireImage.length];
    }
}