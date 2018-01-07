package tests;

/**
 * Essential Test-Driven Development
 * Copyright (c) Robert Myers 2017.
 */

import myset.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SupersetAndSubsetTests {

    private Set smallSet;
    private Set biggerSet;
    private Set otherSet;

    @BeforeEach
    public void createSets() {
        smallSet = new Set(new String[] { "a", "b", "c" });
        biggerSet = new Set(new String[] { "a", "b", "c", "d", "e"});
        otherSet = new Set(new String[] { "x", "y", "z" });
    }

    @Test
    public void isNotSubsetWhenNoIntersection() {
        assertThat(otherSet.isSubsetOf(biggerSet), is(false));
    }

    @Test
    public void isNotSupersetWhenNoIntersection() {
        assertThat(biggerSet.isSupersetOf(otherSet), is(false));
    }

    @Test
    public void isNonstrictSupersetOfItself() {
        assertThat(smallSet.isSupersetOf(smallSet), is(true));
    }

    @Test
    public void isNonstrictSubsetOfItself() {
        assertThat(smallSet.isSubsetOf(smallSet), is(true));
    }

    @Test
    public void whenNOTaSubset() {
        assertThat(biggerSet.isSubsetOf(smallSet), is(false));
    }

    @Test
    public void whenASetIsASubset() {
        assertThat(smallSet.isSubsetOf(biggerSet), is(true));
    }

    @Test
    public void whenNOTaSuperset() {
        assertThat(smallSet.isSupersetOf(biggerSet), is(false));
    }

    @Test
    public void whenASetIsASuperset() {
        assertThat(biggerSet.isSupersetOf(smallSet), is(true));
    }
}
