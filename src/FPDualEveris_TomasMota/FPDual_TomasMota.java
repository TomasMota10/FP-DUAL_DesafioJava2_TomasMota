package FPDualEveris_TomasMota;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PinballEveris_TomasMota.Pinball;
import PinballEveris_TomasMota.Scores;

public class FPDual_TomasMota {

	/** Objeto Scanner para Texto que se usara durante la partida */
	private static final Scanner scText=new Scanner(System.in);

	/** Lista para las Puntuaciones */
	private static final List<Scores>SCORE_LIST=new ArrayList<>();

	/** Objeto StringBuilder para mostrar los mensajes por consola */
	private static final StringBuilder SB= new StringBuilder();
	
	/**
	 * M�todo principal de la aplicaci�n
	 */
	public static void main(String[] args) {
		System.out.println("---- GALAXY PAINBALL BY TOMAS MOTA ----");
	int selector=0;
	do {
		// Imprime por pantalla el menu de selecci�n dentro del juego
		System.out.println("\nElige la opci�n que deseas:\nOpci�n 1. Jugar partida.\nOpci�n 2. Consultar los registros de los jugadores.\nOpci�n 3. Salir del juego.");
		try {
			// Objeto Scanner para Numero que se usara durante la partida 
			Scanner scNum=new Scanner(System.in);
			selector=scNum.nextInt();
			
		} catch(Exception e) {
			System.out.println(e.toString());
			selector=0;
		}
		// Se eval�a qu� opci�n elegida y se ejecutara un m�todo u otro. 
		switch(selector) {
		case 1:
			startGame();
			break;
		case 2:
			scoreHistory();
			break;
		case 3:
			break;
		default:
			System.out.println("La opcion "+selector+" no esta disponible en este momento");
		}
	} while (selector!=3);
	System.out.println("Has salido del programa.");
	}
	
	/**
	 * Metodo que hace empezar el juego
	 */
	private static void startGame(){
		// Se crea el objeto 
		Pinball pain=new Pinball();
		System.out.println("Introduce el nombre del jugador para esta partida:");
		Scores score=new Scores(scText.nextLine());
		System.out.println(" LADO IZQUIERDO -> BOT�N A ---- LADO DERECHO -> BOT�N D ---- ACEPTAR -> ENTER");

		while (pain.getBall()!=0) {
			// Se lanzara una bola nueva
			pain.launchBall();
			// La partida progresara normal mientras no hay ningun fallo en la misma
			while (!pain.isError()) {
				pain.playGame(sideChoosen());
			}
		}
		// Se termina la partida y se muestra la puntuacion final de la partida 
		pain.finishGame();
		// La puntuaci�n de la partida se asigna a la partida
		score.setScore(pain.getscoreBoard());
		// Se a�ade al historial de los jugadores que han jugado a este juego
		SCORE_LIST.add(score);
	}
	
	/** Metodo que elige el lado (depende de la opcion elegida devuelve 0 o 1) */
	private static int sideChoosen() {
		String selectorStr="";
		int selectorInt=0;	
		while(!(selectorStr.equalsIgnoreCase("a")||selectorStr.equalsIgnoreCase("d"))){
			try {
				selectorStr=scText.nextLine();
			} catch(Exception e) {
				System.out.println(e.toString());
				selectorStr="";
			}
			selectorInt=selectorStr.equalsIgnoreCase("a")?0:1;
		}
		return selectorInt;
	}
	
	/** Metodo que ense�a el historial de los jugadores que han jugado a este juego*/
	private static void scoreHistory() {
			for (Scores scores:SCORE_LIST) {
				SB.setLength(0);
				SB.append(scores.getPlayer()).append(": ").append(scores.getScore()).append(" puntos de galaxia.");
				System.out.println(SB);
			}

		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





