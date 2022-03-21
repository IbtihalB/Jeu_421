package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tour database table.
 * 
 */
@Entity
@Table(name="tour")
@NamedQuery(name="Tour.findAll", query="SELECT t FROM Tour t")
public class Tour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int num_tour;

	private int jetons;

	@Column(length=40)
	private String type;

	//bi-directional many-to-one association to Lance
	@OneToMany(mappedBy="tourBean")
	private List<Lance> lances;

	//bi-directional many-to-one association to Joueur
	@ManyToOne
	@JoinColumn(name="joueur")
	private Joueur joueurBean;

	public Tour() {
	}

	public int getNum_tour() {
		return this.num_tour;
	}

	public void setNum_tour(int num_tour) {
		this.num_tour = num_tour;
	}

	public int getJetons() {
		return this.jetons;
	}

	public void setJetons(int jetons) {
		this.jetons = jetons;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Lance> getLances() {
		return this.lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public Lance addLance(Lance lance) {
		getLances().add(lance);
		lance.setTourBean(this);

		return lance;
	}

	public Lance removeLance(Lance lance) {
		getLances().remove(lance);
		lance.setTourBean(null);

		return lance;
	}

	public Joueur getJoueurBean() {
		return this.joueurBean;
	}

	public void setJoueurBean(Joueur joueurBean) {
		this.joueurBean = joueurBean;
	}

}