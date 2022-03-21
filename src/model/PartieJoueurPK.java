package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the partie_joueurs database table.
 * 
 */
@Embeddable
public class PartieJoueurPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=40)
	private String ID_joueur;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int ID_partie;

	public PartieJoueurPK() {
	}
	public String getID_joueur() {
		return this.ID_joueur;
	}
	public void setID_joueur(String ID_joueur) {
		this.ID_joueur = ID_joueur;
	}
	public int getID_partie() {
		return this.ID_partie;
	}
	public void setID_partie(int ID_partie) {
		this.ID_partie = ID_partie;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PartieJoueurPK)) {
			return false;
		}
		PartieJoueurPK castOther = (PartieJoueurPK)other;
		return 
			this.ID_joueur.equals(castOther.ID_joueur)
			&& (this.ID_partie == castOther.ID_partie);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ID_joueur.hashCode();
		hash = hash * prime + this.ID_partie;
		
		return hash;
	}
}