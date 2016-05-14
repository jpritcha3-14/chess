import java.awt.*;
import java.util.*;
  
public class Player {
  private String color;
  private ArrayList<Piece> capturedPieces;
  
  public Player(String c) {
    color = c;
    capturedPieces = new ArrayList<Piece>();
  }

  private void capture(Piece p) {

  }  

  public String getColor() {
    return color;
  }
}
