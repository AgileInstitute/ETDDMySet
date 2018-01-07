package tests;

/**
 * Essential Test-Driven Development
 * Copyright (c) Robert Myers 2017.
 */

import myset.Set;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EqualityTests {
    private final Set aSet = new Set(new String[] { "this", "is", "interesting!" });
    private final Set anEqualSet = new Set(new String[] { "this", "is", "interesting!" });

    @Test
    public void operationIsCommutative() {
        assertThat(anEqualSet.isEqualTo(aSet), is(true));
    }

    @Test
    public void twoSetsAreEqualWhenTheyHaveTheExactSameElements() {
        assertThat(aSet.isEqualTo(anEqualSet), is(true));
    }

    @Test
    public void whenSetsAreTheSameObject() {
        assertThat(aSet.isEqualTo(aSet), is(true));
    }

    @Test
    public void whenSetsAreNotEqual() {
        Set aDifferentSet = new Set(new String[] {"also", "interesting!" });
        assertThat(aSet.isEqualTo(aDifferentSet), is(false));
    }

    @Test
    public void integerHashcodeIsObvious() {
        int reliantPrefixCode = 16309;
        assertThat(new Integer(reliantPrefixCode).hashCode(),
                is(reliantPrefixCode));
    }
}
