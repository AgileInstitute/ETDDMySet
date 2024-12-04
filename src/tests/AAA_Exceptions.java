package tests;

import crittermaps.InvalidElementException;
import crittermaps.TrackerGroup;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AAA_Exceptions {
    @Test
    @Disabled
    public void messageFormatsNullReference() {
        InvalidElementException myException =
                new InvalidElementException(null);
        assertThat(myException.getMessage()).contains("[null]");
    }
    @Test
    @Disabled
    public void messageContainsTheInvalidValue() {
        InvalidElementException myException =
                new InvalidElementException("bleep!");
        assertThat(myException.getMessage()).contains("[\"bleep!\"]");
    }

    @Test
    @Disabled
    public void throwsOnNullID() {
        assertThrows(InvalidElementException.class,
                () -> {
                    new TrackerGroup(new String[]{
                            "good ID before bad data",
                            null});
                });
    }
}
