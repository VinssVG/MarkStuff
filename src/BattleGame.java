//Mark Sollazzo
//260873844
import java.util.Scanner;
import java.util.Random;

class BattleGame
{
    private static Random randomGenerator = new Random();
    
    public static void playGame(String character, String monster)
    {
        FileIO.readCharacter(character);
        FileIO.readCharacter(monster);
    }
    
    public static void main(String[] args)
    {
        playGame("character.txt", "monster.txt");

        Character mark = new Character("Mark", 10, 60, 0);

        System.out.println("Name      : " + mark.getName());
        System.out.println("MaxHealth : " + mark.getMaxHealth());
        System.out.println("Wins      : " + mark.getNumWins());
        System.out.println("TooString : " + mark.toString());
        System.out.println("Damage    : " + mark.getAttackDamage(123));
        System.out.println("Damage    : " + mark.getAttackDamage(456));
        System.out.println("Damage    : " + mark.getAttackDamage(789));
        System.out.println();

        SimulateFight(123);
        SimulateFight(456);
        SimulateFight(789);
    }

    static void SimulateFight(int seed)
    {
        Random randomGenerator = new Random(seed);

        Character player1 = new Character("Mark", 20, 20, 0);
        Character player2 = new Character("Vincent", 5, 80, 0);

        System.out.println(player1.getName() + " VS " + player2.getName());

        int round = 1;
        while(player1.getCurrHeatlh() > 0 && player2.getCurrHeatlh() > 0)
        {
            System.out.println("Round " + round + "   START");
            System.out.println("Player 1 : " + player1.toString());
            System.out.println("Player 2 : " + player2.toString());

            double player1AttackDamage = player1.getAttackDamage(randomGenerator.nextInt());
            double player2AttackDamage = player2.getAttackDamage(randomGenerator.nextInt());

            if ((round & 1) != 0)
            {
                Attack(player1, player2, randomGenerator.nextInt());
                if (player2.getCurrHeatlh() > 0)
                    Attack(player2, player1, randomGenerator.nextInt());
            }
            else
            {
                Attack(player2, player1, randomGenerator.nextInt());
                if (player1.getCurrHeatlh() > 0)
                    Attack(player1, player2, randomGenerator.nextInt());
            }

            round++;
        }
    }

    static void Attack(Character attackingPlayer, Character defendingPlayer, int seed)
    {
        double attackDamage = attackingPlayer.getAttackDamage(seed);
        System.out.println(attackingPlayer.getName() + " attacking " + defendingPlayer.getName() + " for " + attackDamage + " damage");
        defendingPlayer.takeDamage(attackDamage);
        if (defendingPlayer.getCurrHeatlh() <= 0)
        {
            System.out.println(defendingPlayer.getName() + " Died! " + attackingPlayer.toString() + "\n\n");
            attackingPlayer.increaseWins();
        }
    }
}
