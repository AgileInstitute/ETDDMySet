package tests;

import myset.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
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
        set = new Set();
        assertThat(set.isEmpty(), is(true));
    }
}
