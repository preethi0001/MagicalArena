public class MagicalArena {
    private Player playerA;
    private Player playerB;

    public MagicalArena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    // Method to start the game
    public void startGame() {
        // Display welcome message and player information
        System.out.println("Welcome to the Magical Arena!");
        System.out.println("Get ready for an epic battle between two mighty warriors!");
        System.out.println(playerA);
        System.out.println(playerB);
        System.out.println("Let the battle begin!\n");

        // Start the fight
        fight();
    }

    // Method to simulate the fight
    public void fight() {
        // Determine who attacks first based on health
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        // Continue the fight until one player's health reaches 0
        while (playerA.getHealth() > 0 && playerB.getHealth() > 0) {
            // Roll dice for attack and defense
            int attackRoll = attacker.rollDie();
            int defenseRoll = defender.rollDie();

            // Print attack and defense details
            System.out.println(attacker + " attacks and rolls die: " + attackRoll);
            System.out.println(defender + " defends and rolls die: " + defenseRoll);

            // Calculate attack damage and defense strength
            int attackDamage = attackRoll * attacker.getAttack();
            int defenseStrength = defenseRoll * defender.getStrength();

            // Calculate the actual damage dealt to the defender
            int damage = Math.max(0, attackDamage - defenseStrength);

            // Reduce defender's health by the damage dealt
            defender.setHealth(defender.getHealth() - damage);

            System.out.print("Attack damage: " + attackDamage + ", Defense strength: " + defenseStrength);

            // Print updated defender's health
            System.out.println(", health reduced by " + damage + " to " + defender.getHealth());
            System.out.println("Updated defender's health " + defender);
            System.out.println();


            // Switch roles for the next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        // Print the winner of the game
        if (playerA.getHealth() <= 0) {
            System.out.println("Player " + playerB.getName() + " wins!");
        } else {
            System.out.println("Player " + playerA.getName() + " wins!");
        }
    }

    public static void main(String[] args) {
        // Create two players
        Player playerA = new Player("A", 100, 5, 10);
        Player playerB = new Player("B", 50, 10, 5);

        // Create a MagicalArena instance and start the game
        MagicalArena arena = new MagicalArena(playerA, playerB);
        arena.startGame();
    }
}