package oop.guessing_game.src.model;

public class Player {

    private String name;
    private int number;
    private int attempts = 0;

    /**
     * Instatiate new Player with a name
     * @param name
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * get Player name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set Player name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get Player number
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * set Player number
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * get Player attempts
     * @return attempts
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * set Player attempts
     * @param attempts
     */
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    /**
     * add Player attempt
     */
    public void addAttempt() {
        this.attempts++;
    }

}