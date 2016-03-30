import java.awt.Color;
import java.awt.Graphics;

public class Square {

  public static final int WIDTH = 75;
  private Color color;
  private Piece piece;
  int row;
  int col;

  public Square(int row, int col) {
    this.row = row;
    this.col = col;
    determineColor();
    piece = null;
  }
  
  public Square(int row, int col, Piece p) {
    this(row, col);
    piece = p; 
  }
  
  public Graphics draw(Graphics g) {
    g.setColor(color);
    g.fillRect(WIDTH + col*WIDTH, WIDTH + row*WIDTH, WIDTH, WIDTH);     
    return g; 
  }
  
  public void setPiece(Piece p) {
    piece = p;
  }
  
  private void determineColor() {
    if ((row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 == 1)) {
      color = color.BLACK;  
    } else {
      color = color.WHITE;
    }    
  }
  

}
