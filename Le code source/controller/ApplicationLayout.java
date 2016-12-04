package controller;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import controller.MyActionListener;
import model.Etudiant;
import view.BgPanel;
//import controller.MyActionListener;
//import controller.MyKeyListener;
import view.Window;

/**
 * 
 * <strong>Description</strong><br>
 *
 * Cette classe constitue le Layout principale du programme<br>
 * 
 * Elle regroupe tous les composants + leurs associes les Listeners<br>
 * 
 * @author yassir
 *
 */
public class ApplicationLayout {
	
	/**
	 * Variable statique de type Window, c'est le JFrame principale
	 */
	public static Window fen;
	/**
	 * Variable statique de type JPanel, c'est le contenaire principale
	 */
	public static JPanel container;
	/**
	 * Variable statique de type JPanel, c'est le contenaire de table
	 */
	public static JPanel tableContainer;
	/**
	 * Variable statique de type JPanel, c'est le contenaire des boutons (Ajouter/Modifier/Supprimer/Afficher)
	 */
	public static JPanel buttonContainer;
	/**
	 * Bouton statique Afficher
	 */
	public static JButton afficher;
	/**
	 * Bouton statique Modifier
	 */
	public static JButton modifier;
	/**
	 * Bouton statique Ajouter
	 */
	public static JButton ajouter;
	/**
	 * Bouton statique Supprimer
	 */
	public static JButton supprimer;
	/**
	 * Table statique qui affiche les valeurs
	 */
	public static JTable tableau;
	

	public ApplicationLayout() {
		
		//-------------- Instancier les contenaires de base-----------
		fen	= new Window(500,300,"Gestion des etudiants");	
		container = new BgPanel();
		buttonContainer = new JPanel();
		tableContainer = new JPanel();
		fen.setContentPane(container);
		//------------------------------------------

		//---------- Buttons settings------------------
		modifier = new JButton("Modifier");
		ajouter	= new JButton("Ajouter");
		supprimer = new JButton("Supprimer");	
		afficher = new JButton("Afficher");	
		buttonContainer.add(afficher);
		buttonContainer.add(modifier);
		buttonContainer.add(ajouter);
		buttonContainer.add(supprimer);
		buttonContainer.setOpaque(false);
		//----------------------------------------------
		
		//--------------First init of table--------------------
		Etudiant yassir = new Etudiant("Khaldi","Yassir","F123NK32","21","173","60","images/123NK32.png");
		Etudiant samir = new Etudiant("Khaldi","Samir","23TF524R","23","179","66","images/123TF52.png");
		
			//Ajout des objets etudiants dans une liste de type vecteur
		Etudiant.add(yassir);
		Etudiant.add(samir);
		
			//Initialisation des colonnes et lignes de tableau
		String[] cols = new String[] {"Nom","Prenom","CNE","Age","Taille","Poid","Img"};
		Object[][] data =  new Object[][]{
			{yassir.getNom(), yassir.getPrenom(), yassir.getCne(), yassir.getAge(), yassir.getTaille(), yassir.getPoids(), yassir.getImgLink()},
			{samir.getNom(), samir.getPrenom(), samir.getCne(), samir.getAge(), samir.getTaille(), samir.getPoids(), samir.getImgLink()}			
		};
		
			//Utilisation d'un objet DefaultTableModel qui gera notre tableau
		DefaultTableModel myTable = new DefaultTableModel(data, cols);
		tableau= new JTable(myTable);
		tableau.getTableHeader().setReorderingAllowed(false);
			
			// On ne desire afficher que 4 colonnes donc on enleve les trois autres.
			// Ceci enleve les colonnes de l'affichage et no pas du modele.
		for (int i=0;i<3;i++)
		{
			tableau.removeColumn(tableau.getColumnModel().getColumn(4));
		}

		JScrollPane scrollPane= new JScrollPane(tableau);
		
		//-----------Tableau settings---------------------
		tableau.setSelectionMode(0);
		tableau.setRowHeight(30);
		tableContainer.setLayout(new BorderLayout());
		tableContainer.add(scrollPane,BorderLayout.CENTER);	
		tableContainer.add(buttonContainer,BorderLayout.SOUTH);
		tableContainer.setOpaque(false);
		
		//--------------------------------------------------

		
		//-----------MainContainer settings----------------
		
		container.setLayout(new BorderLayout());
		container.add(tableContainer,BorderLayout.CENTER);
		//---------------------------------------------
				
		
		//--------------JFrame settings------------------
		fen.pack();
		fen.visible();
		//------------------------------------------------
	
		//----------------Ajout des Listeners----------------
		
		MyActionListener al= new MyActionListener();				//Voir la classe MyActionListener
		modifier.addActionListener(al);
		afficher.addActionListener(al);
		ajouter.addActionListener(al);
		supprimer.addActionListener(al);
	}
	
		
}






