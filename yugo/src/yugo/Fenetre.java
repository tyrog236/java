package yugo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame implements MouseListener, ActionListener
{
    private JPanel container = new JPanel();
    private JPanel pan = new JPanel();
    private JButton b1 = new JButton("clicker pour desactiver");
    private Graphics g = pan.getGraphics();
    private Toolkit tk = Toolkit.getDefaultToolkit();               //instance des outil pour chopper la taille de l'ecran
    private Dimension dimScreen = tk.getScreenSize();               //chopper la taille de l'ecran
    private int LScreen = dimScreen.width;                          //largeur de l'ecran
    private int HScreen = dimScreen.height;                         //hauteur de l'ecran
    private int a =150;
    private int b =150;
    private int c =150;
    private int x0 = 0;
    private int y0= 0;
    private int x1 =0;
    private int y1 = 0;
    
    private Color couleur = new Color(a, b, c);
    
    public Fenetre() 
    {
        this.setTitle("Une fenêtre Java avec objet graphique");     // Titre
        this.setSize(LScreen/2, 600);                               // Taille de la fenetre
        container.setPreferredSize(new Dimension(LScreen/2, 600));  //taille du panel container
        pan.setPreferredSize(new Dimension(LScreen/2, 600));        //taille du panel pan
        this.add(container);                                        //panel principal
        container.add(pan);                                         //panel utilisé
        pan.setBackground(couleur);                                 //couleur du fond
        pan.addMouseListener(this);                                 //ajout mouse listener
        pan.add(b1);                                                //ajout du bouton
        b1.addActionListener(this);                                 //ajout de l'action listener sur un bouton
        
        
        JMenuBar mb = new JMenuBar();                               //creation option menu
        setJMenuBar(mb);                                            //set option menu
        JMenu menu1 = new JMenu("menu1");                           //creation d'un menu
        mb.add(menu1);                                              //pose du menu
        JMenuItem item1 = new JMenuItem("item1");                   //creation du sous menu
        menu1.add(item1);                                           //pose du sous menu
        item1.addActionListener(this);                              //ajout d'un action listener sur le sous menu        
        this.setLocationRelativeTo(null);                           // Position par défaut
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // Action si bouton fermeture activé
        this.setVisible(true);                                      // Rendre visible
    }
    
    //mouse action (toutes pour fonctioner)
    
    public void mouseClicked (MouseEvent e)
    { 
        
        int x = e.getX();                                                       //recup position x
        int y = e.getY();                                                       //recup position y
        System.out.println ("mouseClicked en  " + x + " " + y) ;                    
        
        
        Graphics g = pan.getGraphics();                                         //instance les outil graphics
        
        g.drawRect(x-3, y-3, 5, 5);                                             //dessine un rectangle
        g.dispose();                                                            //le pose
        
    }
  
    public void mousePressed (MouseEvent e)
    {
        System.out.println ("mousePressed en  " + e.getX() + " " + e.getY()) ;
        x0 = e.getX();                                                          //recup position x
        y0 = e.getY();                                                          //recup position y
    }
  
    public void mouseReleased (MouseEvent e)
    {
       x1 = e.getX();
       y1 = e.getY();
       
       Graphics g = pan.getGraphics();
       
       if(x0 != x1){g.drawLine(x1, y1, x0, y0);}
       
    }
  
    public void mouseEntered (MouseEvent e) {
        System.out.println ("entrer");
    }
  
    public void mouseExited (MouseEvent e)  {
    System.out.println ("sortie");
    }
    
    
    //action listener
    
    public void actionPerformed(ActionEvent e) {
        b1.setEnabled(false);
    }
}