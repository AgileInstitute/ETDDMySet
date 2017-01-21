package tests;

import myset.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MySetTests {
    @Test
    public void doesNotContainAnElement() {
        // given
        Set set = new Set(new String[]{ "foo" });
        // when/then
        assertThat(set.contains("bar"), is(false));
    }
    @Test @DisplayName("contains an element (spec style avoids typos)")
    public void containsAnElement() {
        // given
        String itemToFind = "FO0";
        String[] elements = { itemToFind };
        Set set = new Set(elements);
        // when/then
        assertThat(set.contains(itemToFind), is(true));
    }
    @Test
    public void isNotEmptyWhenOneItemIncludedInConstructor() {
        String[] elements = { "foo" };
        Set set = new Set(elements);
        assertThat(set.isEmpty(), is(false));
    }
    @Test
    public void isEmptyWhenConstructed() {
        Set set = new Set();
        assertThat(set.isEmpty(), is(true));
    }

}
