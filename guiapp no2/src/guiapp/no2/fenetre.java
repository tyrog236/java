
package guiapp.no2;

import java.awt.*;
import javax.swing.*;

 class fenetre extends JFrame {
     //panel
     private JPanel panel = new JPanel();
     private JPanel pantop = new JPanel();
     private JPanel panmid = new JPanel();
     private JPanel panbot = new JPanel();
     private JPanel reptop = new JPanel();
     private JPanel repmid = new JPanel();
     private JPanel repbot = new JPanel();
     
     
     //layout
     private GridLayout layout1 = new GridLayout(6, 1, 0, 0);//pour le panel principal
     private GridLayout layout2 = new GridLayout(1, 5, 0, 0);//pour les 3 panels top mid et bot
     
     //label
     private JLabel km = new JLabel("kilometre");
     private JLabel pi = new JLabel("pied");
     private JLabel mi = new JLabel("miles");
     private JLabel m = new JLabel("metre");
     private JLabel kmh = new JLabel("kilometre/heure");
     private JLabel kn = new JLabel("knot");
     private JLabel test = new JLabel("test");
     //textfield
     private JTextField champkm = new JTextField(10);
     private JTextField champpi = new JTextField(10);
     private JTextField champm = new JTextField(10);
     private JTextField champmi = new JTextField(10);
     private JTextField champkmh = new JTextField(10);
     private JTextField champkn = new JTextField(10);
     
     //button
     private JButton convtop = new JButton("<=>");
     private JButton convmid = new JButton("<=>");
     private JButton convbot = new JButton("<=>");
     
     public fenetre() {
        //level 0
        this.setTitle("converstion");
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.add(panel);
        
        //level 1
        panel.setBackground(Color.black);
        panel.setLayout(layout1);
        
        panel.add(pantop);
        panel.add(reptop);
        panel.add(panmid);
        panel.add(repmid);
        panel.add(panbot);
        panel.add(repbot);
        
        
        //level 2
        pantop.setBackground(Color.BLUE);
        pantop.setLayout(layout2); 
        panmid.setBackground(Color.yellow);
        panmid.setLayout(layout2);
        panbot.setBackground(Color.red);
        panbot.setLayout(layout2);
        //top
        pantop.add(km);
        pantop.add(champkm);
        pantop.add(convtop);
        pantop.add(champmi);
        pantop.add(mi);
        //mid
        panmid.add(m);
        panmid.add(champm);
        panmid.add(convmid);
        panmid.add(champpi);
        panmid.add(pi);
        //bot
        panbot.add(kmh);
        panbot.add(champkmh);
        panbot.add(convbot);
        panbot.add(champkn);
        panbot.add(kn);
        
        
        
        //end
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
