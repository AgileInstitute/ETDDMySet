package tests;

import crittermaps.TrackerGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ContainsAll {

    private TrackerGroup smallGroup;
    private TrackerGroup biggerGroup;
    private TrackerGroup otherGroup;

    @BeforeEach
    public void createGroups() {
        smallGroup = new TrackerGroup(new String[] { "a", "b", "c" });
        biggerGroup = new TrackerGroup(new String[] { "a", "b", "c", "d", "e"});
        otherGroup = new TrackerGroup(new String[] { "x", "y", "z" });
    }

    @Test
    public void knowsWhenItDoesNOTContainAllIDs() {
        assertThat(biggerGroup.containsAll(otherGroup)).isFalse();
    }

    @Test
    public void knowsWhenItContainsAllIDs() {
        assertThat(biggerGroup.containsAll(smallGroup)).isTrue();
    }
}
