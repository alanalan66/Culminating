/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

/**
 *
 * @author 344165857
 */
import processing.core.PApplet;
import processing.core.PImage;

public class Object {
    public int x, y;
    private PImage[] idleImages;
    private PImage[] walkLeftImages;
    private PImage[] walkRightImages;
    private PImage[] firee;
    private PApplet app;

    private int count = 0;
    private int direction = 0;  // 0 = idle, -1 = left, 1 = right

    public Object(PApplet p, int x, int y, String[] idlePaths, String[][] walkPaths){
        this.app = p;
        this.x = x;
        this.y = y;

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

    public Object(PApplet p, int x, int y, String[]fire){
        this.app = p;
        this.x = x;
        this.y = y;

        firee = new PImage[fire.length];
        for (int i = 0; i < fire.length; i++) {
            firee[i] = app.loadImage(fire[i]);
        }

    }

    
    public void update(){
        // Check key input for movement
        if (app.keyPressed){
            if (app.keyCode == app.LEFT) {
                move(-5, 0);
                direction = -1;
            } else if (app.keyCode == app.RIGHT) {
                move(5, 0);
                direction = 1;
            } else if (app.keyCode == app.UP) {
                move(0, -5);
            } else if (app.keyCode == app.DOWN) {
                move(0, 5);
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

    public void move (int dx, int dy){
        x += dx;
        y += dy;
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

        app.image(currentImage, x, y);
    }
    
    
    public void drawFire(){
        PImage currentImage;
            currentImage = firee[count % firee.length];
            app.image(currentImage, x, y);
     
        if (app.frameCount % 8 == 0) {
            count++;
    }
        
        move(0, 3);
    }
}