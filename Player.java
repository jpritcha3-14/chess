import java.util.*;
  
public class Player {
  private String color;
  private ArrayList<Piece> capturedPieces;
  private boolean isTurn;
  
  public Player(String c) {
    color = c;
    capturedPieces = new ArrayList<Piece>();
    isTurn = false; 
  }

  public void takeTurn() {

  } 

  private void capture(Piece p) {

  }  
}
