package tests;

/**
 * Essential Test-Driven Development
 * Copyright (c) Robert Myers 2017.
 */

import crittermaps.TrackerGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UnionAndIntersectionTests {
    private TrackerGroup emptyTrackerGroup;
    private TrackerGroup a;
    private TrackerGroup b;
    private static final String ONLY_IN_A = "only in a";
    private static final String IN_A_AND_B = "in a and b";
    private static final String ONLY_IN_B = "only in b";

    @BeforeEach
    public void createSampleSets() {
        emptyTrackerGroup = new TrackerGroup();
        a = new TrackerGroup(new String[] {ONLY_IN_A, IN_A_AND_B});
        b = new TrackerGroup(new String[] {IN_A_AND_B, ONLY_IN_B});
    }

    private void assertSetContainsAll(TrackerGroup result, String[] expectedElements) {
        for (String nextElement : expectedElements) {
            assertThat(result.contains(nextElement)).isTrue();
        }
    }

    @Test
    public void intersectionDoesNOTContainElementsThatAreOnlyInOneOfTheSets() {
        TrackerGroup result = a.intersect(b);
        assertThat(result.contains(ONLY_IN_B)).isFalse();
        assertThat(result.contains(ONLY_IN_A)).isFalse();
    }

    @Test
    public void intersectionContainsElementsThatExistInBothSets() {
        TrackerGroup result = a.intersect(b);
        assertThat(result.contains(IN_A_AND_B)).isTrue();
    }

    @Test
    public void unionOfOverlappingSetsContainsAllElements() {
        TrackerGroup result = b.union(a);
        assertSetContainsAll(result, new String[] {ONLY_IN_A, IN_A_AND_B, ONLY_IN_B});
    }

    @Test
    public void unionEmptyWithNonemptyGivesSameElements() {
        TrackerGroup result = emptyTrackerGroup.union(a);
        assertSetContainsAll(result, new String[] {ONLY_IN_A, IN_A_AND_B});
    }

    @Test
    public void unionWithEmptyGivesSameElements() {
        TrackerGroup result = a.union(emptyTrackerGroup);
        assertSetContainsAll(result, new String[] {ONLY_IN_A, IN_A_AND_B});
    }
}
