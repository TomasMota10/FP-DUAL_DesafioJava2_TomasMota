package PinballEveris_TomasMota;

public class Scores {
	
	/**
	 * Variable de instancia
	 */
	private final String player;
	private long score;
	
	/**
	 * Constructor con el parametro jugador
	 */
	public Scores(String player) {
		super();
		this.player=player;
	}
    
	/**
	 * Getter para la puntuacion
	 */
	public long getScore() {
		return score;
	}

	/**
	 * Setter para la puntuacion
	 */
	public void setScore(long score) {
		this.score=score;
	}

	/**
	 * Getter para el jugador
	 */
	public String getPlayer() {
		return player;
	}
	
}
