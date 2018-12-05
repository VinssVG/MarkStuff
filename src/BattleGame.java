//Mark Sollazzo
//260873844
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

// main method for playing the game
class BattleGame
{
    private static Random randomGenerator = new Random();
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
        System.out.println("Here are the available spells:");
        hero.displaySpells();
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
        //print info();
        while(!exit)
        {
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
        }       
    }
    
    public static void printCommands() 
    {
        System.out.println("\nType: ");
        System.out.println("\t Attack - To Attack");
        System.out.println("\t quit - To quit.");
        System.out.println("\t spells - To cast a spell.");
    } 
    
    static void attack(Character player, Character monster)
    {
        double attack = player.getAttackDamage(randomGenerator.nextInt());
        String attackDamage = String.format("%1$.2f", attack);
        System.out.println(player.getName()+ " attacks " +monster.getName()+ " for " +attackDamage+ " damage.");
        monster.takeDamage(Double.parseDouble(attackDamage));
        if (monster.getCurrHealth() <= 0)
        {
            System.out.print(" Congratulations, " + monster.getName() + " has been vanquished! "); 
            System.out.println(player.toString() + "\n\n");
            player.increaseWins();
            return;
        }
        System.out.println(monster.getName() + "'s current health is: " + monster.getCurrHealth()+"\n");
        
        attack = monster.getAttackDamage(randomGenerator.nextInt());
        attackDamage = String.format("%1$.2f", attack);
        System.out.println(monster.getName()+ " attacks " +player.getName()+ " for " +attackDamage+ " damage.");
        player.takeDamage(Double.parseDouble(attackDamage));
        if (player.getCurrHealth() <= 0)
        {
            System.out.print("Oh no, " + monster.getName() + " won! You'll get em next time.\n\n"); 
            monster.increaseWins();
            return;
        }
        System.out.println(player.getName() + "'s current health is: " + player.getCurrHealth()+"\n");
    }
    
    static void cast(Character player, Character monster, String spellName)
    {
        System.out.println("cast " + spellName);
        monster.takeDamage(player.castSpell(spellName, randomGenerator.nextInt()));
    }
}
