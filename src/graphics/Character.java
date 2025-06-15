/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author 344165857
 */
public class Character extends Object{
     public int x, y;
    private PImage[] idleImages;
    private PImage[] walkLeftImages;
    private PImage[] walkRightImages;
    private PApplet app;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    private int count = 0;
    private int direction = 0;  // 0 = idle, -1 = left, 1 = right

    /**
     *
     * @param p
     * @param x
     * @param y
     * @param idlePaths
     * @param walkPaths
     */
    
    public Character(PApplet p, int x, int y, String[] idlePaths, String[][] walkPaths){
        super(x,y);
        this.app = p;
  
        idleImages = new PImage[idlePaths.length];
        for (int i = 0; i < idlePaths.length; i++) {
            idleImages[i] = app.loadImage(idlePaths[i]);
        }

        walkLeftImages = new PImage[walkPaths[0].length];
        for (int i = 0; i < walkPaths[0].length; i++) {
            walkLeftImages[i] = app.loadImage(walkPaths[0][i]);
        }

        walkRightImages = new PImage[walkPaths[1].length];
        for (int i = 0; i < walkPaths[1].length; i++) {
            walkRightImages[i] = app.loadImage(walkPaths[1][i]);
        }
    }
    

    
    public void update(){
        // Check key input for movement
        if (app.keyPressed){
           if (leftPressed) {
            super.move(-5, 0);
            direction = -1;
        } else if (rightPressed) {
            super.move(5, 0);
            direction = 1;
        } else {
        direction = 0;
        }
        } else {
            direction = 0;
        }

        // Increment count every few frames for animation speed
        if (app.frameCount % 8 == 0) {
            count++;
        }
    }


    public void drawCharacter(){
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
    public void keyPressed() {
    if (app.key == 'a' || app.key == 'A') leftPressed = true;
    if (app.key == 'd' || app.key == 'D') rightPressed = true;
    if (app.key == 'w' || app.key == 'W') upPressed = true;
    if (app.key == 's' || app.key == 'S') downPressed = true;
}

public void keyReleased() {
    if (app.key == 'a' || app.key == 'A') leftPressed = false;
    if (app.key == 'd' || app.key == 'D') rightPressed = false;
    if (app.key == 'w' || app.key == 'W') upPressed = false;
    if (app.key == 's' || app.key == 'S') downPressed = false;
}
  
}

