package bioinfolib.tools;

public class WCharacter
{
    private char character;
    private IntegerWrap weight;

    public WCharacter(char ch)
    {
        character = ch;
        weight = new IntegerWrap(1);
    }

    public char getCharacter()
    {
        return character;
    }

    public int getWeight()
    {
        return weight.getValue();
    }
    
    public void setWeight(int w)
    {
        weight.setValue(w);
    }
}
