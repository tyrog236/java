package ex_13;

import java.awt.Color;

public class ActionCouleur extends javax.swing.AbstractAction
{
  private final Color couleur;
  private final Paneau pan;
  static ActionCouleur actionInactive;
  
  public ActionCouleur(String nom, Color couleur, String nomIcone, Paneau pan) {
    putValue("Name", nom);
    putValue("SmallIcon", new javax.swing.ImageIcon(nomIcone));
    putValue("ShortDescription", "Fond " + nom);
    this.couleur = couleur;
    this.pan = pan;
  }
  

  public void actionPerformed(java.awt.event.ActionEvent e)
  {
    pan.setCouleur(couleur);
    pan.repaint();
    setEnabled(false);
    if (actionInactive != null) actionInactive.setEnabled(true);
    actionInactive = this;
  }
}
