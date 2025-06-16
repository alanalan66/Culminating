/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;



/**
 * Character represents a controllable player character in the game.
 * It supports idle and walking animations, directional movement via key inputs,
 * and collision detection with Fire objects.
 * Inherits position and move functionality from the Object class.
 * 
 * @author 344165857, Alan Liu
 */
import processing.core.PApplet;
import processing.core.PImage;

public class Character extends Object {

    // Animation image arrays for idle, walking left, and walking right
    private PImage[] idleImages;
    private PImage[] walkLeftImages;
    private PImage[] walkRightImages;

    // Reference to the main Processing sketch
    private PApplet app;

    // Boolean flags for keypress states
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    // Animation frame counter
    private int count = 0;

    // Direction flag: 0 = idle, -1 = left, 1 = right
    private int direction = 0;

    /**
     * Constructs a Character object with animations and initial position.
     *
     * @param p          Reference to the Processing sketch.
     * @param x          Initial x-coordinate of the character.
     * @param y          Initial y-coordinate of the character.
     * @param idlePaths  Array of file paths for idle images.
     * @param walkPaths  2D array of file paths for walking animations 
     *                   [0] = left walk images, [1] = right walk images.
     */
    public Character(PApplet p, int x, int y, String[] idlePaths, String[][] walkPaths) {
        super(x, y);
        this.app = p;

        // Load idle images
        idleImages = new PImage[idlePaths.length];
        for (int i = 0; i < idlePaths.length; i++) {
            idleImages[i] = app.loadImage(idlePaths[i]);
        }

        // Load walking left images
        walkLeftImages = new PImage[walkPaths[0].length];
        for (int i = 0; i < walkPaths[0].length; i++) {
            walkLeftImages[i] = app.loadImage(walkPaths[0][i]);
        }

        // Load walking right images
        walkRightImages = new PImage[walkPaths[1].length];
        for (int i = 0; i < walkPaths[1].length; i++) {
            walkRightImages[i] = app.loadImage(walkPaths[1][i]);
        }
    }

    /**
     * Updates the character's position and direction based on key states.
     * Advances the animation frame counter every 8 frames.
     */
    public void update() {
        if (leftPressed) {
            super.move(-5, 0);
            direction = -1;
        }
        if (rightPressed) {
            super.move(5, 0);
            direction = 1;
        }


        if (!leftPressed && !rightPressed) {
            direction = 0;
        }

        if (app.frameCount % 8 == 0) {
            count++;
        }
    }

    /**
     * Draws the character on the screen using the appropriate image
     * based on the current direction and animation frame.
     */
    @Override
    public void draw() {
        PImage currentImage;
        if (direction == -1) {
            currentImage = walkLeftImages[count % walkLeftImages.length];
        } else if (direction == 1) {
            currentImage = walkRightImages[count % walkRightImages.length];
        } else {
            currentImage = idleImages[count % idleImages.length];
        }
        app.image(currentImage, super.x, super.y);
    }

    /**
     * Updates movement key state when a key is pressed.
     */
    public void keyPressed() {
        if (app.key == 'a' || app.key == 'A') leftPressed = true;
        if (app.key == 'd' || app.key == 'D') rightPressed = true;

    }

    /**
     * Updates movement key state when a key is released.
     */
    public void keyReleased() {
        if (app.key == 'a' || app.key == 'A') leftPressed = false;
        if (app.key == 'd' || app.key == 'D') rightPressed = false;

    }

    /**
     * Checks for a bounding-box collision with a given Fire object.
     *
     * @param other  The Fire object to check collision with.
     * @return       True if the character and fire are overlapping; false otherwise.
     */
    public boolean isCollidingWith(Fire other) {
        // Get character image dimensions
        PImage currentImage = idleImages[0];
        int charWidth = currentImage.width;
        int charHeight = currentImage.height;

        // Get fire image dimensions
        PImage fireImage = other.getCurrentImage();
        int fireWidth = fireImage.width;
        int fireHeight = fireImage.height;

        // Bounding box collision detection
        boolean isLeftOfOtherRight = this.x + charWidth > other.x;
        boolean isRightOfOtherLeft = this.x < other.x + fireWidth;
        boolean isAboveOtherBottom = this.y + charHeight > other.y;
        boolean isBelowOtherTop = this.y < other.y + fireHeight;

        return isLeftOfOtherRight && isRightOfOtherLeft && isAboveOtherBottom && isBelowOtherTop;
    }

    /**
     * Returns the current image being used to draw the character
     * based on its direction and animation frame.
     *
     * @return The current PImage for the character.
     */
    public PImage getCurrentImage() {
      if (direction == -1) {
            return walkLeftImages[count % walkLeftImages.length];
        } else if (direction == 1) {
            return walkRightImages[count % walkRightImages.length];
        } else {
            return idleImages[count % idleImages.length];
        }
    }
}