import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class King extends Piece {

  public King(String color, int col, int row) {
    super(color, loadSprite(color), col, row);
    addLegalMoves();
  }

private void addLegalMoves() {
  
  ArrayList<Move[]> kingMoves = getLegalMoves();
  Move[] SE = { new Move(1,1) };
  Move[] S  = { new Move(0,1) };
  Move[] SW = { new Move(-1,1) };
  Move[] W  = { new Move(-1,0) };
  Move[] NW = { new Move(-1,-1) };
  Move[] N  = { new Move(0,-1) };
  Move[] NE = { new Move(1,-1) };
  Move[] E  = { new Move(1,0) };

  kingMoves.add(SE);
  kingMoves.add(S);
  kingMoves.add(SW);
  kingMoves.add(W);
  kingMoves.add(NW);
  kingMoves.add(N);
  kingMoves.add(NE);
  kingMoves.add(E);

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
