import java.util.Random;

// Player class to represent a player in the Magical Arena
public class Player {
    private String name;    // Name of the player
    private int health;     // Health attribute of the player
    private int strength;   // Strength attribute of the player
    private int attack;     // Attack attribute of the player

    // Constructor to initialize the player with name, health, strength, and attack
    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    // Getter method to retrieve the health of the player
    public int getHealth() {
        return health;
    }

    // Setter method to set the health of the player
    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    // Getter method to retrieve the strength of the player
    public int getStrength() {
        return strength;
    }

    // Getter method to retrieve the attack of the player
    public int getAttack() {
        return attack;
    }

    // Getter method to retrieve the name of the player
    public String getName() {
        return name;
    }

    // Setter method to set the name of the player
    public void setName(int health) {
        this.name = name;
    }

    // Method to roll a die and return a random value between 1 and 6
    public int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // Override toString() method to display player details
    @Override
    public String toString() {
        return "Player " + name + " - Health: " + health + ", Strength: " + strength + ", Attack: " + attack;
    }
}