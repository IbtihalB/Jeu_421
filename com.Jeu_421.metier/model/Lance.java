package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lances database table.
 * 
 */
@Entity
@Table(name="lances")
@NamedQuery(name="Lance.findAll", query="SELECT l FROM Lance l")
public class Lance implements JpaEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private float n_lances;

	private float combinaison;

	//bi-directional many-to-one association to Joueur
	@ManyToOne
	@JoinColumn(name="joueur")
	private Joueur joueurBean;

	//bi-directional many-to-one association to Tour
	@ManyToOne
	@JoinColumn(name="Tour")
	private Tour tourBean;

	public Lance() {
	}

	public float getN_lances() {
		return this.n_lances;
	}

	public void setN_lances(float n_lances) {
		this.n_lances = n_lances;
	}

	public float getCombinaison() {
		return this.combinaison;
	}

	public void setCombinaison(float combinaison) {
		this.combinaison = combinaison;
	}

	public Joueur getJoueurBean() {
		return this.joueurBean;
	}

	public void setJoueurBean(Joueur joueurBean) {
		this.joueurBean = joueurBean;
	}

	public Tour getTourBean() {
		return this.tourBean;
	}

	public void setTourBean(Tour tourBean) {
		this.tourBean = tourBean;
	}

}