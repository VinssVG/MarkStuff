//Mark Sollazzo
//260873844

import java.util.Random;

class Spell
{
    // attributes
    private final String name;
    private final double minDamage;
    private final double maxDamage;
    private final double accuracy;
    
    private static Random randomGenerator = new Random();
    
    //constructors
    public Spell(String name, double minDamage, double maxDamage, double accuracy)
    {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.accuracy = accuracy;

        if(minDamage > maxDamage)
        {
            throw new IllegalArgumentException ("Minimum Damage cannot be greater than the maximum Damage");
        }

        if(minDamage < 0)
        {
            throw new IllegalArgumentException("Minimum Damage cannot be less than 0");
        }
    }
        
    public String getName()
    {
        return this.name;
    }

    public double getMinDamage()
    {
        return this.minDamage;
    }

    public double getMaxDamage()
    {
        return this.maxDamage;
    }

    public double getAccuracy()
    {
        return this.accuracy;
    }
    
    // generates the amount of damage done by a spell
    public double getMagicDamage(int x)
    {
        Random randomGenerator = new Random(x);
        if(randomGenerator.nextDouble() > accuracy)
        {
            System.out.println(this.name + " missed.");
            return 0;
        }
        else
        {
            return minDamage + randomGenerator.nextDouble() * (maxDamage - minDamage);
        }
    }
    
    public String toString()
    {
        return this.name + " does " +minDamage+ "-"+maxDamage+" and has an accuracy of " +(accuracy * 100)+ "% .";
    }
}