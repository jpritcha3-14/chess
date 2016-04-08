import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Board extends JPanel { 
  private Square[][] squares; 
  private Rectangle bound;
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
    
    bound = new Rectangle(75, 75, 600, 600);
    activePiece = null;
    active_x = 0;
    active_y = 0;
    
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
        if (row == 0 || row == 7) { p = determinePiece(color, col, row); }
        if (row == 1 || row == 6) { p = new Pawn(color, col, row); }
        squares[col][row].setPiece(p); 
      }
    }
  }

  public Piece checkPiece(int x, int y) {
    for (Square[] c : squares) {
      for (Square sq : c) {
        if (sq.contains(x, y)) { 
          return sq.getPiece();
        }
      }
    }
    return null;
  }

  public void takePiece(int x, int y) {
    for (Square[] c : squares) {
      for (Square sq : c) {
        if (sq.contains(x, y) && sq.getPiece() != null) { 
          activePiece = sq.takePiece();
        }
      }
    }
  }

  public void setPiece(int x, int y) {
    for (Square[] c : squares) {
      for (Square sq : c) {
        if (sq.contains(x, y)) { 
          sq.setPiece(activePiece); 
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

  public Rectangle getBound() {
    return bound;
  }
  public Piece getActivePiece() {
    return activePiece;
  }

  private Piece determinePiece(String color, int col, int row) {
    if (col == 0 || col == 7) {
      return new Rook(color, col, row); 
    } else if (col == 1 || col == 6) {
      return new Knight(color, col, row);
    } else if (col == 2 || col == 5) {
      return new Bishop(color, col, row);
    } else if (col == 4) {
      return new Queen(color, col, row);
    } else {
      return new King(color, col, row);
    }   
  } 

  public void getLegalMoves() {
    ArrayList<Move[]> possibleMoves = activePiece.getLegalMoves();
    int deltaCol;
    int deltaRow;
    int newCol;
    int newRow;
    for (int i = 0; i < possibleMoves.size(); i++) {
      for(int j = 0; j < possibleMoves.get(i).length; j++) {
        deltaCol = possibleMoves.get(i)[j].getCol();
        deltaRow = possibleMoves.get(i)[j].getRow();
        newCol = activePiece.getCol() + deltaCol;
        newRow = activePiece.getRow() + deltaRow;
        if (withinBounds(newCol, newRow)) {
          squares[newCol][newRow].changeColor(Color.GREEN); 
        }
      }
    }
  }  
  
  private boolean withinBounds(int col, int row) {
    return (col >= 0) && (col < 8) && (row >= 0) && (row < 8);
  }

  public void drawBoard() {
    frame.setVisible(true);
    repaint();
  }

  public void resetColor() {
    for (int col = 0; col < squares.length; col++) {
      for (int row = 0; row < squares[0].length; row++) {
        squares[col][row].determineColor(); 
      }
    }
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
