package myset.tests;

import myset.Set;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MySetTests {
    @Test
    public void isEmptyWhenConstructed() {
        Set set = new Set();
        assertThat(set.isEmpty(), is(true));
    }

}
