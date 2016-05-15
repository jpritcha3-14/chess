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
  private Font font;
  private Color playerColor;
  JFrame frame;
  
  public Board() {
    font = new Font("SansSerif", Font.BOLD, 24);
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

  // returns true if piece was moved to a different location
  public boolean setPiece(int x, int y) {
    boolean moved = false;
    for (Square[] c : squares) {
      for (Square sq : c) {
        if (sq.contains(x, y)) { 
          moved = (sq.getRow() != activePiece.getRow() || sq.getCol() != activePiece.getCol());  
          if (moved) {
            activePiece.hasMoved();
          }
          sq.setPiece(activePiece); 
          activePiece = null;
        }
      }
    }
    return moved;
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

  public boolean hasActivePiece() {
    return (activePiece != null) ? true : false;
  }

  public boolean squareIsLegal( int x, int y ) {
    Color squareColor = findSquare(x,y).getColor(); 
    if (squareColor == Color.GREEN || squareColor == Color.RED) {
      return true;
    }
    return false;
  }

  public Square findSquare(int x, int y) {
    for (Square[] c : squares) {
      for (Square sq : c) {
        if (sq.contains(x, y)) { 
          return sq;
        }
      }
    }
    return null;
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

  /*  Uses the active piece's move set and the current state of the board to draw
   *  the legal moves for the selected piece.
   */
  public void drawLegalMoves() {
    ArrayList<Move[]> possibleMoves = activePiece.getLegalMoves(); 
    ArrayList<Move[]> captureMoves;
    int deltaCol;
    int deltaRow;
    int newCol;
    int newRow;
    if (activePiece.isFirstMove() && !(activePiece.getLegalFirstMoves().isEmpty())) {
      possibleMoves = activePiece.getLegalFirstMoves();  
    }
    if (activePiece instanceof Pawn) {
      captureMoves = ((Pawn) activePiece).getCaptureMoves();
      for (int i = 0; i < captureMoves.size(); i++) {
        for(int j = 0; j < captureMoves.get(i).length; j++) {

          deltaCol = captureMoves.get(i)[j].getCol();
          deltaRow = captureMoves.get(i)[j].getRow();
          newCol = activePiece.getCol() + deltaCol;
          newRow = activePiece.getRow() + deltaRow;
          if (withinBounds(newCol, newRow) && !noPiece(newCol, newRow) && squares[newCol][newRow].getPiece().getColor() != activePiece.getColor()) {
            squares[newCol][newRow].changeColor(Color.RED); 
          }  
        }
      } 
    }
    for (int i = 0; i < possibleMoves.size(); i++) {
      for(int j = 0; j < possibleMoves.get(i).length; j++) {
        deltaCol = possibleMoves.get(i)[j].getCol();
        deltaRow = possibleMoves.get(i)[j].getRow();
        newCol = activePiece.getCol() + deltaCol;
        newRow = activePiece.getRow() + deltaRow;
        if (withinBounds(newCol, newRow)) {
          if (noPiece(newCol, newRow)) {
            squares[newCol][newRow].changeColor(Color.GREEN); 
          } else {
            if (squares[newCol][newRow].getPiece().getColor() != activePiece.getColor() && !(activePiece instanceof Pawn)) {
              squares[newCol][newRow].changeColor(Color.RED); 
            }
            break;
          }
        }
      }
    }
  }  
  
  // helper function for drawLegalMoves
  private boolean withinBounds(int col, int row) {
    return (col >= 0) && (col < 8) && (row >= 0) && (row < 8);
  }

  // helper function for drawLegalMoves
  private boolean noPiece(int col, int row) {
    if (squares[col][row].getPiece() == null) {
      return true;
    } else {
      return false;
    }
  }

  public void drawBoard() {
    frame.setVisible(true);
    repaint();
  }

  // Resets the square colors of the board
  public void resetColor() {
    for (int col = 0; col < squares.length; col++) {
      for (int row = 0; row < squares[0].length; row++) {
        squares[col][row].determineColor(); 
      }
    }
  }

  public void setPlayerColor(Color c) {
    playerColor = c;
  }

  @Override
  public void paintComponent(Graphics g) {
    g.setFont(font);
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0,0, frame.getWidth(), frame.getHeight());
    g.setColor(playerColor);

    String player = (playerColor == Color.WHITE) ? "White" : "Black";
    g.drawString(player + "'s Turn", frame.getWidth()/2 - Square.WIDTH, Square.WIDTH/2);

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
