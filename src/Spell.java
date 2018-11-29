//Mark Sollazzo
//260873844

class Spell
{
    private final String name;
    private final double minDamage;
    private final double maxDamage;
    private final double accuracy;
    
    public static Spell(String name, double minDamage, double maxDamage, double accuracy)
    {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.accuracy = accuracy;
    }
        
    public static String getName()
    {
        return name;
    }
    
    public static getMagicDamage()
    {
        
    }
    
    public static toString()
    {
        return this.name + "'s does " +minDamage+ "-"+maxDamage+" and has an accuracy of " +accuracy+ ".";
       
    }
}