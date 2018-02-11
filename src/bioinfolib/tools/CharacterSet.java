package bioinfolib.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


//Implementacja zbioru znakow z krotnosciami


public class CharacterSet
{
    //Komparator do sortowania wedlug znakow
    class CharacterComparator implements Comparator<WCharacter>
    {
        public int compare(WCharacter wchar1, WCharacter wchar2)
        {
            Character character1 = new Character(wchar1.getCharacter());
            Character character2 = new Character(wchar2.getCharacter());
            return character1.compareTo(character2);
        }
    }

    //Komparator do sortowania wedlug wag
    class WeightComparator implements Comparator<WCharacter>
    {
        public int compare(WCharacter wchar1, WCharacter wchar2)
        {
            Integer weight1 = new Integer(wchar1.getWeight());
            Integer weight2 = new Integer(wchar2.getWeight());
            return -weight1.compareTo(weight2);
        }
    }

    //------------------------------------------------------

    private ArrayList<WCharacter> characterSet; //Struktura danych na znaki i wagi
    
    public CharacterSet()
    {
        characterSet = new ArrayList<WCharacter>();
    }

    public int size()
    {
        return characterSet.size();
    }

    public void add(char elem)
    {
        WCharacter wch = new WCharacter(elem);
        characterSet.add(wch);
    }

    public void addUnique(char elem)
    {
        for (int i = 0; i < characterSet.size(); i++)
        {
            WCharacter wch = characterSet.get(i);
            if (wch.getCharacter() == elem)
            {
                wch.setWeight(wch.getWeight()+1);
                return;
            }
        }

        add(elem);
    }

    public char get(int index)
    {
        WCharacter wch = characterSet.get(index);
        return wch.getCharacter();
    }

    public int getWeight(int index)
    {
        WCharacter wch = characterSet.get(index);
        return wch.getWeight();
    }

    public int getMaxChar()
    {
        if (size() == 0)
        {
            throw new IndexOutOfBoundsException("No elements!");
        }

        int maxWeight = Integer.MIN_VALUE;
        int maxElem = 0;

        for (int i = 0; i < size(); i++)
        {
            int elem = get(i);
            int weight = getWeight(i);
            if (weight > maxWeight)
            {
                maxWeight = weight;
                maxElem = elem;
            }
        }

        return maxElem;
    }

    public void sortByCharacters()
    {
        Collections.sort(characterSet, new CharacterComparator());
    }

    public void sortByWeights()
    {
        Collections.sort(characterSet, new WeightComparator());
    }
}


