package crittermaps;

/**
 * Essential Test-Driven Development
 * Copyright (c) Robert Myers 2017.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackerGroup {
    private final List<String> elements;

    public TrackerGroup() {
        this(new ArrayList<String>());
    }

    private TrackerGroup(List<String> listOfElements) {
        this.elements = listOfElements;
    }

    public TrackerGroup(String[] arrayOfElements) {
        this();
        Collections.addAll(this.elements, arrayOfElements);
        checkElements();
    }

    private void checkElements() {
        for (String candidate : elements) {
            if (candidate == null) {
                throw new InvalidElementException(candidate);
            }
        }
    }

    public TrackerGroup union(TrackerGroup otherTrackerGroup) {
        List<String> allElements = new ArrayList<String>();
        allElements.addAll(this.elements);
        allElements.addAll(otherTrackerGroup.elements);
        return new TrackerGroup(allElements);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean contains(String elementToFind) {
        return elements.contains(elementToFind);
    }

    public TrackerGroup intersect(TrackerGroup otherTrackerGroup) {
        List<String> foundInBoth = new ArrayList<String>();
        otherTrackerGroup.elements.forEach(
                nextElement -> {
                    if (contains(nextElement))
                        foundInBoth.add(nextElement);
                });
        return new TrackerGroup(foundInBoth);
    }

    public boolean isSupersetOf(TrackerGroup otherTrackerGroup) {
        for (String nextElement : otherTrackerGroup.elements) {
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
