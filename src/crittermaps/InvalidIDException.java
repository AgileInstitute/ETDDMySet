package crittermaps;

public class InvalidIDException extends RuntimeException {
    public InvalidIDException(String badID)
    {
        super("Invalid set element value [" +
                (badID != null ?
                        String.format("\"%s\"", badID) :
                        badID) +
                "]");
    }
}
