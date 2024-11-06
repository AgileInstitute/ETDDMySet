package tests;

import crittermaps.TrackerGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CombiningTrackerGroupsTests {
    private TrackerGroup emptyGroup;
    private TrackerGroup groupA;
    private TrackerGroup groupB;
    private static final String IN_GROUP_A = "one";
    private static final String IN_A_AND_B = "duplicate";
    private static final String IN_GROUP_B = "three";

    @BeforeEach
    public void createSampleGroups() {
        emptyGroup = new TrackerGroup(new String[]{});
        groupA = new TrackerGroup(
                    new String[] {IN_GROUP_A, IN_A_AND_B});
        groupB = new TrackerGroup(
                    new String[] {IN_A_AND_B, IN_GROUP_B});
    }

    private void assertGroupContainsAll(TrackerGroup result,
                                        String[] expectedElements) {
        for (String nextElement : expectedElements) {
            assertThat(result.contains(nextElement)).isTrue();
        }
    }

    @Test
    public void combiningTwoGroups_GivesNewGroupContainingAllIDs() {
        TrackerGroup result = groupB.combinedWith(groupA);
        assertGroupContainsAll(result,
                new String[] {IN_GROUP_A, IN_A_AND_B, IN_GROUP_B});
    }

    @Test
    public void emptyCombinedWithNonempty_HasAllFromNonempty() {
        TrackerGroup result = emptyGroup.combinedWith(groupA);
        assertGroupContainsAll(result,
                new String[] {IN_GROUP_A, IN_A_AND_B});
    }
    @Test
    public void intersectionDoesNOTContainElementsThatAreOnlyInOneOfTheSets() {
        TrackerGroup result = groupA.intersect(groupB);
        assertThat(result.contains(IN_GROUP_B)).isFalse();
        assertThat(result.contains(IN_GROUP_A)).isFalse();
    }

    @Test
    public void intersectionContainsElementsThatExistInBothSets() {
        TrackerGroup result = groupA.intersect(groupB);
        assertThat(result.contains(IN_A_AND_B)).isTrue();
    }
}
