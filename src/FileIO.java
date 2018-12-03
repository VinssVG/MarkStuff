//Mark Sollazzo
//260873844

import java.io.*;

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
    
    public static ArrayList readSpells(String filename)
    {
        ArrayList<Spell> spells;
        try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            int i = 0;
            
            while(line!= null)
            {
            spells[i] = line;
            i++;
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
        for(int i=0; i<words.length; i++) 
        {
            bw.write(words[i]);
            bw.newLine();
        }
        
        bw.close();
        fw.close();
        }
        catch (IOException e)
        {
            System.out.println("something went wrong");
        }
    }
}

    