package crittermaps;

/**
 * Essential Test-Driven Development
 * Copyright (c) Robert Myers 2017.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackerGroup {
    private final List<String> trackerIDs;

    private TrackerGroup(List<String> listOfIDs) {
        this.trackerIDs = listOfIDs;
    }

    public TrackerGroup(String[] trackerIDs) {
        this(new ArrayList<String>());
        Collections.addAll(this.trackerIDs, trackerIDs);
        checkElements();
    }

    private void checkElements() {
        for (String candidate : trackerIDs) {
            if (candidate == null) {
                throw new InvalidElementException(candidate);
            }
        }
    }

    public TrackerGroup union(TrackerGroup otherTrackerGroup) {
        List<String> allElements = new ArrayList<String>();
        allElements.addAll(this.trackerIDs);
        allElements.addAll(otherTrackerGroup.trackerIDs);
        return new TrackerGroup(allElements);
    }

    public boolean isEmpty() {
        return trackerIDs.isEmpty();
    }

    public boolean contains(String elementToFind) {
        return trackerIDs.contains(elementToFind);
    }

    public TrackerGroup intersect(TrackerGroup otherTrackerGroup) {
        List<String> foundInBoth = new ArrayList<String>();
        otherTrackerGroup.trackerIDs.forEach(
                nextElement -> {
                    if (contains(nextElement))
                        foundInBoth.add(nextElement);
                });
        return new TrackerGroup(foundInBoth);
    }

    public boolean isSupersetOf(TrackerGroup otherTrackerGroup) {
        for (String nextElement : otherTrackerGroup.trackerIDs) {
            if (!contains(nextElement))
                return false;
        }
        return true;
    }

    public boolean isSubsetOf(TrackerGroup otherTrackerGroup) {
        return otherTrackerGroup.isSupersetOf(this);
    }

    public boolean isEqualTo(TrackerGroup otherTrackerGroup) {
        return this.isSupersetOf(otherTrackerGroup) && otherTrackerGroup.isSupersetOf(this);
    }
}
