package actions;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import controller.MyActionListener;
import model.Constants;
import model.Etudiant;
import view.BgPanel;
import controller.ApplicationLayout;

/**
 * 
 *<strong>Description</strong><br>
 * 
 * Ajouter est la classe qui génère le JPanel de la fenetre ajouter<br>
 * 
 * @author yassir
 * 
 */
public class Ajouter extends BgPanel{

	private static final long serialVersionUID = 2421152810259517950L;
	
	//-------------------------------------------------
	/**
	 * Variable statique du layout manager
	 */
	private static GridBagLayout gbl;
	/**
	 * Variable statique du layout manager
	 */
	private static GridBagConstraints gbc;
	/**
	 * Le label dans lequel on stock l'image
	 */
	private JLabel image;
	private String imageLink;
	/**
	 * Tableau utilisé pour la verification des données saisis
	 */
	private boolean valid[] = new boolean[7];

	public Ajouter() {
		
		//Instanciation des layouts
		gbl = new GridBagLayout();
		this.setLayout(gbl);
		this.setBorder(new EmptyBorder(20,20,20,20));
		gbc = new GridBagConstraints();
		//---------------------------------------------
		
		// Afficher la photo par defaut 
		BufferedImage imgLab=null;
		try {imgLab = ImageIO.read(new File("images/user.png"));} catch (IOException e) {e.printStackTrace();}
		ImageIcon imageIcon = new ImageIcon(imgLab.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		image = new JLabel(imageIcon);
		addToGridBag(0, 0, 1, 1);
		this.add(image,gbc);
		
		JButton browse = new JButton("Browse");
		addToGridBag(0, 1, 1, 1);
		this.add(browse,gbc);
		
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
		
		JTextField nomLabel2= new JTextField(20);
		JTextField prenomLabel2= new JTextField(20);
		JTextField ageLabel2= new JTextField(20);
		JTextField cneLabel2= new JTextField(20);
		JTextField tailleLabel2= new JTextField(20);
		
		JSlider tailleSlider = new JSlider(JSlider.VERTICAL,Constants.T_MIN, Constants.T_MAX, Constants.T_INIT);
		tailleSlider.setMajorTickSpacing(50);
		tailleSlider.setMinorTickSpacing(10);
		tailleSlider.setPaintTicks(true);
		tailleSlider.setPaintLabels(true);
		tailleSlider.setOpaque(false);
		
		JTextField poidLabel2= new JTextField(20);
		JSlider poidSlider = new JSlider(JSlider.HORIZONTAL,Constants.P_MIN, Constants.P_MAX, Constants.P_INIT);
		poidSlider.setMajorTickSpacing(50);
		poidSlider.setMinorTickSpacing(10);
		poidSlider.setPaintTicks(true);
		poidSlider.setPaintLabels(true);
		poidSlider.setOpaque(false);
		
		addToGridBag(1, 1, 1, 1);
		this.add(nomLabel,gbc);
		addToGridBag(1, 2, 1, 1);
		this.add(prenomLabel,gbc);
		addToGridBag(1, 3, 1, 1);
		this.add(ageLabel,gbc);
		addToGridBag(1, 4, 1, 1);
		this.add(cneLabel,gbc);
		addToGridBag(1, 5, 1, 1);
		this.add(tailleLabel,gbc);
		addToGridBag(1, 6, 1, 1);
		this.add(poidLabel,gbc);
		
		
		addToGridBag(2, 1, 1, 1);
		this.add(nomLabel2,gbc);
		addToGridBag(2, 2, 1, 1);
		this.add(prenomLabel2,gbc);
		addToGridBag(2, 3, 1, 1);
		this.add(ageLabel2,gbc);
		addToGridBag(2, 4, 1, 1);
		this.add(cneLabel2,gbc);
		addToGridBag(2, 5, 1, 1);
		this.add(tailleLabel2,gbc);		
		addToGridBag(2, 6, 1, 1);
		this.add(poidLabel2,gbc);
		addToGridBag(2, 7, 2, 1);
		this.add(poidSlider,gbc);
		addToGridBag(4, 1, 1, 7);
		this.add(tailleSlider,gbc);
		
		JButton valider = new JButton("Valider");
		addToGridBag(1, 8, 1, 1);
		this.add(valider,gbc);
		
		JPanel filler = new JPanel();
		filler.setPreferredSize(new Dimension(30,0));
		addToGridBag(3, 0, 1, 1);
		this.add(filler,gbc);
		
		//-------------------------------------------------------
		//On stock notre JPanel dans cette variable, on l'utilisera dans les ActionListeners
		JPanel pane=this;
		//-------------------------------------------------------
		
		/*
		 * Action listener du bouton valider
		 */
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * Utilisation des expressions regulieres pour la verification
				 */
				String regName = "\\w{4,30}";
				String regAge = "\\d{2}";
				String regCne = "[A-Z0-9a-z]{8}";
				String regT = "1[3-9][0-9]|2[0-4][0-9]|250";
				String regP = "[4-9][0-9]|1[0-4][0-9]|150";
				
				/**
				 * Tester les champs de saisis avant de les affecter au variables
				 */
				String nom=nomLabel2.getText();
				if(nom != null && !nom.isEmpty() && Pattern.matches(regName, nom)) valid[0]=true;
				String prenom=prenomLabel2.getText();
				if(prenom != null && !prenom.isEmpty() && Pattern.matches(regName, prenom)) valid[1]=true;
				String cne=cneLabel2.getText();
				if(cne != null && !cne.isEmpty() && Pattern.matches(regCne, cne)) valid[2]=true;
				String age=ageLabel2.getText();
				if(age != null && !age.isEmpty() && Pattern.matches(regAge, age)) valid[3]=true;
				String taille=tailleLabel2.getText();
				if(taille != null && !taille.isEmpty() && Pattern.matches(regT, taille)) valid[4]=true;
				String poid=poidLabel2.getText();
				if(poid != null && !poid.isEmpty() && Pattern.matches(regP, poid)) valid[5]=true;
				String img= imageLink;

				
				boolean check=true;
				//Si un champs est invalide on affiche une erreur avec le numero du champs
				for (int i=0;i<6;i++){
					if(!valid[i]){
						check=false;
						
						String err="";
						switch(i)
						{
						case 0:
							err="Le nom ne doit contenir que des lettres [4-30].";
							break;
						case 1:
							err="Le prenom ne doit contenir que des lettres [4-30].";
							break;
						case 2:
							err="Le CNE ne doit contenir que des alphanumeriques [8].";
							break;
						case 3:
							err="L'age ne doit contenir que des chiffres [2].";
							break;
						case 4:
							err="La taille ne doit contenir que des entiers ["+Constants.T_MIN+"-->"+Constants.T_MAX+"].";
							break;
						case 5:
							err="Le poid ne doit contenir que des entiers ["+Constants.P_MIN+"-->"+Constants.P_MAX+"].";
							break;
						}
						
						
						JOptionPane.showMessageDialog(pane,
							    "Un champs de saisi contient une valeur invalide: Champs numéro "+(i+1)+"\n"+err
							    ,"Attention",
							    JOptionPane.WARNING_MESSAGE);
						break;
				}	}
				if(check){
					Etudiant.add(new Etudiant(nom, prenom, cne, age, taille, poid, img));
					((DefaultTableModel) ApplicationLayout.tableau.getModel()).addRow(new Object[]{nom,prenom,cne,age,taille,poid,img});
					MyActionListener.addPopup.dispose();
				}
			}
		});
		//-------------------------------------------------------
		
		//Liaison du Slider avec son textfield approprié 
		poidSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {	
				poidLabel2.setText(Integer.toString(poidSlider.getValue()));
			}
		});
		//-------------------------------------------------------
		
		//Liaison du Slider avec son textfield approprié 
		tailleSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {	
				tailleLabel2.setText(Integer.toString(tailleSlider.getValue()));
			}
		});
		//-------------------------------------------------------
		
		//Liaison du textfield avec son slider approprié 
		poidLabel2.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyPressed(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				int val=0;
				try {val = Integer.parseInt(poidLabel2.getText());} catch (Exception e) {}
				if(val>=40 && val<=150) poidSlider.setValue(val);
			}
		});
		//-------------------------------------------------------
		
		//Liaison du textfield avec son slider approprié 
		tailleLabel2.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyPressed(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				int val=0;
				try {val = Integer.parseInt(tailleLabel2.getText());} catch (Exception e) {}
				if(val>=130 && val<=210) tailleSlider.setValue(val);
			}
		});
		
		//-------------------------------------------------------
		
		//Le bouton upload d'image
		browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Genere une nouvelle fenetre de choix de fichier
				JFileChooser browse = new JFileChooser();
				browse.setCurrentDirectory(new File(System.getProperty("user.home")));
				browse.setFileFilter(new FileNameExtensionFilter("Fichiers d'images", "jpg", "png", "gif", "jpeg", "bmp"));
				int result = browse.showOpenDialog(pane);
				
				
				//Recuperer le fichier image et l'afficher sur le panel
				if(result == JFileChooser.APPROVE_OPTION)
				{
					File source = browse.getSelectedFile();
					BufferedImage imgLab=null;
					try {imgLab = ImageIO.read(source);} catch (IOException e) {e.printStackTrace();}
					ImageIcon newIm = new ImageIcon(imgLab.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
					imageLink = source.getPath();
					image.setIcon(newIm);
					valid[6]=true;
				}
			}
		});
		
		
		//-------------------------------------------------
		
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
