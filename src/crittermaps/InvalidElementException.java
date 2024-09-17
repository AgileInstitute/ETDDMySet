package crittermaps;

public class InvalidElementException extends RuntimeException {
    public InvalidElementException(String badElementValue)
    {
        super("Invalid set element value [" +
                (badElementValue != null ?
                        String.format("\"%s\"", badElementValue) :
                        badElementValue) +
                "]");
    }
}
