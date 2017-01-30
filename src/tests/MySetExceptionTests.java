package tests;

import myset.InvalidElementException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class MySetExceptionTests {
    @Test
    public void messageFormatsNullReference() {
        InvalidElementException myException =
                new InvalidElementException(null);
        assertThat(myException.getMessage(),
                containsString("[null]"));
    }
    @Test
    public void messageContainsTheInvalidValue() {
        InvalidElementException myException =
                new InvalidElementException("bleep!");
        assertThat(myException.getMessage(),
                containsString("[\"bleep!\"]"));
    }
}
