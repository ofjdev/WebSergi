package EstructuraDeDades;

public class Jugador {

	private String nomJugador;
	private int elo;
	private String club;
	
	public Jugador(String nomJugador, int elo, String club) {
		super();
		this.nomJugador = nomJugador;
		this.elo = elo;
		this.club = club;
	}

	public String getNomJugador() {
		return nomJugador;
	}

	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}

	public int getElo() {
		return elo;
	}

	public void setElo(int elo) {
		this.elo = elo;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
	
	
	
	
}
