import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Knight extends Piece {

  public Knight(String color, int col, int row) {
    super(color, loadSprite(color), col, row);
  }

private static BufferedImage loadSprite(String c) {
    try {
      return ImageIO.read(new File("./piece_pictures/" + c + "Knight.png"));
    } catch (IOException e) {
      System.out.println("could not find " + c + "Knight.png"); 
    }
      return null;
  }

}
