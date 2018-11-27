//Mark Sollazzo
//260873844

import java.io.*;

class FileIO
{
    
    public static Character readCharacter(String filename)
    {
        
        
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String currentLine = br.readLine();
        while(currentLine != null)
        {
            System.out.println(currentLine);
            currentLine = br.readLine();
        }
        try
        {
            System.out.println(currentLine);
        }
        catch (IOException e)
        {
            System.out.println("Invalid name, please try again.");
        }
        catch (java.io.FileNotFoundException f)
        {
            System.out.println("File nout found.");
        }
        br.close();
        fr.close();
    }
}



    
    
   /*try {
            writeToFile(w, "fruits.txt");
            writeToFile(f, "fruits.txt");
        } catch (IOException e) {
            System.out.println("something went wrong");
    */
    
    

