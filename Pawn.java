import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Pawn extends Piece {

  public Pawn(String color, int col, int row) {
    super(color, loadSprite(color), col, row);
    addLegalMoves();
  }

  private void addLegalMoves() {
    if (getColor().equals("black")) {
      Move[] forward = { new Move(0,-1) };
      getLegalMoves().add(forward);
    } else {
      Move[] forward = { new Move(0,1) };
      getLegalMoves().add(forward);
    } 
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
