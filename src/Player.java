import java.util.Random;

public class Player {
    private int health;
    private int strength;
    private int attack;

    public Player(int health, int strength, int attack) {
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

    public int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    @Override
    public String toString() {
        return "Player - Health: " + health + ", Strength: " + strength + ", Attack: " + attack;
    }
}
