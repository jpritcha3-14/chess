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
    if (board.getActivePiece() == null) {
      white.pickUp(board.getPiece(e.getX(), e.getY()));
      board.setActivePiecePos(e.getX() - Square.WIDTH/2, e.getY() - Square     .WIDTH/2);
      board.repaint();
    } else {
      board.setPiece(white.place(), e.getX(), e.getY());
      board.setActivePiecePos(e.getX() - Square.WIDTH/2, e.getY() - Square     .WIDTH/2);
      board.repaint();
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
