package caractere1;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

class Paneau extends JPanel
{ 
    public Paneau()
    { 
        addMouseListener (new MouseAdapter()
        {  
            public void mouseClicked (MouseEvent e)
            { 
                Graphics g = getGraphics() ;
                String ch = "" + caractereCourant ;
                g.drawString (ch, e.getX(), e.getY()) ;
                g.dispose() ;
             }
        }) ;
    }
  
    public void paintComponent(Graphics g)
    { 
        super.paintComponent(g) ;
    }
  
    public void setCaractereCourant (char c)
    { 
        caractereCourant = c ;
        System.out.println(caractereCourant);
    }
  
    private char caractereCourant = '?' ;
}