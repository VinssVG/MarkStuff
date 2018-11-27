//Mark Sollazzo
//260873844

import java.util.Random;

class Character
{
    // Attributes
    private final String name;
    private final double attackValue;
    private final double maxHealth;
    private double currHealth;
    private int numWins;

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

    public double getCurrHeatlh() { return currHealth; }
    
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
    
                            
}