package java_recap;

import java.awt.Graphics;
import javax.swing.*;
public class Cadran extends JPanel{
    public int OX = 500;
    public int OY = 250;
    int X1 = 500;
    int Y1 = 250;
    int X2 = 500;
    int Y2 = 250;
    
    public void Cadran(int x1, int y1, int x2, int y2){
       this.X1 = x1;
       this.Y1 = y1;
       this.X2 = x2;
       this.Y2 = y2;
       System.out.println("reçu des valeurs : " + X1+ " ; "+Y1+" ; "+X2+" ; "+Y2);
    }
    
    
    public void paintComponent (Graphics g){
        //super.paintComponent(g);
        
        drawCircle(g, 500, 250, 200);
        g.drawLine(OX, OY, this.X1, this.Y1);
        g.drawLine(OX, OY, this.X2, this.Y2);
        System.out.println("dessin d'une Heure avec valeurs : "+OX+" , "+OY+" , "+X1+" , "+Y1);
        System.out.println("dessin des minutes avec valeurs : "+OX+" , "+OY+" , "+X2+" , "+Y2);
    }
    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        cg.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
        
     }
    public int getX1(){
        return X1;
    }
    public int getY1(){
        return Y1;
    }
    public int getX2(){
        return X2;
    }
    public int getY2(){
        return Y2;
    }
    

}
