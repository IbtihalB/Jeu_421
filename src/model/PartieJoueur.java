package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the partie_joueurs database table.
 * 
 */
@Entity
@Table(name="partie_joueurs")
@NamedQuery(name="PartieJoueur.findAll", query="SELECT p FROM PartieJoueur p")
public class PartieJoueur implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PartieJoueurPK id;

	@Column(name="debut_partie")
	private Timestamp debutPartie;

	@Column(name="fin_partie")
	private Timestamp finPartie;

	@Column(length=40)
	private String invitation;

	private int ordre;

	//bi-directional many-to-one association to Joueur
	@ManyToOne
	@JoinColumn(name="ID_joueur", nullable=false)
	private Joueur joueur;

	//bi-directional many-to-one association to Partie
	@ManyToOne
	@JoinColumn(name="ID_partie", nullable=false)
	private Partie partie;

	public PartieJoueur() {
	}

	public PartieJoueurPK getId() {
		return this.id;
	}

	public void setId(PartieJoueurPK id) {
		this.id = id;
	}

	public Timestamp getDebutPartie() {
		return this.debutPartie;
	}

	public void setDebutPartie(Timestamp debutPartie) {
		this.debutPartie = debutPartie;
	}

	public Timestamp getFinPartie() {
		return this.finPartie;
	}

	public void setFinPartie(Timestamp finPartie) {
		this.finPartie = finPartie;
	}

	public String getInvitation() {
		return this.invitation;
	}

	public void setInvitation(String invitation) {
		this.invitation = invitation;
	}

	public int getOrdre() {
		return this.ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Partie getPartie() {
		return this.partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

}