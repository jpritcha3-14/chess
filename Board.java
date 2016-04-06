import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Board extends JPanel { 
  private Square[][] squares; 
  private Piece activePiece;
  private int active_x;
  private int active_y;
  JFrame frame;
  
  public Board() {
    squares = new Square[8][8];
    for (int col = 0; col < squares.length; col++) {
      for (int row = 0; row < squares[0].length; row++) {
        squares[col][row] = new Square(row, col);
      }
    }
    
    activePiece = null;
    active_x = 110;
    active_y = 110;
    
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

  public PieceStatus getPiece(int x, int y) {
    for (Square[] c : squares) {
      for (Square sq : c) {
        if (sq.contains(x, y)) { 
          activePiece = sq.takePiece();
          return new PieceStatus(activePiece, sq.getCol(), sq.getRow()); 
        }
      }
    }
    return null;
  }

  public void setPiece(PieceStatus p, int x, int y) {
    for (Square[] c : squares) {
      for (Square sq : c) {
        if (sq.contains(x, y)) { 
          sq.setPiece(p.getPiece()); 
          activePiece = null;
        }
      }
    }
  }
  
  public void setActivePiece(Piece p) {
    activePiece = p;
  }
  
  public void setActivePiecePos(int x, int y) {
    active_x = x;
    active_y = y;  
  }

  public Piece getActivePiece() {
    return activePiece;
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
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0,0, frame.getWidth(), frame.getHeight());
    for (int col = 0; col < squares.length; col++) {
      for (int row = 0; row < squares[0].length; row++) {
        g = squares[col][row].draw(g);
      }
    }
    if (activePiece != null) {
      g = activePiece.draw(g, active_x, active_y);
    }
  }

}
