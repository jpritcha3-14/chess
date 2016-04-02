import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Pawn extends Piece {

  public Pawn(String color) {
    super(color, loadSprite(color));
  }

private static BufferedImage loadSprite(String c) {
    try {
      return ImageIO.read(new File("./piece_pictures/" + c + "Pawn.png"));
    } catch (IOException e) {
      System.out.println("could not find " + c + "Pawn.png"); 
    }
      return null;
  }

}
