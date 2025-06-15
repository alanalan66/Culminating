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
public class Fire extends Object{
       public int x, y;
       private PImage[] fireImage;
       private PApplet app;
       private int count = 0;
       private int startFrame;




    public Fire(PApplet p, int x, int y, String[] fire, int startFrame) {
    super(x, y);
    this.app = p;
    this.startFrame = startFrame;

    fireImage = new PImage[fire.length];
    for (int i = 0; i < fire.length; i++) {
        fireImage[i] = app.loadImage(fire[i]);
    }
}

    


    
public void drawFire() {
    if (app.frameCount >= startFrame) {
        PImage currentImage = fireImage[count % fireImage.length];
        app.image(currentImage, super.x, super.y);

        if (app.frameCount % 8 == 0) {
            count++;
        }

        super.move(0, 3);  // fall down

        // If fire moves off screen, respawn at random x and top y = 0
        if (super.y > app.height) {
            super.y = 0;
            super.x = (int) app.random(50, app.width - currentImage.width);
        }
    }
}
}