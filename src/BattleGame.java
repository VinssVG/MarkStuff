//Mark Sollazzo
//260873844

import java.util.Random;

class BattleGame
{
    public static void main(String[] args)
    {
        Character mark = new Character("Mark", 10, 60, 0);
        Character vincent = new Character("Vincent", 8, 75, 0);

        System.out.println("Name      : " + mark.getName());
        System.out.println("MaxHealth : " + mark.getMaxHealth());
        System.out.println("Wins      : " + mark.getNumWins());
        System.out.println("TooString : " + mark.toString());
        System.out.println("Damage    : " + mark.getAttackDamage(123));
        System.out.println("Damage    : " + mark.getAttackDamage(456));
        System.out.println("Damage    : " + mark.getAttackDamage(789));
    }
}