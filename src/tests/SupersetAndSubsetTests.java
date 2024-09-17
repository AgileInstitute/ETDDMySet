package tests;

/**
 * Essential Test-Driven Development
 * Copyright (c) Robert Myers 2017.
 */

import crittermaps.TrackerGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SupersetAndSubsetTests {

    private TrackerGroup smallTrackerGroup;
    private TrackerGroup biggerTrackerGroup;
    private TrackerGroup otherTrackerGroup;

    @BeforeEach
    public void createSets() {
        smallTrackerGroup = new TrackerGroup(new String[] { "a", "b", "c" });
        biggerTrackerGroup = new TrackerGroup(new String[] { "a", "b", "c", "d", "e"});
        otherTrackerGroup = new TrackerGroup(new String[] { "x", "y", "z" });
    }

    @Test
    public void isNotSubsetWhenNoIntersection() {
        assertThat(otherTrackerGroup.isSubsetOf(biggerTrackerGroup)).isFalse();
    }

    @Test
    public void isNotSupersetWhenNoIntersection() {
        assertThat(biggerTrackerGroup.isSupersetOf(otherTrackerGroup)).isFalse();
    }

    @Test
    public void isNonstrictSupersetOfItself() {
        assertThat(smallTrackerGroup.isSupersetOf(smallTrackerGroup)).isTrue();
    }

    @Test
    public void isNonstrictSubsetOfItself() {
        assertThat(smallTrackerGroup.isSubsetOf(smallTrackerGroup)).isTrue();
    }

    @Test
    public void whenNOTaSubset() {
        assertThat(biggerTrackerGroup.isSubsetOf(smallTrackerGroup)).isFalse();
    }

    @Test
    public void whenASetIsASubset() {
        assertThat(smallTrackerGroup.isSubsetOf(biggerTrackerGroup)).isTrue();
    }

    @Test
    public void whenNOTaSuperset() {
        assertThat(smallTrackerGroup.isSupersetOf(biggerTrackerGroup)).isFalse();
    }

    @Test
    public void whenASetIsASuperset() {
        assertThat(biggerTrackerGroup.isSupersetOf(smallTrackerGroup)).isTrue();
    }
}
