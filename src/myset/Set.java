package myset;

/**
 * Essential Test-Driven Development
 * Copyright (c) Robert Myers 2017.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Set {
    private final List<String> elements;

    public Set() {
        this(new ArrayList<String>());
    }

    private Set(List<String> listOfElements) {
        this.elements = listOfElements;
    }

    public Set(String[] arrayOfElements) {
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

    public Set union(Set otherSet) {
        List<String> allElements = new ArrayList<String>();
        allElements.addAll(this.elements);
        allElements.addAll(otherSet.elements);
        return new Set(allElements);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean contains(String elementToFind) {
        return elements.contains(elementToFind);
    }

    public Set intersect(Set otherSet) {
        List<String> foundInBoth = new ArrayList<String>();
        otherSet.elements.forEach(
                nextElement -> {
                    if (contains(nextElement))
                        foundInBoth.add(nextElement);
                });
        return new Set(foundInBoth);
    }

    public boolean isSupersetOf(Set otherSet) {
        for (String nextElement : otherSet.elements) {
            if (!contains(nextElement))
                return false;
        }
        return true;
    }

    public boolean isSubsetOf(Set otherSet) {
        return otherSet.isSupersetOf(this);
    }

    public boolean isEqualTo(Set otherSet) {
        return this.isSupersetOf(otherSet) && otherSet.isSupersetOf(this);
    }
}
