//Mark Sollazzo
//260873844

import java.util.Random;

class Spell
{
    private final String name;
    private final double minDamage;
    private final double maxDamage;
    private final double accuracy;
    
    private static Random randomGenerator = new Random();
    
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
    
    public double getMagicDamage(int x)
    {
        double spellDamage = 0;
        
        Random randomGenerator = new Random(x);
        if(randomGenerator.nextDouble() > accuracy)
        {
            System.out.println(this.name + " missed.");
            return 0;
        }
        else
        {
            spellDamage = (randomGenerator.nextDouble() * minDamage) + maxDamage;
            return spellDamage;
        }
        
    }
    
    public String toString()
    {
        return this.name + "'s does " +minDamage+ "-"+maxDamage+" and has an accuracy of " +(accuracy * 100)+ "% .";
    }
}