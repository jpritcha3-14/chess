import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Rook extends Piece {

  public Rook(String color, int col, int row) {
    super(color, loadSprite(color), col, row);
    addLegalMoves();
  }

private void addLegalMoves() {
  Move[] north = new Move[7];
  Move[] south = new Move[7];
  Move[] east = new Move[7];
  Move[] west = new Move[7];

  for (int i = 0; i < north.length; i++) {
    north[i] = new Move(0,i+1);
    south[i] = new Move(0,-i-1);
    east[i] = new Move(i+1,0);
    west[i] = new Move(-i-1,0);
  }

  getLegalMoves().add(north);
  getLegalMoves().add(south);
  getLegalMoves().add(east);
  getLegalMoves().add(west);
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
