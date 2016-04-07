import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.Graphics;

public abstract class Piece {
  private String color;
  private BufferedImage sprite;   
  private ArrayList<Move[]> legalMoves;
  private int col;
  private int row;

  public Piece(String c, BufferedImage s, int col, int row) {
    color = c;
    sprite = s;
    this.row = row;
    this.col = col;
    legalMoves = new ArrayList<Move[]>();
    Move[] stayInPlace = { new Move(0, 0) };
    legalMoves.add(stayInPlace);
  }
  
  public BufferedImage getSprite() {
    return sprite;
  }  

  public ArrayList<Move[]> getLegalMoves() {
    return legalMoves;
  }
    
  public int getRow() {
    return row;
  } 

  public int getCol() {
    return col;
  } 

  public void setRow(int row) {
    this.row = row;
  }

  public void setCol(int col) {
    this.col = col;
  } 

  public String getColor() {
    return color;
  }

  public Graphics draw(Graphics g, int x, int y) {
    g.drawImage(sprite, x, y, null); 
    return g;
  }
  
}
