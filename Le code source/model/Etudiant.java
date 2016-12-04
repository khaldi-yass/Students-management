package model;

import java.util.Vector;

/**
 * La classe Etudiant est la classe contenant tous les proprietes des etudiants
 * @author Yassir
 *
 */
public class Etudiant {
	
	
	private String nom,prenom,cne,imgLink,age,taille,poids;
	public static Vector<Etudiant> liste = new Vector<Etudiant>();
	
	public Etudiant(String n, String pr, String cne, String a, String t, String p, String link) {
		setNom(n);
		setPrenom(pr);
		setCne(cne);
		setAge(a);
		setTaille(t);
		setPoids(p);
		/**
		 * String contenant le lien vers l'image
		 */
		setImgLink(link);
	}

	/**
	 * Ajouter un etudiant a la liste
	 * @param e
	 */
	public static void add(Etudiant e)
	{
		liste.addElement(e);
	}
	
	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
}
