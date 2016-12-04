package view;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * <strong>Description</strong><br>
 * Cette class genere une nouvelle fenetre avec des parametres automatique<Br>
 * Utile pour ne pas reecrire le meme code plusieurs fois<br>
 * 
 */
public class Window extends JFrame
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4568913967019175915L;


	/**
	 * Le constructeur par defaut de la classe
	 */
	public Window()
	{
		setTitle("Default");
		setSize(800,450);
		setMinimumSize(new Dimension(800,450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Constructeur avec arguments
	 * @param w : largeur de fenetre
	 * @param h : hauteur de fenetre
	 * @param t : titre de la fenetre
	 */
	public Window(int w, int h, String t)
	{
		setTitle(t);
		setSize(w,h);
		setMinimumSize(new Dimension(w,h));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	
	/**
	 * Methode appele a la fin du Layout pour afficher la JFrame<br>
	 * Cette methode doit etre appelee a la fin du programme
	 */
	public void visible() 
	{
		setVisible(true);
	}
	
	
	
	
}