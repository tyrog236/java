package java_recap;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;


import javax.swing.*;
public class actionBtn extends JPanel{
    private JButton btnCarre = new JButton("Carre");
    private JPanel Pan = new JPanel();
    public actionBtn(){
        this.setLayout(new BorderLayout());
        this.add(Pan,  BorderLayout.CENTER);
//        btnCarre.addActionListener(paintComponent);
        Pan.add(btnCarre);
        
        
        
    }
    

    
    
//    class btnCarreListener implements ActionListener{
//        public void actionPerformed(ActionEvent e){
//                
//        }
//    }
    
    
    
    
    
    
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
