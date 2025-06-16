/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;
import endings.goodEnd;
import processing.core.PApplet;

public class MySketch2 extends PApplet {

    int sunCount = 9;
    boolean[] sunVisible;
    int sunsClicked = 0;
    float[] sunX, sunY;
    float sunRadius = 40;


    @Override
    public void settings() {
        size(600, 400);
    }

    @Override
 public void setup() {
     sunVisible = new boolean[sunCount];
     sunX = new float[sunCount];
     sunY = new float[sunCount];

     for (int i = 0; i < sunCount; i++) {
         sunVisible[i] = true;
         sunX[i] = random(sunRadius, width - sunRadius);
         sunY[i] = random(sunRadius, height - sunRadius);
     }
     noStroke();
 }

    @Override
    public void draw() {
        background(200, 220, 255);
        fill(255, 100, 0);

        for (int i = 0; i < sunCount; i++) {
            if (sunVisible[i]) {
                ellipse(sunX[i], sunY[i], sunRadius * 2, sunRadius * 2);
            }
        }

        fill(0);
        textSize(20);
        text("Suns shot: " + sunsClicked + " / " + sunCount, 20, 30);
    }

    @Override
    public void mousePressed() {
        for (int i = 0; i < sunCount; i++) {
            if (sunVisible[i]) {
                float d = dist(mouseX, mouseY, sunX[i], sunY[i]);
                if (d <= sunRadius) {
                    println("Sun #" + i + " clicked!");
                    sunVisible[i] = false;
                    sunsClicked++;
                    println("Suns clicked: " + sunsClicked);
                    if (sunsClicked == sunCount) {
                        println("All suns clicked! Showing GoodEnd.");
                        new goodEnd().setVisible(true);
                        this.getSurface().setVisible(false);
                    }
                    break;
                }
            }
        }
    }
}