import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Knight extends Piece {

  public Knight(String color, int col, int row) {
    super(color, loadSprite(color), col, row);
    addLegalMoves();
  }

  private void addLegalMoves() {
    Move[] SE1 = { new Move(1,2) };
    Move[] SE2 = { new Move(2,1) };
    Move[] NE1 = { new Move(-1,2) };
    Move[] NE2 = { new Move(-2,1) };
    Move[] NW1 = { new Move(-1,-2) };
    Move[] NW2 = { new Move(-2,-1) };
    Move[] SW1 = { new Move(1,-2) };
    Move[] SW2 = { new Move(2,-1) };

    getLegalMoves().add(SE1);
    getLegalMoves().add(SE2);
    getLegalMoves().add(NE1);
    getLegalMoves().add(NE2);
    getLegalMoves().add(NW1);
    getLegalMoves().add(NW2);
    getLegalMoves().add(SW1);
    getLegalMoves().add(SW2);
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
