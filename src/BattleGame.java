//Mark Sollazzo
//260873844
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

// main method for playing the game
class BattleGame
{
    private static Random randomGenerator = new Random(456);
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        playGame("player.txt", "monster.txt", "spells.txt");
    }

    public static void playGame(String character, String monster, String cast)
    {
        Character hero = (FileIO.readCharacter(character));
        Character enemy = (FileIO.readCharacter(monster));

        ArrayList<Spell> spells = FileIO.readSpells(cast);
        if(spells == null)
        {
            System.out.println("This match will be played without spells.");
        }
        else
        {
            hero.setSpells(spells);
        }
        System.out.println();
        System.out.println("Name: " + hero.getName());
        System.out.println("Health: " + hero.getMaxHealth());
        System.out.println("Attack: " + hero.getAttackValue());
        System.out.println("Number of Wins: " + hero.getNumWins());
        System.out.println();
        System.out.println("Name: " + enemy.getName());
        System.out.println("Health: " + enemy.getMaxHealth());
        System.out.println("Attack: " + enemy.getAttackValue());
        System.out.println("Number of Wins: " + enemy.getNumWins());
        System.out.println();
        System.out.println("Here are the available spells:");
        hero.displaySpells();

        boolean exit = false;
        String command;
        while(!exit)
        {
            System.out.println();
            System.out.println("Enter a command:");
            printCommands();
            command = scan.nextLine();
            
            switch(command.toLowerCase())
            {
                case "quit":
                    System.out.println("Until next time...");
                    exit = true;
                    break;
                case "attack":
                    attack(hero, enemy);
                    break;
                default:
                    cast(hero, enemy, command.toLowerCase());
                    break;                  
            }

            if (enemy.getCurrHealth() <= 0)
            {
                hero.increaseWins();
                System.out.println();
                System.out.println("Yay! " + enemy.getName() + " has vanquished!");
                System.out.println(hero.getName() + " has won " + hero.getNumWins() + " times.");
                FileIO.writeCharacter(hero, "player.txt");
                exit = true;
            }
            else
            {
                attack(enemy, hero);
                if (hero.getCurrHealth() <= 0)
                {
                    enemy.increaseWins();
                    System.out.println();
                    System.out.println("Oh no, " + enemy.getName() + " won! You'll get em next time.");
                    System.out.println(enemy.getName() + " has won " + enemy.getNumWins() + " times.");
                    FileIO.writeCharacter(enemy, "monster.txt");
                    exit = true;
                }
            }
        }
    }
    
    public static void printCommands() 
    {
        System.out.println("\nType: ");
        System.out.println("\t Attack - To Attack");
        System.out.println("\t quit - To quit.");
        System.out.println("\t spells - To cast a spell.");
    } 
    
    static void attack(Character attcker, Character defender)
    {
        double attackDamage = attcker.getAttackDamage(randomGenerator.nextInt());

        System.out.println();
        System.out.println(attcker.getName()+ " attacks " + defender.getName()+ " for " +String.format("%1$.2f", attackDamage)+ " damage.");
        defender.takeDamage(attackDamage);
        if (defender.getCurrHealth() <= 0)
        {
            System.out.println(defender.getName() + " was knocked out!");
        }
        else
        {
            System.out.println(defender.toString());
        }
    }
    
    static void cast(Character attackingCharacter, Character defendingCharacter, String spellName)
    {
        double damage = attackingCharacter.castSpell(spellName, randomGenerator.nextInt());
        if (damage > 0)
        {
            System.out.println();
            System.out.println(attackingCharacter.getName() + " casts " + spellName + ", dealing " + String.format("%.2f", damage)+ " damage!");
            defendingCharacter.takeDamage(damage);
            System.out.println(defendingCharacter.toString());
        }
        else
        {
            System.out.println();
            System.out.println(attackingCharacter.getName() + " tried to cast " + spellName + " but failed!");
        }
    }
}
