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

    
    frame = new JFrame();
    this.setFocusable(true);
    frame.getContentPane().add(this);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(10*Square.WIDTH, 10*Square.WIDTH);
  }

  public void drawBoard () {
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
