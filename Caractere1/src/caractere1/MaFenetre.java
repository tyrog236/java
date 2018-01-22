package caractere1;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class MaFenetre extends JFrame
{ 
    public MaFenetre ()
    { 
        this.setTitle ("Affichage caracteres No 1") ;
        this.setSize (500, 300) ;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        Container contenu = getContentPane() ;
        pan = new Paneau() ;
        contenu.add(pan) ;
    
        addKeyListener (new KeyAdapter()
        { 
            @Override
            public void keyTyped(KeyEvent e)
            { 
                pan.setCaractereCourant (e.getKeyChar()) ;
            }
        }) ;
        
        this.setVisible(true);
    }
    
    private Paneau pan ;
}
