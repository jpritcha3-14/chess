import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Pawn extends Piece {

  private ArrayList<Move[]> captureMoves;

  public Pawn(String color, int col, int row) {
    super(color, loadSprite(color), col, row);
    captureMoves = new ArrayList<Move[]>();
    addLegalMoves();
  }

  private void addLegalMoves() {
    if (getColor().equals("black")) {
      Move[] forward = { new Move(0,-1) };
      getLegalMoves().add(forward);
      Move[] forward2 = { new Move(0,0), new Move(0,-1), new Move(0,-2) };
      getLegalFirstMoves().add(forward2);
      Move[] capture1 = { new Move(-1,-1) };
      Move[] capture2 = { new Move(1,-1) };
      captureMoves.add(capture1);
      captureMoves.add(capture2);
    } else {
      Move[] forward = { new Move(0,1) };
      getLegalMoves().add(forward);
      Move[] forward2 = { new Move(0,0), new Move(0,1), new Move(0,2) };
      getLegalFirstMoves().add(forward2);
      Move[] capture1 = { new Move(-1,1) };
      Move[] capture2 = { new Move(1,1) };
      captureMoves.add(capture1);
      captureMoves.add(capture2);
    } 
  }      

  public ArrayList<Move[]> getCaptureMoves() {
    return captureMoves;
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
