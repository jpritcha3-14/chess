import java.awt.*;
import java.awt.event.*; 

  
public class ChessGame extends MouseAdapter {
  Board board;
  Player white;
  Player black;  
  
  public static void main(String[] args) {
    ChessGame game = new ChessGame();
  }
  
  private ChessGame() {
    board = new Board();
    white = new Player("white");
    black = new Player("black");
    board.setup();
    board.drawBoard();
    board.addMouseListener(this);
    board.addMouseMotionListener(this);
  }
  
  @Override 
  public void mouseClicked(MouseEvent e) {
    if (board.getBound().contains(e.getX(), e.getY())) {
      System.out.println(board.getBound().toString());
      System.out.println("made it here!!! X: " + e.getX() + " Y: " + e.getY());
      if (board.getActivePiece() == null && board.checkPiece(e.getX(), e.getY()) != null) {
        System.out.println("Took Piece");
        board.takePiece(e.getX(), e.getY());
        board.setActivePiecePos(e.getX() - Square.WIDTH/2, e.getY() - Square.WIDTH/2);
        board.getLegalMoves();
        board.repaint();
      } else if (board.getActivePiece() != null) {
        System.out.println("Placed Piece");
        board.setPiece(e.getX(), e.getY());
        board.setActivePiecePos(e.getX() - Square.WIDTH/2, e.getY() - Square.WIDTH/2);
        board.resetColor();
        board.repaint();
      }  
    }
  }
  
  @Override
  public void mouseMoved(MouseEvent e) {
    if (board.getActivePiece() != null) {
      board.setActivePiecePos(e.getX() - Square.WIDTH/2, e.getY() - Square      .WIDTH/2);
      board.repaint();
    }
  }

}
