public class PieceStatus{
  private Piece piece;
  private int col;
  private int row;

  public PieceStatus(Piece p, int c, int r) {
    piece = p;
    col = c;
    row = r;
  }

  public Piece getPiece() {
    return piece;
  }
  
  public int getCol() {
    return col;
  }

  public int getRow() {
    return row;
  }     
}
