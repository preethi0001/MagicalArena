public class MagicalArena {
    private Player playerA;
    private Player playerB;

    public MagicalArena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void fight() {
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (playerA.getHealth() > 0 && playerB.getHealth() > 0) {
            int attackRoll = attacker.rollDie();
            int defenseRoll = defender.rollDie();

            int attackDamage = attackRoll * attacker.getAttack();
            int defenseStrength = defenseRoll * defender.getStrength();

            int damage = Math.max(0, attackDamage - defenseStrength);
            defender.setHealth(defender.getHealth() - damage);

            System.out.println(attacker + " attacks and rolls die: " + attackRoll);
            System.out.println(defender + " defends and rolls die: " + defenseRoll);
            System.out.println("Attack damage: " + attackDamage);
            System.out.println("Defense strength: " + defenseStrength);
            System.out.println(defender + " health reduced by " + damage + " to " + defender.getHealth());
            System.out.println();

            // Switch roles for the next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (playerA.getHealth() <= 0) {
            System.out.println("Player B wins!");
        } else {
            System.out.println("Player A wins!");
        }
    }

    public static void main(String[] args) {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        MagicalArena arena = new MagicalArena(playerA, playerB);
        arena.fight();
    }
}
