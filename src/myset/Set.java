package myset;

import java.security.InvalidParameterException;

public class Set {
    private final String[] elements;

    public Set(String[] elements) {
        for (String candidate : elements) {
            if (candidate == null) {
                throw new InvalidElementException(candidate);
            }
        }
        this.elements = elements;
    }

    public Set() {
        elements = new String[] {};
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

    public boolean contains(String elementToFind) {
        for (String element : elements) {
            if (element.equals(elementToFind))
                return true;
        }
        return false;
    }
}
