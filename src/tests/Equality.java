package tests;

import crittermaps.TrackerGroup;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class Equality {
    private TrackerGroup group;

    @BeforeEach
    public void createInterestingGroup() {
        group = new TrackerGroup(new String[] { "this", "is", "interesting" });
    }

    @Test
    public void equalWhenTheyHaveTheSameIDs() {
        TrackerGroup sameIDsDifferentOrder =
                new TrackerGroup(new String[] { "interesting", "this", "is" });
        assertThat(group.isEqualTo(sameIDsDifferentOrder)).isTrue();
    }

    @Test
    public void whenNotEqual() {
        TrackerGroup notTheSameGroup =
                new TrackerGroup(new String[] {"not", "as", "interesting" });
        assertThat(group.isEqualTo(notTheSameGroup)).isFalse();
    }

    // The following are not really part of the narrative...

    @Test
    public void whenNotEqualDespiteEqualHashcodes() {
        assertThat(group.equals(new Integer(group.hashCode()))).isFalse();
    }

    @Test
    public void integerHashcodeIsObvious() {
        int aHashCode = 16309;
        assertThat(new Integer(aHashCode).hashCode()).isEqualTo(aHashCode);
    }
}
