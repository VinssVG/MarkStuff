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
    private static ArrayList<Spell> spells;
    
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
        return this.name + " current health is " + this.currHealth + ".";
    }
    
    public double getAttackDamage(int seed)
    {
        Random randomGenerator = new Random(seed);
        return this.attackValue * ((randomGenerator.nextDouble() * 0.3) + 0.7);
    }
    
    public double takeDamage(double damage)
    {
        currHealth = currHealth - damage;
        return currHealth;
    }
    
    public void increaseWins()
    {
        numWins++;
    }
    
    public void setSpells(ArrayList spells)
    {
        this.spells = spells;
    }
    
    public void displaySpells()
    {
        for(int i = 0; i < spells.size(); i++)
        {
            System.out.println("Name: " + spells.get(i).getName() + "Damage: " + spells.get(i).getMinDamage() + "-" + spells.get(i).getMaxDamage ()+ "Chance: " + spells.get(i).getAccuracy());
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