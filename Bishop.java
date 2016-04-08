import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Bishop extends Piece {

public Bishop(String color, int col, int row) {
  super(color, loadSprite(color), col, row);
  addLegalMoves();
}

private void addLegalMoves() {
  Move[] northWest = new Move[7]; 
  Move[] northEast = new Move[7]; 
  Move[] southWest = new Move[7]; 
  Move[] southEast = new Move[7]; 

  for (int i = 0; i < northWest.length; i++) {
    northWest[i] = new Move(-i-1,-i-1);
    northEast[i] = new Move(i+1,-i-1);
    southWest[i] = new Move(-i-1,i+1);
    southEast[i] = new Move(i+1,i+1);
  }

  getLegalMoves().add(northWest);
  getLegalMoves().add(northEast);
  getLegalMoves().add(southWest);
  getLegalMoves().add(southEast);
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
