package tests;

/**
 * Essential Test-Driven Development
 * Copyright (c) Robert Myers 2017.
 */

import myset.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(otherSet.isSubsetOf(biggerSet)).isFalse();
    }

    @Test
    public void isNotSupersetWhenNoIntersection() {
        assertThat(biggerSet.isSupersetOf(otherSet)).isFalse();
    }

    @Test
    public void isNonstrictSupersetOfItself() {
        assertThat(smallSet.isSupersetOf(smallSet)).isTrue();
    }

    @Test
    public void isNonstrictSubsetOfItself() {
        assertThat(smallSet.isSubsetOf(smallSet)).isTrue();
    }

    @Test
    public void whenNOTaSubset() {
        assertThat(biggerSet.isSubsetOf(smallSet)).isFalse();
    }

    @Test
    public void whenASetIsASubset() {
        assertThat(smallSet.isSubsetOf(biggerSet)).isTrue();
    }

    @Test
    public void whenNOTaSuperset() {
        assertThat(smallSet.isSupersetOf(biggerSet)).isFalse();
    }

    @Test
    public void whenASetIsASuperset() {
        assertThat(biggerSet.isSupersetOf(smallSet)).isTrue();
    }
}
