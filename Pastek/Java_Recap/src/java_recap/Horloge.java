package java_recap;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import java.math.*;

//-----------------------------------------------------------------
//  CREATION D'UNE HORLOGE
//-----------------------------------------------------------------

public class Horloge extends JFrame{
    private JPanel container = new JPanel();
    private JPanel Top = new JPanel();
    private JLabel Label1 = new JLabel("heure");
    private JLabel Label2 = new JLabel("minutes");
    private JTextField Text1 = new JTextField(); //ZONE DE TEXT DES HEURE
    private JTextField Text2 = new JTextField(); //ZONE DE TEXT DES MINUTE
    private JButton b1 = new JButton("next"); //le buton
    private JPanel Panneau = new JPanel();
    private int Tab[] = new int[2];
    private int Tab2[] = new int[2];
    private int Tab3[] = new int [2];
    public double Heure1;
    public double Heure2;
    public Cadran Cadran1 = new Cadran();
    
    
    public Horloge(){
    //-----------------------------------------------------------------
    //  STRUCTURE 
    
        this.setTitle("Horloge");
        this.setSize(1020, 570);
        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        container.setLayout(new BorderLayout());
        Font Police = new Font("Calibri", Font.BOLD, 16);
        
        
        Top.setBackground(Color.blue);
        Label1.setForeground(Color.white);
        Top.add(Label1);
        Text1.setFont(Police);
        Text1.setColumns(3);
        Top.add(Text1);
        Label2.setForeground(Color.white);
        Top.add(Label2);
        Text2.setFont(Police);
        Text2.setColumns(3);
        Top.add(Text2);
        Top.add(b1);
        b1.addActionListener(new B1Listener());
        container.add(Top, BorderLayout.NORTH);
        Panneau.setBackground(Color.pink);
        Panneau.setPreferredSize(new Dimension(1000, 500));
        //container.add(Panneau);
        container.add(Cadran1);
        
        
        
        this.setContentPane(container);
        this.setVisible(true);
        this.setResizable(false);
    }
    
    
    
    class B1Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            container.repaint();
            Heure1 = Double.valueOf(Text1.getText()).intValue();
            
            Heure2 = Double.valueOf(Text2.getText()).intValue();
            System.out.println("valeur récup : "+Heure1+" et "+Heure2);
            
            Tab = CooHour(Heure1, Heure2);
            Tab = CooMin(Heure2);
            System.out.println("valeur de Tab : "+Tab[0]+" , "+Tab[1]);
            System.out.println("Valeur de Tab2 : "+Tab2[0]+" , "+Tab2[1]);
            System.out.println("Valeur de Tab3 : "+Tab3[0]+" , "+Tab3[1]);
            Cadran1.Cadran(Tab2[0], Tab2[1], Tab3[0], Tab3[1]);
            
            container.add(Cadran1);
            try {
            Thread.sleep(10);
            } catch (InterruptedException f) {
                f.printStackTrace();
            }
            
        }
    }
    
    public int[] CooHour(double H, double M){
        System.out.println("    Valeur récup : "+H+" , "+M);
        double resultDegree = 0;
        int cadran = 0;
        double Y = 0;
        double X = 0;
        double r = 160;
        double m = M/60; //CALCUL DE L'HEURE A VIRGULE
        double h = H+m;
        double degree = (h/12)*360; //CALCUL DE LA POSITION DE L'AIGUILLE EN DEGREE
        
        
        if(degree > 0 && degree <= 90 || degree == 360){
            resultDegree = degree - 0;
            cadran = 0;
        }else if(degree > 90 && degree <= 180){
            resultDegree = degree - 90;
            cadran = 1;
        }else if(degree > 180 && degree <= 270){
            resultDegree = degree - 180;
            cadran = 2;
        }else if(degree > 270 && degree <=360){
            resultDegree = degree - 270;
            cadran = 3;
        }
        System.out.println("    Valeur degree : "+degree+" et result "+resultDegree);
        System.out.println("    Cadran : "+cadran);
        //-----------------------------------------------------------------
        //  CALCUL DU SINUS ET DU COSINUS
        if ( cadran == 0 || cadran == 2){
           double radians1 = Math.toRadians(resultDegree);
            double x=Math.sin(radians1)*r;
            double radians2 = Math.toRadians(resultDegree);
            double y=Math.cos(radians2)*r;
            System.out.println("    Valeur sin (x) : "+x+" et cos (y) "+y); 
            if(cadran == 0){
                Y=250-y;
                X=500+x;
            }else if(cadran == 2){
                Y=250+y;
                X=500-x;
            }
        }else if (cadran == 1 || cadran == 3){
            double radians3 = Math.toRadians(resultDegree);
            double y=Math.sin(radians3)*r;
            double radians4 = Math.toRadians(resultDegree);
            double x=Math.cos(radians4)*r;
            System.out.println("    Valeur cos (x) : "+x+" et sin (y) "+y);
            if(cadran == 1){
                Y=250+y;
                X=500+x;
            }else if (cadran == 3){
                Y=250-y;
                X=500-x;
            }
        }
        System.out.println("    position X : "+X+" et Y "+Y);
        int X1 = (int)X;
        int Y1= (int)Y;
        System.out.println("    position en int X : "+X1+" et Y "+Y1);
        Tab2[0]=X1;
        Tab2[1]=Y1;
        
        
        return Tab2;
    }
    
    public int[] CooMin(double M){
        System.out.println("valeur récup"+M);
        
        double resultDegree = 0;
        int cadran = 0;
        double Y = 0;
        double X = 0;
        double r = 200;
        
        double degree = (M/60)*360;
        
        if(degree > 0 && degree <= 90 || degree == 360){
            resultDegree = degree - 0;
            cadran = 0;
        }else if(degree > 90 && degree <= 180){
            resultDegree = degree - 90;
            cadran = 1;
        }else if(degree > 180 && degree <= 270){
            resultDegree = degree - 180;
            cadran = 2;
        }else if(degree > 270 && degree <=360){
            resultDegree = degree - 270;
            cadran = 3;
        }
        System.out.println("    Valeur degree : "+degree+" et result "+resultDegree);
        System.out.println("    Cadran : "+cadran);
        //-----------------------------------------------------------------
        //  CALCUL DU SINUS ET DU COSINUS
        if ( cadran == 0 || cadran == 2){
           double radians1 = Math.toRadians(resultDegree);
            double x=Math.sin(radians1)*r;
            double radians2 = Math.toRadians(resultDegree);
            double y=Math.cos(radians2)*r;
            System.out.println("    Valeur sin (x) : "+x+" et cos (y) "+y); 
            if(cadran == 0){
                Y=250-y;
                X=500+x;
            }else if(cadran == 2){
                Y=250+y;
                X=500-x;
            }
        }else if (cadran == 1 || cadran == 3){
            double radians3 = Math.toRadians(resultDegree);
            double y=Math.sin(radians3)*r;
            double radians4 = Math.toRadians(resultDegree);
            double x=Math.cos(radians4)*r;
            System.out.println("    Valeur cos (x) : "+x+" et sin (y) "+y);
            if(cadran == 1){
                Y=250+y;
                X=500+x;
            }else if (cadran == 3){
                Y=250-y;
                X=500-x;
            }
        }
        System.out.println("    position X : "+X+" et Y "+Y);
        int X1 = (int)X;
        int Y1= (int)Y;
        System.out.println("    position en int X : "+X1+" et Y "+Y1);
        Tab3[0]=X1;
        Tab3[1]=Y1;
        
        return Tab3;
    }
    
    
}
