package tests;

import crittermaps.TrackerGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.assertj.core.api.Assertions.*;

public class BasicTrackerGroupTests {
    private static final String ITEM_TO_FIND =
            "Not the 1st item and contains a typ0";
    private TrackerGroup trackerGroup;

    @BeforeEach
    public void initializeGroup() {
        trackerGroup = new TrackerGroup(new String[] {
                "some uninteresting item",
                ITEM_TO_FIND });
    }

    @Test
    public void canCountNumberOfIDs() {
        TrackerGroup group = new TrackerGroup(new String[] {"one", "two", "three"});
        assertThat(group.idCount()).isEqualTo(3);
    }

    @Test
    public void doesNotContainAnID() {
        assertThat(trackerGroup.contains("ID not included")).isFalse();
    }

    @Test
    public void containsAnID() {
        assertThat(trackerGroup.contains(ITEM_TO_FIND)).isTrue();
    }

    @Test
    public void isNotEmpty() {
        assertThat(trackerGroup.isEmpty()).isFalse();
    }

    @Test
    public void isEmptyWhenArrayIsEmpty() {
        TrackerGroup emptyTrackerGroup = new TrackerGroup(new String[]{});
        assertThat(emptyTrackerGroup.isEmpty()).isTrue();
    }
}
