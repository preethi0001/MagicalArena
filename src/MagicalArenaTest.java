import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagicalArenaTest {

    @Test
    void testPlayerCreation() {
        Player player = new Player("Test", 100, 10, 20);
        assertEquals("Test", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(20, player.getAttack());
    }

    @Test
    void testDieRollInRange() {
        Player player = new Player("Test", 100, 10, 20);
        for (int i = 0; i < 1000; i++) {
            int roll = player.rollDie();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

    @Test
    void testDamageCalculation() {
        Player attacker = new Player("Attacker", 100, 10, 20);
        Player defender = new Player("Defender", 100, 10, 20);

        int attackRoll = 6;
        int defenseRoll = 6;

        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;

        int damage = Math.max(attackDamage - defenseStrength, 0);
        int newHealth = defender.getHealth() - damage;

        defender.setHealth(Math.max(newHealth, 0));

        assertEquals(40, defender.getHealth());
    }

    @Test
    void testNegativeDamage() {
        Player attacker = new Player("Attacker", 100, 10, 40);
        Player defender = new Player("Defender", 100, 10, 200);

        int attackRoll = 6;
        int defenseRoll = 6;

        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;

        int damage = Math.max(attackDamage - defenseStrength, 0);
        int newHealth = defender.getHealth() - damage;

        defender.setHealth(Math.max(newHealth, 0));

        assertEquals(0, defender.getHealth());
    }

    @Test
    void testHealthSetToZeroIfNegative() {
        Player player = new Player("Test", 100, 10, 20);
        player.setHealth(-50);
        assertEquals(0, player.getHealth());
    }
    
    @Test
    void testGameEnding() {
        Player playerA = new Player("A", 100, 10, 20);
        Player playerB = new Player("B", 100, 10, 20);

        while (playerA.getHealth() > 0 && playerB.getHealth() > 0) {
            // Attacker attacks and rolls the die
            int attackRollA = playerA.rollDie();
            int attackDamageA = playerA.getAttack() * attackRollA;

            // Defender defends and rolls the die
            int defenseRollB = playerB.rollDie();
            int defenseStrengthB = playerB.getStrength() * defenseRollB;

            // Calculate damage to B
            int damageToB = Math.max(attackDamageA - defenseStrengthB, 0);
            playerB.setHealth(Math.max(playerB.getHealth() - damageToB, 0));

            // Check if player B has lost
            if (playerB.getHealth() <= 0) {
                assertEquals(0, playerB.getHealth());
                break;
            }

            // Attacker attacks and rolls the die
            int attackRollB = playerB.rollDie();
            int attackDamageB = playerB.getAttack() * attackRollB;

            // Defender defends and rolls the die
            int defenseRollA = playerA.rollDie();
            int defenseStrengthA = playerA.getStrength() * defenseRollA;

            // Calculate damage to A
            int damageToA = Math.max(attackDamageB - defenseStrengthA, 0);
            playerA.setHealth(Math.max(playerA.getHealth() - damageToA, 0));

            // Check if player A has lost
            if (playerA.getHealth() <= 0) {
                assertEquals(0, playerA.getHealth());
                break;
            }
        }
    }

}
