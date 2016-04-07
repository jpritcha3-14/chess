import java.util.*;
  
public class Player {
  private String color;
  private ArrayList<Piece> capturedPieces;
  private PieceStatus activePiece;
  private boolean isTurn;
  
  public Player(String c) {
    color = c;
    capturedPieces = new ArrayList<Piece>();
    activePiece = null;
    isTurn = false; 
  }

  public void takeTurn() {

  } 

  public PieceStatus getActivePiece() {
    return activePiece;
  } 
  
  public void pickUp(PieceStatus p) {
    activePiece = p; 
  }

  public PieceStatus place() {
    PieceStatus returnedPiece = activePiece;
    activePiece = null;
    return returnedPiece;
  }
  
  private void capture(Piece p) {

  }  
}
