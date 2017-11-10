
package guiapp.no2;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
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
     private JLabel top = new JLabel("aaaaa");
     private JLabel mid = new JLabel("salut c'est cool");
     private JLabel bot = new JLabel("contenu incorrect");
     
     //textfield
     private JTextField champkm = new JTextField("", 10);
     private JTextField champpi = new JTextField("", 10);
     private JTextField champm = new JTextField("", 10);
     private JTextField champmi = new JTextField("", 10);
     private JTextField champkmh = new JTextField("", 10);
     private JTextField champkn = new JTextField("", 10);
     
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
        convtop.addActionListener(new kmtomi());
        pantop.add(champmi);
        pantop.add(mi);
        reptop.add(top);
        //mid
        panmid.add(m);
        panmid.add(champm);
        panmid.add(convmid);
        convmid.addActionListener(new mtopi());
        panmid.add(champpi);
        panmid.add(pi);
        repmid.add(mid);
        //bot
        panbot.add(kmh);
        panbot.add(champkmh);
        panbot.add(convbot);
        convbot.addActionListener(new kmhtokn());
        panbot.add(champkn);
        panbot.add(kn);
        repbot.add(bot);
        
        
        
        //end
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
     
     class kmtomi implements ActionListener {
         
         public void actionPerformed(ActionEvent e){
         String tkm = champkm.getText();
         String tmi = champmi.getText();
            //ceck si les 2 ont un contenu 
            if (tkm.length() != 0 && tmi.length() != 0) {
                top.setText("les 2 champs sont rempli !");
            }
            //transforme tkm
            else if (Pattern.matches("[0-9.]+", tkm) == true && tkm.length() != 0){
                double dkm = Double.parseDouble(tkm);
                champmi.setText("" + dkm*0.621);
                top.setText("");
            }
            //transforme tmi
            else if (Pattern.matches("[0-9.]+", tmi) == true && tmi.length() != 0){
                double dmi = Double.parseDouble(tmi);
                champkm.setText(""+ dmi/0.621);
                top.setText("");
            }
            //sinon
            else{
                top.setText("contenu incorrect!");
            }         
         }
 
 }
     
     class mtopi implements ActionListener {
         
         public void actionPerformed(ActionEvent e){
         String tm = champm.getText();
         String tpi = champpi.getText();
            //ceck si les 2 ont un contenu 
            if (tm.length() != 0 && tpi.length() != 0) {
                mid.setText("les 2 champs sont rempli !");
            }
            //transforme tkm
            else if (Pattern.matches("[0-9.]+", tm) == true && tm.length() != 0){
                double dkm = Double.parseDouble(tm);
                champpi.setText("" + dkm*0.0254);
                mid.setText("");
            }
            //transforme tmi
            else if (Pattern.matches("[0-9.]+", tpi) == true && tpi.length() != 0){
                double dmi = Double.parseDouble(tpi);
                champm.setText(""+ dmi/0.0254);
                mid.setText("");
            }
            //sinon
            else{
                mid.setText("contenu incorrect!");
            }         
         }
 
 }
     
     class kmhtokn implements ActionListener {
         
         public void actionPerformed(ActionEvent e){
         String tkmh = champkmh.getText();
         String tkn = champkn.getText();
            //ceck si les 2 ont un contenu 
            if (tkmh.length() != 0 && tkn.length() != 0) {
                bot.setText("les 2 champs sont rempli !");
            }
            //transforme tkmh
            else if (Pattern.matches("[0-9.]+", tkmh) == true && tkmh.length() != 0){
                double dkmh = Double.parseDouble(tkmh);
                champkn.setText("" + dkmh*1.852);
                bot.setText("");
            }
            //transforme tkn
            else if (Pattern.matches("[0-9.]+", tkn) == true && tkn.length() != 0){
                double dkn = Double.parseDouble(tkn);
                champkmh.setText(""+ dkn/1.852);
                bot.setText("");
            }
            //sinon
            else{
                bot.setText("contenu incorrect!");
            }         
         }
 
 }
    
}
