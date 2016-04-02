import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Bishop extends Piece {

  public Bishop(String color) {
    super(color, loadSprite(color));
  }

private static BufferedImage loadSprite(String c) {
    try {
      return ImageIO.read(new File("./piece_pictures/" + c + "Bishop.png"));
    } catch (IOException e) {
      System.out.println("could not find " + c + "Bishop.png"); 
    }
      return null;
  }

}
