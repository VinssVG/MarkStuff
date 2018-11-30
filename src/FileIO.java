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

            String name = "";
            double attackValue = 0;
            double maxHealth = 0;
            int numWins = 0;

            int length = Integer.parseInt(br.readLine());
            // read all the other lines and store them in the array
            String currLine = br.readLine();
            int index =0;
            while(currLine != null)
            {
                currLine = br.readLine();
                index++;
            }
            br.close();
            fr.close();
            return new Character(name, attackValue, maxHealth, numWins);
        } catch (FileNotFoundException e)
        {
            System.out.println("the file was not there");
        } 
        catch (IOException e) 
        {
            System.out.println("something went wrong");
        }

        return null;
    }
}