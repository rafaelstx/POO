package oop.guessing_game.src.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Util class to abstract guess number list utilities for the Guessing Game
 */
public class GuessNumbersList { 

    private final int QUANTITY = 100;
    private List<Integer> numbers = new ArrayList<>();

    /**
     * Instatiate new GuessNumberList
     */
    public GuessNumbersList() {

    }
    
    /**
     * get GuessNumberList numbers
     * @return numbers
     */
    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * set GuessNumberList numbers
     * @param numbers
     */
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * generate a list of random numbers
     */
    public void generateNumbers() {

        Random r = new Random();

        for (int i = 0; i < QUANTITY; i++) {
            numbers.add(r.nextInt(QUANTITY));
        }

        Collections.sort(numbers);
    }

    /**
     * verify if its a valid number
     * @return true if contains the number and false if not
     */
    public boolean isValidNumber(int n) {
        return numbers.contains(n);
    }

    /**
     * get number of ocurrences
     * @return number of occurrences of a guess
     */
    public int numberOccurrences(int guess) {
        return Collections.frequency(numbers, guess);
    }

}