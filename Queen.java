import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Queen extends Piece {

  public Queen(String color, int col, int row) {
    super(color, loadSprite(color), col, row);
    addLegalMoves();
  }

private void addLegalMoves() {
  Move[] north = new Move[7];
  Move[] south = new Move[7];
  Move[] east = new Move[7];
  Move[] west = new Move[7];
  Move[] northWest = new Move[7];
  Move[] northEast = new Move[7];
  Move[] southWest = new Move[7];
  Move[] southEast = new Move[7];

  for (int i = 0; i < north.length; i++) {
    north[i] = new Move(0, i+1);
    south[i] = new Move(0, -i-1);
    east[i] = new Move(i+1, 0);
    west[i] = new Move(-i-1, 0);
    northWest[i] = new Move(-i-1, -i-1);
    northEast[i] = new Move(i+1, -i-1);
    southWest[i] = new Move(-i-1, i+1);
    southEast[i] = new Move(i+1, i+1);
  }     

  getLegalMoves().add(north);
  getLegalMoves().add(south);
  getLegalMoves().add(east);
  getLegalMoves().add(west);
  getLegalMoves().add(northWest);
  getLegalMoves().add(northEast);
  getLegalMoves().add(southWest);
  getLegalMoves().add(southEast);
    
  
}

private static BufferedImage loadSprite(String c) {
    try {
      return ImageIO.read(new File("./piece_pictures/" + c + "Queen.png"));
    } catch (IOException e) {
      System.out.println("could not find " + c + "Queen.png"); 
    }
      return null;
  }

}
