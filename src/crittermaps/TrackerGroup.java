package crittermaps;

import java.util.*;

public class TrackerGroup {
    private static Collection<String> freshStoreForIDs() {
        return new HashSet<String>();
    }

    private final Collection<String> trackerIDs;

    private TrackerGroup(Collection<String> listOfIDs) {
        this.trackerIDs = listOfIDs;
    }

    public TrackerGroup(String[] trackerIDs) {
        this(freshStoreForIDs());
        checkElements(trackerIDs);
        Collections.addAll(this.trackerIDs, trackerIDs);
    }

    public TrackerGroup combinedWith(TrackerGroup otherTrackerGroup) {
        Collection<String> allIDs = freshStoreForIDs();
        allIDs.addAll(this.trackerIDs);
        allIDs.addAll(otherTrackerGroup.trackerIDs);
        return new TrackerGroup(allIDs);
    }

    public boolean isEmpty() {
        return trackerIDs.isEmpty();
    }

    public boolean contains(String trackerToFind) {
        return trackerIDs.contains(trackerToFind);
    }

    public int idCount() {
        return trackerIDs.size();
    }

    public TrackerGroup overlap(TrackerGroup otherTrackerGroup) {
        Collection<String> foundInBoth = freshStoreForIDs();
        otherTrackerGroup.trackerIDs.forEach(
                nextID -> {
                    if (contains(nextID))
                        foundInBoth.add(nextID);
                });
        return new TrackerGroup(foundInBoth);
    }

    public boolean containsAll(TrackerGroup otherTrackerGroup) {
        for (String nextElement : otherTrackerGroup.trackerIDs) {
            if (!contains(nextElement))
                return false;
        }
        return true;
    }

    public boolean isEqualTo(TrackerGroup other) {
        return this.containsAll(other) && other.containsAll(this);
    }

    private void checkElements(String[] trackerIDs) {
        for (String candidate : trackerIDs) {
            if (candidate == null) {
                throw new InvalidElementException(candidate);
            }
        }
    }

}
