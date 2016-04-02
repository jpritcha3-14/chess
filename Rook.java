import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Rook extends Piece {

  public Rook(String color) {
    super(color, loadSprite(color));
  }

private static BufferedImage loadSprite(String c) {
    try {
      return ImageIO.read(new File("./piece_pictures/" + c + "Rook.png"));
    } catch (IOException e) {
      System.out.println("could not find " + c + "Rook.png"); 
    }
      return null;
  }

}
