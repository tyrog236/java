package java_recap;

 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Alert_Activ extends JPanel{
    
        private JButton btn1 = new JButton("Alert");
        private JButton btn2 = new JButton("info");
        private JButton btn3 = new JButton("erreur");
        private JPanel Pan = new JPanel();
        private JOptionPane JOP1 = new JOptionPane();

        
        public Alert_Activ(){
            
            this.setLayout(new BorderLayout());
            btn1.addActionListener(new btn1Listener());
            Pan.add(btn1);
            btn2.addActionListener(new btn2Listener());
            Pan.add(btn2);
            btn3.addActionListener(new btn3Listener());
            Pan.add(btn3);
            Pan.setBackground(Color.yellow);
            this.add(Pan,  BorderLayout.CENTER);

            
            
            
            
        }
        class btn1Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                JOP1.showMessageDialog(null, "Alert", "preventif", JOptionPane.WARNING_MESSAGE);
            }
        }
        class btn2Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                JOP1.showMessageDialog(null, "info", "info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        class btn3Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                JOP1.showMessageDialog(null, "erreur", "erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
}
    
    

