package ex_13;

import java.awt.Graphics;

class Paneau extends javax.swing.JPanel
{
  Paneau() {}
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    

    int wx = getWidth() / 2;
    int wy = getHeight() / 2;
    
    if (ovale) g.drawOval(wx - largeur / 2, wy - hauteur / 2, largeur, hauteur);
    if (rectangle) g.drawRect(wx - largeur / 2, wy - hauteur / 2, largeur, hauteur);
    if (triangle)
    {
      int n = 3;
      int[] x = new int[3];
      int[] y = new int[3];
      

      x[0] = (wx - largeur / 2);x[1] = wx;x[2] = (wx + largeur / 2);
      y[0] = (wy + hauteur / 2);y[1] = (wy - hauteur / 2);y[2] = (wy + hauteur / 2);
      
      g.drawPolygon(x, y, 3);
    }
  }
  
  public void setRectangle(boolean trace) { rectangle = trace; }
  public void setOvale(boolean trace) { ovale = trace; }
  public void setTriangle(boolean trace) { triangle = trace; }
  public void setLargeur(int l) { largeur = l; }
  public void setHauteur(int h) { hauteur = h; }
  public void setCouleur(java.awt.Color c) { setBackground(c); }
  private boolean rectangle = false; private boolean ovale = false; private boolean triangle = false;
  private int largeur = 500; private int hauteur = 200;
}