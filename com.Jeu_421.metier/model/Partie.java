package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partie database table.
 * 
 */
@Entity
@Table(name="partie")
@NamedQuery(name="Partie.findAll", query="SELECT p FROM Partie p")
public class Partie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int ID_partie;

	@Column(length=40)
	private String gagnant;

	@Column(length=40)
	private String hote;

	//bi-directional many-to-one association to PartieJoueur
	@OneToMany(mappedBy="partie")
	private List<PartieJoueur> partieJoueurs;

	public Partie() {
	}

	public int getID_partie() {
		return this.ID_partie;
	}

	public void setID_partie(int ID_partie) {
		this.ID_partie = ID_partie;
	}

	public String getGagnant() {
		return this.gagnant;
	}

	public void setGagnant(String gagnant) {
		this.gagnant = gagnant;
	}

	public String getHote() {
		return this.hote;
	}

	public void setHote(String hote) {
		this.hote = hote;
	}

	public List<PartieJoueur> getPartieJoueurs() {
		return this.partieJoueurs;
	}

	public void setPartieJoueurs(List<PartieJoueur> partieJoueurs) {
		this.partieJoueurs = partieJoueurs;
	}

	public PartieJoueur addPartieJoueur(PartieJoueur partieJoueur) {
		getPartieJoueurs().add(partieJoueur);
		partieJoueur.setPartie(this);

		return partieJoueur;
	}

	public PartieJoueur removePartieJoueur(PartieJoueur partieJoueur) {
		getPartieJoueurs().remove(partieJoueur);
		partieJoueur.setPartie(null);

		return partieJoueur;
	}

}