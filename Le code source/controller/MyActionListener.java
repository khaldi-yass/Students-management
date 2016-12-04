package controller;


import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import actions.Supprimer;
import actions.Afficher;
import actions.Ajouter;
import actions.Modifier;

/**
 * 
 * 
 *<strong>Description</strong><br>
 * 
 * MyActionListener est la classe qui gere tous les ActionEvents<br>
 * 
 * @author yassir
 */

public class MyActionListener implements ActionListener
{
	
	/**
	 * Variable statique de type JDialog, c'est la fenetre d'ajout
	 */
	public static JDialog addPopup;
	/**
	 * Variable statique de type JDialog, c'est la fenetre d'affichage
	 */
	public static JDialog showPopup;
	/**
	 * Variable statique de type JDialog, c'est la fenetre de modification
	 */
	public static JDialog modPopup;
	
	
	/**
	 * ActionPerformed est surchargee.<br>
	 * Elle effectue differentes Actions selon le type de retour de getsource().
	 */
	
	@Override
	public void actionPerformed(ActionEvent action) {
		
		/*
		 * Boutton Afficher
		 */
		if(action.getSource() == ApplicationLayout.afficher)
		{
			/*
			 * Si l'utilisateur ne selectionne pas de ligne une alerte s'affichera
			 */
			if( ApplicationLayout.tableau.getSelectedRow() >= 0 )
			{
				/*
				 * Un nouveau JDialog qui contiendera le JPanel generé par la classe Afficher
				 */
				showPopup= new JDialog(ApplicationLayout.fen,"Afficher",ModalityType.APPLICATION_MODAL);
				showPopup.setPreferredSize(new Dimension(300,400));
				showPopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				showPopup.setResizable(false);
				showPopup.setLocationRelativeTo(null);
				showPopup.setLayout(new BorderLayout());
				
				Afficher panel = new Afficher();
				showPopup.setContentPane(panel);
				showPopup.pack();
				showPopup.setVisible(true);
				
			}
			else
			{
				JOptionPane.showMessageDialog(ApplicationLayout.fen,
					    "Vous devez selectionner une ligne.",
					    "Attention",
					    JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		/*
		 * Boutton Ajouter
		 */
		else if(action.getSource() == ApplicationLayout.ajouter){
			
			/*
			 * Un nouveau JDialog qui contiendera le JPanel generé par la classe Ajouter
			 */
			addPopup= new JDialog(ApplicationLayout.fen,"Ajouter",ModalityType.APPLICATION_MODAL);
			addPopup.setPreferredSize(new Dimension(550,500));
			addPopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			addPopup.setResizable(false);
			addPopup.setLocationRelativeTo(null);
			addPopup.setLayout(new BorderLayout());
			
			Ajouter panel = new Ajouter();
			addPopup.setContentPane(panel);
			addPopup.pack();
			addPopup.setVisible(true);
		}
		
		/*
		 * Boutton Ajouter
		 */
		else if(action.getSource() == ApplicationLayout.supprimer){	
			
			/*
			 * Si l'utilisateur ne selectionne pas de ligne une alerte s'affichera
			 */
			if( ApplicationLayout.tableau.getSelectedRow() >= 0 )
			{
				//Une confirmation de code avant de supprimer
				int rep = JOptionPane.showConfirmDialog(ApplicationLayout.fen, "voulez-vous vraiment supprimer cet etudiant?"
														,"Attention",JOptionPane.YES_NO_OPTION) ;
				if(rep == 0) new Supprimer();
			}else
			{
				JOptionPane.showMessageDialog(ApplicationLayout.fen,
					    "Vous devez selectionner une ligne.",
					    "Attention",
					    JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		/*
		 * Boutton Modifier
		 */
		else if(action.getSource() == ApplicationLayout.modifier){
			
			/*
			 * Si l'utilisateur ne selectionne pas de ligne une alerte modifier
			 */
			if( ApplicationLayout.tableau.getSelectedRow() >= 0 )
			{
				/*
				 * Un nouveau JDialog qui contiendera le JPanel generé par la classe Modifier
				 */
				modPopup= new JDialog(ApplicationLayout.fen,"Modifier",ModalityType.APPLICATION_MODAL);
				modPopup.setPreferredSize(new Dimension(550,500));
				modPopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				modPopup.setResizable(false);
				modPopup.setLocationRelativeTo(null);
				modPopup.setLayout(new BorderLayout());
				
				Modifier panel = new Modifier();
				modPopup.setContentPane(panel);
				modPopup.pack();
				modPopup.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(ApplicationLayout.fen,
					    "Vous devez selectionner une ligne.",
					    "Attention",
					    JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
