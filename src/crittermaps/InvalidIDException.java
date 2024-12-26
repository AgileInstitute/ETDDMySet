package crittermaps;
public class InvalidIDException extends RuntimeException {
    public InvalidIDException(String badID)
    {
        super(String.format("Invalid tracker ID value [%s]",
                badID != null ?
                        String.format("\"%s\"", badID)
                        : badID));
    }
}
