package ex_13;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

class FenMenu extends javax.swing.JFrame implements java.awt.event.ActionListener
{
  public static final String[] nomCouleurs = { "Blanc", "Rouge", "Vert", "Jaune", "Bleu" };
  

  public static final java.awt.Color[] couleurs = { java.awt.Color.white, java.awt.Color.red, java.awt.Color.green, java.awt.Color.yellow, java.awt.Color.blue };
  

  public static final String[] nomIcones = { "./icons/blanc.gif", "./icons/rouge.gif", "./icons/vert.gif", "./icons/jaune.gif", "./icons/bleu.gif" };
  private final javax.swing.JMenuBar barreMenus;
  private final JMenu couleur;
  private final JMenu dimensions;
  
  public FenMenu() {
    setTitle("Figures avec menus et barre d'outils");
    
    java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
    java.awt.Dimension dimScreen = tk.getScreenSize();
    int withScreen = dimScreen.width;
    int heightScreen = dimScreen.height;
    
    setSize(withScreen / 2, heightScreen / 2);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(2);
    
    java.awt.Container contenu = getContentPane();
    

    pan = new Paneau();
    contenu.add(pan);
    pan.setBackground(java.awt.Color.white);
    

    int nbCouleurs = nomCouleurs.length;
    actions = new ActionCouleur[nbCouleurs];
    
    for (int i = 0; i < nbCouleurs; i++)
    {
      actions[i] = new ActionCouleur(nomCouleurs[i], couleurs[i], nomIcones[i], pan);
    }
    


    barreMenus = new javax.swing.JMenuBar();
    setJMenuBar(barreMenus);
    

    couleur = new JMenu("Couleur");
    barreMenus.add(couleur);
    for (int i = 0; i < nomCouleurs.length; i++) {
      couleur.add(actions[i]);
    }
    
    couleurSurg = new javax.swing.JPopupMenu();
    for (int i = 0; i < nomCouleurs.length; i++) {
      couleurSurg.add(actions[i]);
    }
    
    formes = new JMenu("Formes");
    barreMenus.add(formes);
    rectangle = new JCheckBoxMenuItem("Rectangle");
    rectangle.setToolTipText("Dessiner un rectangle");
    rectangle.setMnemonic('R');
    rectangle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(82, 2));
    formes.add(rectangle);
    rectangle.addActionListener(this);
    ovale = new JCheckBoxMenuItem("Ovale");
    ovale.setToolTipText("Dessiner un ovale");
    ovale.setMnemonic('O');
    ovale.setAccelerator(javax.swing.KeyStroke.getKeyStroke(79, 2));
    formes.add(ovale);
    ovale.addActionListener(this);
    triangle = new JCheckBoxMenuItem("Triangle");
    triangle.setToolTipText("Dessiner un triangle");
    triangle.setMnemonic('T');
    triangle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(84, 2));
    formes.add(triangle);
    triangle.addActionListener(this);
    

    dimensions = new JMenu("Dimensions");
    barreMenus.add(dimensions);
    largeur = new JMenuItem("Largeur");
    largeur.setToolTipText("Modifier la largeur de la forme");
    largeur.setMnemonic('L');
    largeur.setAccelerator(javax.swing.KeyStroke.getKeyStroke(76, 2));
    dimensions.add(largeur);
    largeur.addActionListener(this);
    hauteur = new JMenuItem("Hauteur");
    hauteur.setToolTipText("Modifier la hauteur de la forme");
    hauteur.setMnemonic('H');
    hauteur.setAccelerator(javax.swing.KeyStroke.getKeyStroke(72, 2));
    dimensions.add(hauteur);
    hauteur.addActionListener(this);
    


    barreCouleurs = new javax.swing.JToolBar();
    for (int i = 0; i < nomCouleurs.length; i++)
    {
      javax.swing.JButton boutonCourant = barreCouleurs.add(actions[i]);
      boutonCourant.setText(null);
      boutonCourant
        .setToolTipText((String)actions[i].getValue("ShortDescription"));
    }
    contenu.add(barreCouleurs, "North");
    
    setVisible(true); }
  
  private final JMenu formes;
  private final JMenuItem largeur;
  private final JMenuItem hauteur;
  
  public void actionPerformed(java.awt.event.ActionEvent e) { Object source = e.getSource();
    if (source == largeur) {
      String ch = javax.swing.JOptionPane.showInputDialog(this, "Largeur");
      pan.setLargeur(Integer.parseInt(ch));
    }
    if (source == hauteur)
    {
      String ch = javax.swing.JOptionPane.showInputDialog(this, "Hauteur");
      pan.setHauteur(Integer.parseInt(ch));
    }
    if (source == ovale) pan.setOvale(ovale.isSelected());
    if (source == rectangle) pan.setRectangle(rectangle.isSelected());
    if (source == triangle) pan.setTriangle(triangle.isSelected());
    pan.repaint();
  }
  
  private final JCheckBoxMenuItem rectangle;
  private final JCheckBoxMenuItem ovale;
  private final JCheckBoxMenuItem triangle;
  private final javax.swing.JPopupMenu couleurSurg;
  private final ActionCouleur[] actions;
  private final javax.swing.JToolBar barreCouleurs;
  private final Paneau pan;
}
