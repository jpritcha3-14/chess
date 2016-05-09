import java.awt.*;
import java.awt.event.*; 
  
public class ChessGame extends MouseAdapter {

  // The chess game has a board and two platers
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

    // setup, draw, and add event listeners to the board
    board.setup();
    board.drawBoard();
    board.addMouseListener(this);
    board.addMouseMotionListener(this);
  }
  
  @Override 
  public void mouseClicked(MouseEvent e) {
    if (board.getBound().contains(e.getX(), e.getY())) {
      // Click was inside board

      if (!board.hasActivePiece() && board.checkPiece(e.getX(), e.getY()) != null) {
        // No piece selected and click was on a square contining a piece

        board.takePiece(e.getX(), e.getY());
        board.setActivePiecePos(e.getX() - Square.WIDTH/2, e.getY() - Square.WIDTH/2);
        board.drawLegalMoves();
        board.repaint();
      } else if (board.hasActivePiece() && board.squareIsLegal(e.getX(), e.getY())) {
        // Piece selected when click was made

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
