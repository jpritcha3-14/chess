import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class King extends Piece {

  public King(String color, int col, int row) {
    super(color, loadSprite(color), col, row);
  }

private static BufferedImage loadSprite(String c) {
    try {
      return ImageIO.read(new File("./piece_pictures/" + c + "King.png"));
    } catch (IOException e) {
      System.out.println("could not find " + c + "King.png"); 
    }
      return null;
  }

}
