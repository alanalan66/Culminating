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



    public Fire(PApplet p, int x, int y, String[]fire){
      super(x, y);
       this.app = p;



        fireImage = new PImage[fire.length];
        for (int i = 0; i < fire.length; i++) {
            fireImage[i] = app.loadImage(fire[i]);
        }

    }

    


    
    public void drawFire(){
        PImage currentImage;
            currentImage = fireImage[count % fireImage.length];
            app.image(currentImage, super.x, super.y);
     
        if (app.frameCount % 8 == 0) {
            count++;
    }
        
        super.move(0, 3);
    }
    
    
}
