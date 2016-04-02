import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.AffineTransform;
import javax.imageio.*;
import javax.swing.*;

public class ParsePieces {
  BufferedImage orig;
  BufferedImage before;
  BufferedImage after; 
  String[] color = {"white", "black"};
  String[] rank = {"King", "Queen", "Bishop", "Knight", "Rook", "Pawn"};
  
  
  public static void main(String[] args) {
    ParsePieces parser = new ParsePieces();
    parser.go();
  } 
  
  public void go() {
  
    for (int c = 0; c < 2; c++) {
      for (int r = 0; r < 6; r++) {

    
        try {
          orig = ImageIO.read(new File("./piece_pictures/Chess_Pieces_Sprite.png"));
        } catch (IOException e) {
        }
    
        before = orig.getSubimage(r*333, c*333,333,333);
        int w = before.getWidth();
        int h = before.getHeight();
        AffineTransform at = new AffineTransform();
        at.scale((double) 75/333, (double) 75/333);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(before, after);
    
        try {
          File outputfile = new File("./piece_pictures/" + color[c] + rank[r] + ".png");
          ImageIO.write(after, "png", outputfile);
        } catch (IOException e) {
          System.out.println("failed to save image");
        }
      }
    }
  }  
}


