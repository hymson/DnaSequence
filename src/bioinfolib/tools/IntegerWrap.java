package bioinfolib.tools;


//Opakowanie dla wartosci typu int

public class IntegerWrap
{
    private int intValue;

    public IntegerWrap(int val)
    {
        intValue = val;
    }

    public int getValue()
    {
        return intValue;
    }

    public void setValue(int val)
    {
        intValue = val;
    }
}

