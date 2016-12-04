package actions;

import javax.swing.table.DefaultTableModel;
import controller.ApplicationLayout;

/**
 * 
 *<strong>Description</strong><br>
 * 
 * Supprimer est la classe qui supprime une ligne du tableau<br>
 * 
 * @author yassir
 * 
 */
public class Supprimer {

	public Supprimer() {
		
		// Recuperer la ligne selectionnée du tableau et la supprimer
		int sel = ApplicationLayout.tableau.getSelectedRow();
		
		try {
			if(sel>=0 && sel<=7){
				((DefaultTableModel) ApplicationLayout.tableau.getModel()).removeRow(sel);
			}
		} catch (Exception e) { System.out.println("erreur de suppression");}	
	}
}
