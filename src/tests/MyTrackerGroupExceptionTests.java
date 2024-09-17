package tests;

import crittermaps.InvalidElementException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.*;

public class MyTrackerGroupExceptionTests {
    @Test
    public void messageFormatsNullReference() {
        InvalidElementException myException =
                new InvalidElementException(null);
        assertThat(myException.getMessage()).contains("[null]");
    }
    @Test
    public void messageContainsTheInvalidValue() {
        InvalidElementException myException =
                new InvalidElementException("bleep!");
        assertThat(myException.getMessage()).contains("[\"bleep!\"]");
    }
}
