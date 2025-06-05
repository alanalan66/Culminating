/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 344165857
 */
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;
    import java.util.ArrayList;
    import javax.imageio.ImageIO;

    public class imageCycler {
        private ArrayList<BufferedImage> images;
        private int currentImageIndex;

        public imageCycler(String[] imagePaths) throws IOException {
            images = new ArrayList<>();
            for (String path : imagePaths) {
                images.add(ImageIO.read(new File(path)));
            }
            currentImageIndex = 0;
        }
        // Method to get the current image.
        public BufferedImage getCurrentImage() {
            return images.get(currentImageIndex);
        }

        // Method to move to next image
        public void nextImage() {
            currentImageIndex = (currentImageIndex + 1) % images.size();
        }
    }

