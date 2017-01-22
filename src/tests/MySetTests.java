package tests;

import myset.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MySetTests {
    public static final String ITEM_TO_FIND = "Not the 1st item and contains a typ0";
    Set set;

    @BeforeEach
    public void initializeSet() {
        //given
        set = new Set(new String[] { "some uninteresting item" , ITEM_TO_FIND });
    }

    @Test
    public void doesNotContainAnElement() {
        // when/then
        assertThat(set.contains("item not in the set"), is(false));
    }

    @Test @DisplayName("contains an element (constant avoids test typos)")
    public void containsAnElement() {
        // when/then
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
