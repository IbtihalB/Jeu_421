package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the joueur database table.
 * 
 */
@Entity
@Table(name="joueur")
@NamedQuery(name="Joueur.findAll", query="SELECT j FROM Joueur j")
public class Joueur implements JpaEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, length=40)
	private String pseudo;

	private int age;

	@Column(name="connected_at")
	private Timestamp connectedAt;

	@Column(name="disconnected_at")
	private Timestamp disconnectedAt;

	@Column(name="mot_de_passe", nullable=false, length=40)
	private String motDePasse;

	@Column(name="nb_moyen_jetons_charge")
	private float nbMoyenJetonsCharge;

	@Column(name="nb_moyen_jetons_decharge")
	private float nbMoyenJetonsDecharge;

	@Column(name="nb_moyen_victoires")
	private float nbMoyenVictoires;

	@Column(name="nb_parties_jouees")
	private int nbPartiesJouees;

	@Column(name="nb_victoires")
	private int nbVictoires;

	@Column(length=40)
	private String sexe;

	@Column(length=40)
	private String ville;

	//bi-directional many-to-one association to Lance
	@OneToMany(mappedBy="joueurBean")
	private List<Lance> lances;

	//bi-directional many-to-one association to PartieJoueur
	@OneToMany(mappedBy="joueur")
	private List<PartieJoueur> partieJoueurs;

	//bi-directional many-to-one association to Tour
	@OneToMany(mappedBy="joueurBean")
	private List<Tour> tours;

	public Joueur() {
	}

	public Joueur(String pseudo, String mot_passe) {
		// TODO Auto-generated constructor stub
		this.pseudo=pseudo;
		this.motDePasse=mot_passe;
	}

	

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Timestamp getConnectedAt() {
		return this.connectedAt;
	}

	public void setConnectedAt(Timestamp connectedAt) {
		this.connectedAt = connectedAt;
	}

	public Timestamp getDisconnectedAt() {
		return this.disconnectedAt;
	}

	public void setDisconnectedAt(Timestamp disconnectedAt) {
		this.disconnectedAt = disconnectedAt;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public float getNbMoyenJetonsCharge() {
		return this.nbMoyenJetonsCharge;
	}

	public void setNbMoyenJetonsCharge(float nbMoyenJetonsCharge) {
		this.nbMoyenJetonsCharge = nbMoyenJetonsCharge;
	}

	public float getNbMoyenJetonsDecharge() {
		return this.nbMoyenJetonsDecharge;
	}

	public void setNbMoyenJetonsDecharge(float nbMoyenJetonsDecharge) {
		this.nbMoyenJetonsDecharge = nbMoyenJetonsDecharge;
	}

	public float getNbMoyenVictoires() {
		return this.nbMoyenVictoires;
	}

	public void setNbMoyenVictoires(float nbMoyenVictoires) {
		this.nbMoyenVictoires = nbMoyenVictoires;
	}

	public int getNbPartiesJouees() {
		return this.nbPartiesJouees;
	}

	public void setNbPartiesJouees(int nbPartiesJouees) {
		this.nbPartiesJouees = nbPartiesJouees;
	}

	public int getNbVictoires() {
		return this.nbVictoires;
	}

	public void setNbVictoires(int nbVictoires) {
		this.nbVictoires = nbVictoires;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Lance> getLances() {
		return this.lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public Lance addLance(Lance lance) {
		getLances().add(lance);
		lance.setJoueurBean(this);

		return lance;
	}

	public Lance removeLance(Lance lance) {
		getLances().remove(lance);
		lance.setJoueurBean(null);

		return lance;
	}

	public List<PartieJoueur> getPartieJoueurs() {
		return this.partieJoueurs;
	}

	public void setPartieJoueurs(List<PartieJoueur> partieJoueurs) {
		this.partieJoueurs = partieJoueurs;
	}

	public PartieJoueur addPartieJoueur(PartieJoueur partieJoueur) {
		getPartieJoueurs().add(partieJoueur);
		partieJoueur.setJoueur(this);

		return partieJoueur;
	}

	public PartieJoueur removePartieJoueur(PartieJoueur partieJoueur) {
		getPartieJoueurs().remove(partieJoueur);
		partieJoueur.setJoueur(null);

		return partieJoueur;
	}

	public List<Tour> getTours() {
		return this.tours;
	}

	public void setTours(List<Tour> tours) {
		this.tours = tours;
	}

	public Tour addTour(Tour tour) {
		getTours().add(tour);
		tour.setJoueurBean(this);

		return tour;
	}

	public Tour removeTour(Tour tour) {
		getTours().remove(tour);
		tour.setJoueurBean(null);

		return tour;
	}

}