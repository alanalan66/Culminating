/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import endings.goodEnd;
import processing.core.PApplet;

/**
 * MySketch2 is a simple interactive Processing sketch where the user
 * can click on multiple suns scattered randomly on the screen.
 * Once all suns are clicked (disappear), it triggers the GoodEnd window.
 * 
 *  Alan Liu
 */
public class MySketch2 extends PApplet {

    // Number of suns displayed
    int sunCount = 9;
    
    // Array tracking visibility of each sun (true = visible)
    boolean[] sunVisible;
    
    // Counter for how many suns have been clicked
    int sunsClicked = 0;
    
    // Arrays for sun positions on the screen
    float[] sunX, sunY;
    
    // Radius of each sun
    float sunRadius = 40;

    /**
     * Sets the window size for the sketch.
     */
    @Override
    public void settings() {
        size(600, 400);
    }

    /**
     * Initializes the sketch state:
     * - Sets all suns to visible.
     * - Randomly positions each sun within the window bounds.
     * - Disables stroke for shapes.
     */
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

    /**
     * Continuously called to render the sketch.
     * Draws background, suns that are visible, and the counter text.
     */
    @Override
    public void draw() {
        background(200, 220, 255);  // Light blue background

        fill(255, 100, 0);  // Orange fill for suns

        // Draw each sun if visible
        for (int i = 0; i < sunCount; i++) {
            if (sunVisible[i]) {
                ellipse(sunX[i], sunY[i], sunRadius * 2, sunRadius * 2);
            }
        }

        fill(0);  // Black text color
        textSize(20);
        text("Suns shot: " + sunsClicked + " / " + sunCount, 20, 30);
    }

    /**
     * Called when the mouse is pressed.
     * Checks if the click is within any visible sun's radius.
     * If so, hides that sun and increments click count.
     * When all suns are clicked, shows the goodEnd window and hides this sketch.
     */
    @Override
    public void mousePressed() {
        for (int i = 0; i < sunCount; i++) {
            if (sunVisible[i]) {
                // Calculate distance between mouse click and sun center
                float d = dist(mouseX, mouseY, sunX[i], sunY[i]);
                if (d <= sunRadius) {
                    println("Sun #" + i + " clicked!");
                    sunVisible[i] = false;  // Hide sun
                    sunsClicked++;
                    println("Suns clicked: " + sunsClicked);

                    // If all suns are clicked, show goodEnd and hide this sketch
                    if (sunsClicked == sunCount) {
                        println("All suns clicked! Showing GoodEnd.");
                        new goodEnd().setVisible(true);
                        this.getSurface().setVisible(false);
                    }
                    break;  // Only one sun can be clicked per mouse press
                }
            }
        }
    }
}