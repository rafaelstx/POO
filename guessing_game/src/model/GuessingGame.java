package oop.guessing_game.src.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class controls all the attributes that a game possesses.
 */
public class GuessingGame {

    private GuessNumbersList numberList;
    private List<Player> players;
    private int numPlayers;

    /**
     * Instatiate new Game
     */
    public GuessingGame() {
        numberList = new GuessNumbersList();
        numberList.generateNumbers();
    }

    /**
     * Game starter function
     */
    public void start() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao jogo de advinhacao");

        players = createPlayers(sc);

        playerAttempt(sc);
        
        showScore();
    }
    /**
     * create players
     * @param in receive a instance of Scanner
     * @return a list of players
     */
    private List<Player> createPlayers(Scanner in) {

        System.out.println("Quantos jogadores:");

        numPlayers = in.nextInt();
        in.nextLine();

        List<Player> players = new ArrayList<>();
        int number;

        for (int i = 0; i < numPlayers; i++) {
            System.out.println(String.format("Digite o nome do jogador %d: ", i+1));
            players.add(new Player(in.nextLine()));
        }

        for (int i = 0; i < numPlayers; i++) {
            
            number = -1;

            while (isInvalidNumber(number)) {
                System.out.println(String.format("Digite o seu numero %s: ", players.get(i).getName()));
                number = in.nextInt();
            }

            players.get(i).setNumber(number);
            
        }

        return players;
    }

    /**
     * get attempts
     * @param in receive a instance of Scanner
     */
    private void playerAttempt(Scanner in) {
        int answer;

        for (int i = 0; i < numPlayers; i++) {

            answer = numberList.numberOccurrences(players.get(i).getNumber());

            System.out.println(String.format("Jogador %s", players.get(i).getName()));
            System.out.println(String.format("Quantas vezes voce acha que %d aparece: ", players.get(i).getNumber()));

            for (int j = 0; j < 5; j++) {
                players.get(i).addAttempt();
                if (guessThermometer(answer, in.nextInt())) {
                    break;
                }
            }
        }
    }
    /**
     * verify if the base number is invalid
     * @param number base number for a player
     * @return true if the number is invalid
     */
    private boolean isInvalidNumber(int number) {
        return !numberList.isValidNumber(number);
    }

    /**
     * print the "temperature" of an attempt to guess
     * @param answer the correctally number of a guess
     * @param guess the player guess in his attempt
     * @return true if the attempt is correct
     */
    private boolean guessThermometer(int answer, int guess) {

        int guessScale;
        String temperature;

        guessScale = Math.abs(answer - guess);

        if (answer == guess) {
            temperature = "Acertou!"; 
            System.out.println(temperature);
            return true;
        } else if (guessScale < 2) {
            temperature = "Quente!"; 
        } else if (guessScale < 3) {
            temperature = "Esquentando!"; 
        } else if (guessScale < 4) {
            temperature = "Frio!"; 
        } else {
            temperature = "Congelado!"; 
        }

        System.out.println(temperature);

        return false;
    }
    /**
     * this function display the game score
     */
    private void showScore() {

        Collections.sort(players, Comparator.comparing(Player::getAttempts));

        System.out.println(" -------------- Vencedor -------------- ");

        System.out.println(String.format("* %s", players.get(0).getName()));

        System.out.println(" ----------- Classificacao Geral ----------- ");

        for (int i = 0; i < numPlayers; i++) {
            System.out.println(String.format("* %d - %s - Tentativas: %d", i+1, players.get(i).getName(), players.get(i).getAttempts()));
        }

        
    }
    
}