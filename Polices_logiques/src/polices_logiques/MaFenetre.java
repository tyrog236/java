package polices_logiques;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MaFenetre extends JFrame
{
    MaFenetre ()
    {
        this.setTitle ("Polices logiques") ;
        this.setSize (800, 200) ;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        pan = new Paneau();
        getContentPane().add(pan) ;
        
        this.setVisible(true);
    }
  
    private JPanel pan ;
}