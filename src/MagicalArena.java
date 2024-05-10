import java.util.Scanner;
public class MagicalArena {
    public Player playerA;
    public Player playerB;

    public MagicalArena(Player A, Player B) {
        playerA = A;
        playerB = B;
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

        //ensure all attributes are greater than or equal to 0
        if(playerA.getHealth() < 0 || playerA.getStrength()< 0 || playerA.getAttack() < 0 ||
                playerB.getHealth() < 0 || playerB.getStrength()< 0 || playerB.getAttack() < 0) {
            System.out.println("Cannot start the battle! Attributes of players should be greater than or equal to 0.");
            return;
        }

        //check to ensure that both players health is not less than or equal to 0
        if(playerA.getHealth() <= 0 && playerB.getHealth() <= 0) {
            System.out.println("Cannot start the battle! Health of atleast one of the players should be greater than 0.");
            return;
        }

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
            System.out.println( playerB.getName() + " wins!");
        } else {
            System.out.println( playerA.getName() + " wins!");
        }

        System.out.println("HEALTH OF PLAYERS AT THE END OF BATTLE");
        System.out.println("PLAYER " + playerA.getName() + ": " + playerA.getHealth() + ", PLAYER " + playerB.getName() + ": " + playerB.getHealth());
        System.out.println("What an exhilarating battle in the Magical Arena!");
    }

    public static void main(String[] args) {
        // Create two players
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details of player 1");
        System.out.println("Enter name of player 1");
        String name = scanner.next();
        System.out.println("Enter health of player 1");
        int health = scanner.nextInt();
        System.out.println("Enter strength of player 1");
        int strength = scanner.nextInt();
        System.out.println("Enter attack power of player 1");
        int attack = scanner.nextInt();

        System.out.println("Enter details of player 2");
        System.out.println("Enter name of player 2");
        String name2 = scanner.next();
        System.out.println("Enter health of player 2");
        int health2 = scanner.nextInt();
        System.out.println("Enter strength of player 2");
        int strength2 = scanner.nextInt();
        System.out.println("Enter attack power of player 2");
        int attack2 = scanner.nextInt();
        Player playerA = new Player(name, health, strength, attack);
        Player playerB = new Player(name2, health2, strength2, attack2);

        // Create a MagicalArena instance and start the game
        MagicalArena arena = new MagicalArena(playerA, playerB);
        arena.startGame();
    }
}