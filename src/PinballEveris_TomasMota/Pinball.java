package PinballEveris_TomasMota;

import java.util.Random;

	public class Pinball{
		/**
		 *  Variable de clase que muestra hacia que lado se va la bola durante el juego.
		 */
		private static int side;
		/**
		 *  Objeto Random para crear números aleatorios
		 */
		private static final Random r=new Random();
		/**
		 *  Objeto StringBuilder para mostrar los mensajes por consola.
		 */
		private static final StringBuilder SB=new StringBuilder();
		 
		/** 
		 *  Atributos:
		 *  Primer Atributo: Ball -> Atributo de tipo int para pelota.
		 */
		private int ball;
		 /** 
		  * Segundo Atributo: Error -> Atributo de tipo Booleano para Error (Puede dar un fallo o no).
		  */
		private boolean error;
		/**
		 *  Tercer Atributo: ScoreBoard -> Atributo de tipo long para scoreBoard.
		 */
		private long scoreBoard;
		
		/**
		 *  Constructor sin parámetros que inicializa dos cosas (bola y marcador) 
		 */
		public Pinball() {
			super();
			this.ball=3;
			this.scoreBoard=0;
		}

		/**
		 *  Getter para los lados
		 */
		public static int getSide() {
			return side;
		}

		/**
	     *  Setter para los lados
		 */
		public static void setSide(int side) {
			Pinball.side=side;
		}
		
		/**
		 *  Getter de numero ramdom
		 */
		public static Random getR() {
			return r;
		}
		
		/**
		 *  Getter de la pelota
		 */
		public int getBall() {
			return ball;
		}

		/**
		   Setter de la pelota
		 */
		public void setBall(int ball) {
			this.ball=ball;
		}

		/**
		 * Devuelve el error
		 */
		public boolean isError() {
			return error;
		}

		/**
	     *  Setter del Error
		 */
		public void setError(boolean error) {
			this.error=error;
		}

		/**
		 *  Getter para la puntuacion
		 */
		public long getscoreBoard() {
			return scoreBoard;
		}

		/**
		 *  Setter para la puntuacion
		 */
		public void setscoreBoard(long scoreBoard) {
			this.scoreBoard=scoreBoard;
		}
		
		/**
		 *  Método para que lance una nueva bola
		 */
		public void launchBall() {
			System.out.println("TIN TIN TIN... y sale una nueva bola");
			//Se le resta una bola por cada partida inicializada.
			this.setBall(this.getBall()-1);
			//La variable de error se convierte a FALSE.
			this.setError(Boolean.FALSE);
			//Se obtiene el primer lado aleatorio hacia el que va la bola
			getRandomSide();
		}

		/**
		 *  Método para jugar cada bola tirada
		 */
		public void playGame(int sideChoosen) {
			int pointsMove=getPointsMove();
			SB.setLength(0);
			SB.append("TIN, TIN, TIN... Puntuación de esta jugada: ").append(pointsMove);
			System.out.println(SB);
			//Se suman al total los puntos de la jugada
			this.scoreBoard+=pointsMove;
			// Si el lado elegido es el mismo que el aleatorio, obtiene un nuevo lado aleatorio, si no, alerta del fallo y cambia fail a true
			if (Pinball.side==sideChoosen) {
				getRandomSide();
			} else {
				System.out.println("¡¡TIN, TIN, TIN...!oh no ha fallado");
				this.setError(Boolean.TRUE);
			}
		}

		/**
		 *  Método donde recoge los puntos de una partida.
		 */
		private int getPointsMove() {
			int pointsMove=r.nextInt(100+1)*100;
			return pointsMove;
		}

		/**
		 *  Método para saber a que lado se va la bola
		 */
		private void getRandomSide() {
			
			int randomSide=r.nextInt(1+1);
			if (randomSide==1) {
				System.out.println("TIN,TIN,TIN... el recorrido de la bola es con dirección a la izquierda");
			}else{
				System.out.println("TIN,TIN,TIN... el recorrido de la bola es con dirección a la derecha");
			//Se cambia la variable de clase side
			Pinball.setSide(randomSide);
			}
		}
		

		/**
		 *  Método para que la partida termine, reecuente el marcador de cada jugada para que de un marcador final.
		 */
		public void finishGame() {
			SB.setLength(0);
			SB.append("PIU,PIU,PIU... y el marcador final de la partida es: ").append(this.getscoreBoard());
			System.out.println(SB);
		}
}
