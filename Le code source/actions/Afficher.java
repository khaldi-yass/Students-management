package actions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import controller.ApplicationLayout;
import view.BgPanel;

/**
 * 
 *<strong>Description</strong><br>
 * 
 * Afficher est la classe qui génère le JPanel de la fenetre afficher<br>
 * 
 * @author yassir
 * 
 */

public class Afficher extends BgPanel{

	private static final long serialVersionUID = -549514075393269655L;
	//----------------------------------------------
	
	/**
	 * Variable statique du layout manager
	 */
	private static GridBagLayout gbl;
	/**
	 * Variable statique du layout manager
	 */
	private static GridBagConstraints gbc;
	private static int sel;
	private static BasicArrowButton next;
	private static BasicArrowButton prev;
	
	public Afficher()
	{	
		//Instanciation des layouts
		gbl = new GridBagLayout();
		this.setLayout(gbl);
		this.setBorder(new EmptyBorder(20,20,20,20));
		gbc = new GridBagConstraints();
		//---------------------------------------------
		
		
		// Recuperer la ligne selectionnée du tableau et affecter ses valeurs au variables 
		sel = ApplicationLayout.tableau.getSelectedRow();
		
		String nom= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 0);
		String prenom= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 1);
		String cne= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 2);
		String age= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 3);
		String taille= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 4);
		String poid= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 5);
		String img= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 6);
		
		// Afficher la photo de l'etudiant 
		BufferedImage imgLab=null;
		try {imgLab = ImageIO.read(new File(img));} catch (IOException e) {e.printStackTrace();}
		ImageIcon imageIcon = new ImageIcon(imgLab.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JLabel image = new JLabel(imageIcon);
		
		addToGridBag(0, 0, 2, 1);
		this.add(image,gbc);
		//---------------------------------------------
		
		/*
		 * Instancier les JLabels, les initialiser avec les valeurs, et les positionner dans la grille
		 */
		JLabel nomLabel= new JLabel("Nom :");
		nomLabel.setBorder(new EmptyBorder(10,10,10,10));
		JLabel prenomLabel= new JLabel("Prenom :");
		prenomLabel.setBorder(new EmptyBorder(10,10,10,10));
		JLabel ageLabel= new JLabel("Age :");
		ageLabel.setBorder(new EmptyBorder(10,10,10,10));
		JLabel cneLabel= new JLabel("CNE :");
		cneLabel.setBorder(new EmptyBorder(10,10,10,10));
		JLabel tailleLabel= new JLabel("Taille :");
		tailleLabel.setBorder(new EmptyBorder(10,10,10,10));
		JLabel poidLabel= new JLabel("Poids :");
		poidLabel.setBorder(new EmptyBorder(10,10,10,10));
		
		JLabel nomLabel2= new JLabel(nom);
		nomLabel2.setBorder(new EmptyBorder(10,10,10,10));
		JLabel prenomLabel2= new JLabel(prenom);
		prenomLabel2.setBorder(new EmptyBorder(10,10,10,10));
		JLabel ageLabel2= new JLabel(age);
		ageLabel2.setBorder(new EmptyBorder(10,10,10,10));
		JLabel cneLabel2= new JLabel(cne);
		cneLabel2.setBorder(new EmptyBorder(10,10,10,10));
		JLabel tailleLabel2= new JLabel(taille);
		tailleLabel2.setBorder(new EmptyBorder(10,10,10,10));
		JLabel poidLabel2= new JLabel(poid);
		poidLabel2.setBorder(new EmptyBorder(10,10,10,10));
		
		next = new BasicArrowButton(BasicArrowButton.EAST);
		prev = new BasicArrowButton(BasicArrowButton.WEST);
		
		addToGridBag(0, 1, 1, 1);
		this.add(nomLabel,gbc);
		addToGridBag(0, 2, 1, 1);
		this.add(prenomLabel,gbc);
		addToGridBag(0, 3, 1, 1);
		this.add(ageLabel,gbc);
		addToGridBag(0, 4, 1, 1);
		this.add(cneLabel,gbc);
		addToGridBag(0, 5, 1, 1);
		this.add(tailleLabel,gbc);
		addToGridBag(0, 6, 1, 1);
		this.add(poidLabel,gbc);
		
		addToGridBag(1, 1, 1, 1);
		this.add(nomLabel2,gbc);
		addToGridBag(1, 2, 1, 1);
		this.add(prenomLabel2,gbc);
		addToGridBag(1, 3, 1, 1);
		this.add(ageLabel2,gbc);
		addToGridBag(1, 4, 1, 1);
		this.add(cneLabel2,gbc);
		addToGridBag(1, 5, 1, 1);
		this.add(tailleLabel2,gbc);
		addToGridBag(1, 6, 1, 1);
		this.add(poidLabel2,gbc);
		
		addToGridBag(0, 7, 1, 1);
		this.add(prev,gbc);
		addToGridBag(1, 7, 1, 1);
		this.add(next,gbc);
		
		//---------------------------------------
		
		
		/*
		 * Action listener du bouton previous
		 */
		prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				next.setEnabled(true);
				if(sel > 0)
				{
					sel--;
					String nom= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 0);
					String prenom= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 1);
					String age= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 2);
					String cne= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 3);
					String taille= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 4);
					String poid= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 5);
					String img= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 6);
					nomLabel2.setText(nom);
					prenomLabel2.setText(prenom);
					ageLabel2.setText(age);
					cneLabel2.setText(cne);
					tailleLabel2.setText(taille);
					poidLabel2.setText(poid);
					BufferedImage imgLab=null;
					try {imgLab = ImageIO.read(new File(img));} catch (IOException e) {e.printStackTrace();}
					ImageIcon newIm = new ImageIcon(imgLab.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
					image.setIcon(newIm);
					
				}
				else
				{
					//Si on arrive au bord, on desactive le bouton
					prev.setEnabled(false);
				}
			}
		});
		
		/*
		 * Action listener du bouton next
		 */
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prev.setEnabled(true);
				int count = ApplicationLayout.tableau.getRowCount();
				if(sel < count-1)
				{
					sel++;
					String nom= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 0);
					String prenom= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 1);
					String age= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 2);
					String cne= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 3);
					String taille= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 4);
					String poid= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 5);
					String img= (String) ApplicationLayout.tableau.getModel().getValueAt(sel, 6);
					nomLabel2.setText(nom);
					prenomLabel2.setText(prenom);
					ageLabel2.setText(age);
					cneLabel2.setText(cne);
					tailleLabel2.setText(taille);
					poidLabel2.setText(poid);
					BufferedImage imgLab=null;
					try {imgLab = ImageIO.read(new File(img));} catch (IOException e) {e.printStackTrace();}
					ImageIcon newIm = new ImageIcon(imgLab.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
					image.setIcon(newIm);
				}
				else
				{
					//Si on arrive au bord, on desactive le bouton
					next.setEnabled(false);
				}
			}
		});
	}
	
	/**
	 * Cette methode sert a initialiser automatiquement les parametres de positionnement des elements sur le
	 * layout
	 * @param x
	 * @param y
	 * @param gw
	 * @param gh
	 */
	public static void addToGridBag(int x, int y, int gw, int gh)
	{
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = gw;
		gbc.gridheight = gh;
		gbc.fill = GridBagConstraints.HORIZONTAL;
	}
}
