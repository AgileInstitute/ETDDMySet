package tests;

import myset.InvalidElementException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class MySetExceptionTests {
    @Test
    public void messageContainsInvalidValue() {
        String badValue = "[bleep!]";
        InvalidElementException myException =
                new InvalidElementException(badValue);
        assertThat(myException.getMessage(),
                containsString(badValue));
    }
}
