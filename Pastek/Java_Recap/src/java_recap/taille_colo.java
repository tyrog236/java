 package java_recap;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class taille_colo extends JPanel {
    private JButton btn = new JButton("create boutton");
    private JButton btnR = new JButton("Fond rouge");
    private JButton btnV = new JButton("Fond vert");
    private JPanel Pan = new JPanel();
    int ColoNum = 1;
    public taille_colo(){
        this.setLayout(new BorderLayout());
        
        btn.addActionListener(new btnListener());
        Pan.add(btn);
        
        btnR.addActionListener(new btnRListener());
        btnR.registerKeyboardAction(new btnRListener(), KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK | InputEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW) ;
        Pan.add(btnR);
        
        btnV.addActionListener(new btnVListener());
        btnV.registerKeyboardAction(new btnVListener(), KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_MASK | InputEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW) ;
        Pan.add(btnV);
        
        this.add(Pan,  BorderLayout.CENTER);
        Pan.setBackground(Color.blue);

        
    }
    class btnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            btn = new JButton("boutton"+ColoNum);
            Pan.add(btn);
            ColoNum++;
            Pan.validate();
        }
    }
    class btnRListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            int R = (int)(Math.random()*255);
            int G = (int)(Math.random()*255);
            int B = (int)(Math.random()*255);
            Color C = new Color(R,G,B);
            Pan.setBackground(C);
            ColoNum = 2;
            
            
//            if(ColoNum != 2){
//                Color C = new Color(R,G,B);
//                Pan.setBackground(C);
//                ColoNum = 2;
//            }else{
//                Pan.setBackground(Color.blue);
//                ColoNum = 1;
//            }
            
        }
    }
    class btnVListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(ColoNum != 3){
                Pan.setBackground(Color.green);
                ColoNum = 3;
            }else{
                Pan.setBackground(Color.blue);
                ColoNum = 1;
            }
            
        }
    }
}
