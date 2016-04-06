import java.awt.*;
import java.awt.image.*;
import java.awt.Graphics;

public abstract class Piece {
  private String color;
  private BufferedImage sprite;   

  public Piece(String c, BufferedImage s) {
    color = c;
    sprite = s;
  }
  
  public BufferedImage getSprite() {
    return sprite;
  }  
    
  public Graphics draw(Graphics g, int x, int y) {
    g.drawImage(sprite, x, y, null); 
    return g;
  }
  
  
}
