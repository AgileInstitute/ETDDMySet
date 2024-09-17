package tests;

/**
 * Essential Test-Driven Development
 * Copyright (c) Robert Myers 2017.
 */

import crittermaps.TrackerGroup;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class EqualityTests {
    private final TrackerGroup aTrackerGroup = new TrackerGroup(new String[] { "this", "is", "interesting!" });
    private final TrackerGroup anEqualTrackerGroup = new TrackerGroup(new String[] { "this", "is", "interesting!" });

    @Test
    public void operationIsCommutative() {
        assertThat(anEqualTrackerGroup.isEqualTo(aTrackerGroup)).isTrue();
    }

    @Test
    public void twoSetsAreEqualWhenTheyHaveTheExactSameElements() {
        assertThat(aTrackerGroup.isEqualTo(anEqualTrackerGroup)).isTrue();
    }

    @Test
    public void whenSetsAreTheSameObject() {
        assertThat(aTrackerGroup.isEqualTo(aTrackerGroup)).isTrue();
    }

    @Test
    public void whenSetsAreNotEqual() {
        TrackerGroup aDifferentTrackerGroup = new TrackerGroup(new String[] {"also", "interesting!" });
        assertThat(aTrackerGroup.isEqualTo(aDifferentTrackerGroup)).isFalse();
    }

    @Test
    public void integerHashcodeIsObviousForSmallIntegers() {
        int reliantPrefixCode = 16309;
        assertThat(new Integer(reliantPrefixCode).hashCode()).isEqualTo(reliantPrefixCode);
    }
}
