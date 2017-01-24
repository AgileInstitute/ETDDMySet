package myset;

public class InvalidElementException extends RuntimeException {
    public InvalidElementException(String badElementValue)
    {
        super("Invalid set element value [" +
                badElementValue + "]");
    }
}
