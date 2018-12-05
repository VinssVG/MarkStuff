//Mark Sollazzo
//260873844

import java.util.Random;
import java.util.ArrayList;

class Character
{
    // Attributes
    private final String name;
    private final double attackValue;
    private final double maxHealth;
    private double currHealth;
    private int numWins;
    private static ArrayList<Spell> spells = new ArrayList<Spell>();
    
    // Constructors
    public Character(String name, double attackValue, double maxHealth, int numWins)
    {
        this.name = name;
        this.attackValue = attackValue;
        this.maxHealth = maxHealth;
        this.numWins = numWins;
        this.currHealth = this.maxHealth;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getAttackValue()
    {
        return attackValue;
    }
    
    public double getMaxHealth()
    {
        return maxHealth;
    }

    public double getCurrHealth() 
    { 
        return currHealth; 
    }
    
    public int getNumWins()
    {
        return numWins;
    }
    
    // Other Methods
    public String toString()
    {
        return this.name + " current health is " + String.format("%.2f", this.currHealth) + ".";
    }
    // generates the damage done by the attack command
    public double getAttackDamage(int seed)
    {
        Random randomGenerator = new Random(seed);
        return this.attackValue * ((randomGenerator.nextDouble() * 0.3) + 0.7);
    }
    // generates the damage taken by the attack command to an opposing player
    public double takeDamage(double damage)
    {
        currHealth = currHealth - damage;
        return currHealth;
    }
    // increases the # of wins after a battle is over
    public void increaseWins()
    {
        numWins++;
    }
    // adds spells
    public static void setSpells(ArrayList<Spell> newSpells)
    {
        spells = newSpells;
    }
    
    public static void displaySpells()
    {
        for(int i = 0; i < spells.size(); i++)
        {
            System.out.println(spells.get(i).toString());
        }
    }
    
    public double castSpell(String spell, int x)
    {
        for(int i=0; i<spells.size();i++)
        {
            if(spells.get(i).getName().equalsIgnoreCase(spell))
            {
                return spells.get(i).getMagicDamage(x);
            }
        }
        return -1;
    }
    
    
    
                            
}