import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PositionedImage {

    BufferedImage image;
    int posX, posY;
    int testBoxY, testBoxX;

    public PositionedImage() {
    }

    public PositionedImage(BufferedImage image, int posX, int posY) {
        this.image = image;
        this.posX = posX;
        this.posY = posY;
    }


    public PositionedImage(String filename, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PositionedImage(int testBoxY, int testBoxX) {
        this.testBoxY = testBoxY;
        this.testBoxX = testBoxX;
    }

    public void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, posX * 72, posY * 72, null);
        }
    }
}
