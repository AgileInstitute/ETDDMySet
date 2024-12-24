package tests;

import crittermaps.InvalidIDException;
import crittermaps.TrackerGroup;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exceptions {
    @Test
    public void messageFormatsNullReference() {
        InvalidIDException myException =
                new InvalidIDException(null);
        assertThat(myException.getMessage()).contains("[null]");
    }
    @Test
    public void messageContainsTheInvalidValue() {
        InvalidIDException myException =
                new InvalidIDException("bleep!");
        assertThat(myException.getMessage()).contains("[\"bleep!\"]");
    }

    @Test
    public void throwsOnNullID() {
        assertThrows(InvalidIDException.class,
                () -> new TrackerGroup(new String[]{
                        "good ID before bad data",
                        null}));
    }
}
