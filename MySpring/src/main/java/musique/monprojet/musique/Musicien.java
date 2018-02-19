package monprojet.musique;

public class Musicien implements Performeur {
	private String morceau;
	private Instrument instrument;

	public void performe() {
		System.out.println(morceau);
		instrument.jouer1();
	}
	
	public void setMorceau(String morceau) {
		this.morceau = morceau;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
