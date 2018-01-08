package tests;

import myset.InvalidElementException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.*;

public class MySetExceptionTests {
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
