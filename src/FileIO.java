//Mark Sollazzo
//260873844

import java.io.*;

class FileIO
{
    
    public static Character readCharacter(String filename)
    {
        Character newChar = null;
        try
        {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        int length = Integer.parseInt(br.readLine());
        // read all the other lines and store them in the array
        String currLine = br.readLine();
        int index =0;
        while(currLine != null) 
            {
                newChar = currLine;
                currLine = br.readLine();
                index++;
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) 
        {
            System.out.println("the file was not there");
        } 
        catch (IOException e) 
        {
            System.out.println("something went wrong");
        }
        return newChar;
    }
}