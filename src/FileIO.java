//Mark Sollazzo
//260873844

import java.io.*;
import java.util.*;

class FileIO
{
    // reads characters from textfile
    public static Character readCharacter(String filename)
    {
        try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String name = br.readLine();
            double attackValue = Double.parseDouble(br.readLine());
            double maxHealth = Double.parseDouble(br.readLine());
            int numWins = Integer.parseInt(br.readLine());

            br.close();
            fr.close();
            return new Character(name, attackValue, maxHealth, numWins);
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("the file was not there");
        } 
        catch (IOException e) 
        {
            System.out.println("something went wrong");
        }
        return null;
    }

    public static Spell parseSpell(String line)
    {
        String name = "dummy";
        double minDamage = 1;
        double maxDamage = 2;
        double accuracy = 1;
        return new Spell(name, minDamage, maxDamage, accuracy);
    }
    
    // reads spellsfrom textfile
    public static ArrayList<Spell> readSpells(String filename)
    {
        ArrayList<Spell> spells = new ArrayList<Spell>();
        try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            while(line!= null)
            {
                spells.add(parseSpell(line));
                line = br.readLine();
            }

            br.close();
            fr.close();
            return spells;
        } 
        
        catch (FileNotFoundException e)
        {
            System.out.println("the file was not there");
        } 
        catch (IOException e) 
        {
            System.out.println("something went wrong");
        }
        return null;
    }
    
    
    //method allowing you to write on the file
    public static void writeCharacter(Character newHero, String filename)
    {
        try
        {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(newHero.getName());
            bw.newLine();
            bw.write(String.format("%f", newHero.getAttackValue()));
            bw.newLine();
            bw.write(String.format("%f", newHero.getMaxHealth()));
            bw.newLine();
            bw.write(String.format("%d", newHero.getNumWins()));

            bw.close();
            fw.close();
        }
        catch (IOException e)
        {
            System.out.println("something went wrong");
        }
    }
}

    