package oop.guessing_game.src;

import oop.guessing_game.src.model.GuessingGame;

/**
 *
 * This class serves as the starter/entrance of the entire project.
 * Only this class has the main() method.
 */
public class Main {

    public static void main(String[] args) {

        GuessingGame game = new GuessingGame();
        game.start();        

    }
}