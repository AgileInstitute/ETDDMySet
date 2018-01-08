package tests;

/**
 * Essential Test-Driven Development
 * Copyright (c) Robert Myers 2017.
 */

import myset.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UnionAndIntersectionTests {
    private Set emptySet;
    private Set a;
    private Set b;
    private static final String ONLY_IN_A = "only in a";
    private static final String IN_A_AND_B = "in a and b";
    private static final String ONLY_IN_B = "only in b";

    @BeforeEach
    public void createSampleSets() {
        emptySet = new Set();
        a = new Set(new String[] {ONLY_IN_A, IN_A_AND_B});
        b = new Set(new String[] {IN_A_AND_B, ONLY_IN_B});
    }

    private void assertSetContainsAll(Set result, String[] expectedElements) {
        for (String nextElement : expectedElements) {
            assertThat(result.contains(nextElement)).isTrue();
        }
    }

    @Test
    public void intersectionDoesNOTContainElementsThatAreOnlyInOneOfTheSets() {
        Set result = a.intersect(b);
        assertThat(result.contains(ONLY_IN_B)).isFalse();
        assertThat(result.contains(ONLY_IN_A)).isFalse();
    }

    @Test
    public void intersectionContainsElementsThatExistInBothSets() {
        Set result = a.intersect(b);
        assertThat(result.contains(IN_A_AND_B)).isTrue();
    }

    @Test
    public void unionOfOverlappingSetsContainsAllElements() {
        Set result = b.union(a);
        assertSetContainsAll(result, new String[] {ONLY_IN_A, IN_A_AND_B, ONLY_IN_B});
    }

    @Test
    public void unionEmptyWithNonemptyGivesSameElements() {
        Set result = emptySet.union(a);
        assertSetContainsAll(result, new String[] {ONLY_IN_A, IN_A_AND_B});
    }

    @Test
    public void unionWithEmptyGivesSameElements() {
        Set result = a.union(emptySet);
        assertSetContainsAll(result, new String[] {ONLY_IN_A, IN_A_AND_B});
    }
}
