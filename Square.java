import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Square extends Rectangle {

  public static final int WIDTH = 75;
  private Color color;
  private Piece piece;
  private int row;
  private int col;

  public Square(int row, int col) {
    super(WIDTH, WIDTH);
    setLocation(WIDTH + col*WIDTH, WIDTH + row*WIDTH);
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
    g.fillRect(x, y, WIDTH, WIDTH);     
    if (piece != null) {
      g.drawImage(piece.getSprite(), WIDTH + col*WIDTH, WIDTH + row*WIDTH, null);
    }
    return g; 
  }
  
  public void setPiece(Piece p) {
    piece = p;
    if (piece != null) {
      piece.setRow(row);
      piece.setCol(col);
    } 
  }
  
  public Piece getPiece() {
    return piece; 
  }
  
  public Piece takePiece() {
    Piece returnedPiece = piece;
    piece = null;
    return returnedPiece; 
  }
  
  public int getCol() {
    return col; 
  }

  public int getRow() {
    return row; 
  }

  public void changeColor(Color c) {
    color = c;
  }
  
  public void determineColor() {
    if ((row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 == 1)) {
      color = Color.GRAY;  
    } else {
      color = Color.WHITE;
    }    
  }
  

}
