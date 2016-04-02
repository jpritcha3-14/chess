import java.awt.*;
import java.awt.image.*;

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
    
}
