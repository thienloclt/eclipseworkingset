package monprojet.personne;

public class Personne implements Habitant {

	private String nom;
	private Habitation habitation;
	private Vehicule vehicule;

	public void partSePromener() {
		System.out.println(nom + "..." + habitation.partir() + "..." + vehicule.demarre());
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Habitation getHabitation() {
		return habitation;
	}

	public void setHabitation(Habitation habitation) {
		this.habitation = habitation;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
}
