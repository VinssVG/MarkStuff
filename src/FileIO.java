//Mark Sollazzo
//260873844

import java.io.*;
import java.util.*;

class FileIO
{
    
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
        // parse individual fields from the line, with stuff like Integer.ParseInt, etc
        String name = "";
        double minDamage = 1;
        double maxDamage = 2;
        double accuracy = 1;
        return new Spell(name, minDamage, maxDamage, accuracy);
    }

    public static ArrayList readSpells(String filename)
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
    
    public static void writeCharacter(Character newHero, String filename)
    {
        try
        {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            // instructions to write on the file

            // todo : you need to generate the list of words dood
            //for(int i=0; i<words.length; i++)
            //{
            //    bw.write(words[i]);
            //    bw.newLine();
            //}
        
            bw.close();
            fw.close();
        }
        catch (IOException e)
        {
            System.out.println("something went wrong");
        }
    }
}

    