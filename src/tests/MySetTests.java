package tests;

import myset.InvalidElementException;
import myset.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MySetTests {
    private static final String ITEM_TO_FIND =
            "Not the 1st item and contains a typ0";
    private Set set;

    @BeforeEach
    public void initializeSet() {
        set = new Set(new String[] {
                "some uninteresting item",
                ITEM_TO_FIND });
    }

    @Test
    public void throwsOnNullElement() {
        assertThrows(InvalidElementException.class,
                () -> {
                    new Set(new String[]{
                            "good element before bad data",
                            null});
                });
    }


    @Test
    public void doesNotContainAnElement() {
        assertThat(set.contains("not an element"), is(false));
    }

    @Test
    public void containsAnElement() {
        assertThat(set.contains(ITEM_TO_FIND), is(true));
    }

    @Test
    public void isNotEmpty() {
        assertThat(set.isEmpty(), is(false));
    }

    @Test
    public void isEmptyWhenConstructed() {
        Set emptySet = new Set();
        assertThat(emptySet.isEmpty(), is(true));
    }
}
