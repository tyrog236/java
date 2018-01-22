package java_recap;

 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Fenetre extends JFrame implements KeyListener, MouseListener{ //heritage de JFrame
    private JPanel container = new JPanel(); //création d'un panel
    private JPanel Panneau = new JPanel(); //panneau sur la container
    private JMenuBar BarreMenu = new JMenuBar(); //barre de menu
    
    private JMenu menu1 = new JMenu("Action Bouton");
    private JMenu menu2 = new JMenu("autre app");
    private JMenu menu3 = new JMenu("menu 3");
    
    private JMenuItem item11 = new JMenuItem("Alert");
    private JMenuItem item12 = new JMenuItem("taille - colo");
    private JMenuItem item21 = new JMenuItem("Horloge");
    private JMenuItem item22 = new JMenuItem("item 2");
    private JMenuItem item31 = new JMenuItem("item 1");
    private JMenuItem item32 = new JMenuItem("item 2");
    private int a = 0;
    
    
    //-----------------------------------------------------------------
    //  structure de la fenetre
    //-----------------------------------------------------------------
    public Fenetre(){
       this.setTitle("Recap"); //titre de la fenetre
       container.setLayout(new BorderLayout());
       
       Toolkit tk = Toolkit.getDefaultToolkit();
       Dimension dimScreen = tk.getScreenSize(); //récup les dim de l'écran
       int withSCreen = dimScreen.width;
       int heightScrenn = dimScreen.height;
       
       this.setSize(withSCreen/2,heightScrenn/2 ); //fix la taille de la fenetre à la moitié de l'écran   
       this.setLocationRelativeTo(null); 
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // bouton de close de la fenetre
       
       this.setJMenuBar(BarreMenu);
       BarreMenu.add(menu1);
       BarreMenu.add(menu2);
       BarreMenu.add(menu3);
       

       menu1.add(item11);
       menu1.add(item12);
       menu2.add(item21);
       menu2.add(item22);
       menu3.add(item31);
       menu3.add(item32);
       
       item11.addActionListener(new item11Listener());
       item12.addActionListener(new item12Listener());
       item21.addActionListener(new item21Listener());
       

       
       
       container.add(Panneau);
       Panneau.setPreferredSize(new Dimension((withSCreen/2)-10,(heightScrenn/2)-10));
       Panneau.setBackground(Color.RED);
       a = 1;
       
       addMouseListener(this);
       addKeyListener(this);
       
       
       this.setContentPane(container);
       this.setVisible(true);
       
       
       
    }

    class item11Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Fenetre.this.setContentPane(new Alert_Activ());
            item11.setEnabled(false);
            Fenetre.this.revalidate();
        }
    }
    class item21Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Horloge H1 = new Horloge();
            item21.setEnabled(false);
        }
    }
    class item12Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Fenetre.this.setContentPane(new taille_colo());
            item11.setEnabled(false);
            Fenetre.this.revalidate();
        }
    }
    
    
    
    
    public void keyTyped(KeyEvent key) {
//        event.KeyEvent[KEY_TYPED,keyCode=0,keyText=Unknown keyCode: 0x0,keyChar='a',keyLocation=KEY_LOCATION_UNKNOWN,rawCode=0,primaryLevelUnicode=0,scancode=0,extendedKeyCode=0x0] on frame0
        char touche = key.getKeyChar();
            if(touche == 'o'){
                Panneau.setBackground(Color.ORANGE); 
            }else if(touche == 'p'){
                Panneau.setBackground(Color.PINK); 
            }
        
    }

    
    public void keyPressed(KeyEvent key) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void keyReleased(KeyEvent key) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void mouseClicked(MouseEvent me) {
        System.out.println("Click de souris ;-)");
    }

    
    public void mousePressed(MouseEvent me) {
        System.out.println("Bouton pressé ;-)");
    }

    
    public void mouseReleased(MouseEvent me) {
        System.out.println("Bouton relâché ;-)");
    }

    
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
       
    
    
    
    
}
 