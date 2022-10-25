import java.awt.*;
import java.io.File;

public class PhotoMagic {

    public static Picture transform(Picture pic, LFSR lfsr) {

        Picture finalPic = new Picture(pic.width(), pic.height());

        for (int row = 0; row < pic.width(); row++) {
            for (int col = 0; col < pic.height(); col++) {
                Color c = pic.get(row, col);
                int newRed = lfsr.generate(8)^c.getRed();
                int newGreen = lfsr.generate(8)^c.getGreen();
                int newBlue = lfsr.generate(8)^c.getBlue();

                finalPic.set(row, col, new Color(newRed, newGreen, newBlue));
            }
        }
        return finalPic;
    }

    public static void main(String[] args) {
        Picture picture = new Picture("photomagic2.png");
        LFSR lfsr = new LFSR("01101000010100010000", 16);
        transform(picture, lfsr).show();

    }
}
