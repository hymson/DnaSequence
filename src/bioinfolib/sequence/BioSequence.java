package bioinfolib.sequence;

import bioinfolib.tools.CharacterSet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BioSequence
{
    public static char COMMENT_CHAR = '>'; //Znak komentarza

    ArrayList<Character> sequence; //Struktura danych na sekwencje

    public BioSequence()
    {
        sequence = new ArrayList<Character>();
    }

    @SuppressWarnings("deprecation")
	public void add(char elem)
    {
        sequence.add(new Character(elem));
    }

    public char get(int index)
    {
        Character character = sequence.get(index);
        return character.charValue();
    }

    public Character getCharacter(int index)
    {
        return sequence.get(index);
    }

    public int size()
    {
        return sequence.size();
    }

    public void load(String fileName)
    throws IOException
    {
        sequence.clear();

        File inFile = new File(fileName);

        if (!inFile.exists())
        {
            throw new IOException("Cannot open file with sequence: " + fileName);
        }

        FileReader fr = new FileReader(inFile);
        BufferedReader br = new BufferedReader(fr);

        while (true)
        {
            int ci = br.read();
            if (ci==-1) break;
            char ch = (char) ci;

            if (ch == COMMENT_CHAR) //Pominiecie linijki komentarza
            {
                br.readLine();
            }
            else
            {
                if (Character.isLetter(ch)) //Sprawdzenie, czy to litera
                {
                    add(ch);
                }
            }
        }

        br.close();
    }

    public String toString()
    {
        String text = new String();

        for (int i=0; i<sequence.size(); i++)
        {
            text = text + sequence.get(i);
        }

        return text;
    }

    //=========================================================

    public static void main(String [] args)
    {
        try
        {
            String fileName = "src/data/dna.txt";
            //String fileName = "src/data/bialko.txt";
            BioSequence bioSequence = new BioSequence();
            bioSequence.load(fileName);
            String text = bioSequence.toString();
            System.out.println(text);

            //-------------------------

            CharacterSet characterSet = new CharacterSet();

            for (int i=0; i<bioSequence.size(); i++)
            {
                char ch = bioSequence.get(i);
                characterSet.addUnique(ch);
            }

            for (int i=0; i<characterSet.size(); i++)
            {
                char ch = characterSet.get(i);
                int weight = characterSet.getWeight(i);
                System.out.println(ch+" "+weight);
            }

            System.out.println("-------------------------------------------------");

            //--------------------------------------------

            characterSet.sortByCharacters();

            for (int i=0; i<characterSet.size(); i++)
            {
                char ch = characterSet.get(i);
                int weight = characterSet.getWeight(i);
                System.out.println(ch+" "+weight);
            }

            System.out.println("-------------------------------------------------");

            characterSet.sortByWeights();


            for (int i=0; i<characterSet.size(); i++)
            {
                char ch = characterSet.get(i);
                int weight = characterSet.getWeight(i);
                System.out.println(ch+" "+weight);
            }

            System.out.println("-------------------------------------------------");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }


}
