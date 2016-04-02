import java.awt.*;
import javax.swing.*;


public class Board extends JPanel { 
  private Square[][] squares; 
  JFrame frame;
  
  public Board() {
    squares = new Square[8][8];
    for (int col = 0; col < squares.length; col++) {
      for (int row = 0; row < squares[0].length; row++) {
        squares[col][row] = new Square(row, col);
      }
    }
    
    frame = new JFrame("Java Chess");
    this.setFocusable(true);
    frame.getContentPane().add(this);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(10*Square.WIDTH, 10*Square.WIDTH);
  }

  public void setup() {
    String color = "white";
    Piece p = null; 
    for (int col = 0; col < squares.length; col++) {
      for (int row = 0; row < squares[0].length; row++) {
        p = null;
        color = (row < 2) ? "white" : "black";
        if (row == 0 || row == 7) { p = determinePiece(col, color); }
        if (row == 1 || row == 6) { p = new Pawn(color); }
        squares[col][row].setPiece(p); 
        }
      }
    }
    
  private Piece determinePiece(int col, String color) {
    if (col == 0 || col == 7) {
      return new Rook(color); 
    } else if (col == 1 || col == 6) {
      return new Knight(color);
    } else if (col == 2 || col == 5) {
      return new Bishop(color);
    } else if (col == 4) {
      return new Queen(color);
    } else {
      return new King(color);
    }   
  } 

  public void drawBoard() {
    frame.setVisible(true);
    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    for (int col = 0; col < squares.length; col++) {
      for (int row = 0; row < squares[0].length; row++) {
        g = squares[col][row].draw(g);
      }
    }
  }

}
