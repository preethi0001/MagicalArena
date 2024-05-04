import java.util.Random;

public class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public void setName(int health) {
        this.name = name;
    }

    public int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    @Override
    public String toString() {
        return "Player " + name + " - Health: " + health + ", Strength: " + strength + ", Attack: " + attack;
    }
}