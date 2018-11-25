//Mark Sollazzo
//260873844

import java.util.Random;

class Character
{
    
    static double seed = 123;
    
    // Attributes
    private final String name;
    private final double attackValue;
    private final double maxHealth;
    private final double currHealth;
    private final int numWins;
    private static Random randomGenerator = new Random(123);
    
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
    
    public int getNumWins()
    {
        return numWins;
    }
    
    // Other Methods
    public String toString()
    {
        return this.name + " current health is " + this.currHealth + ".";
    }
    
    public double getAttackDamage(int attackValue)
    {
        return 0;
    }
    
    public void takeDamage()
    {
    }
    
    public void increaseWins()
    {
    }
    
                            
}