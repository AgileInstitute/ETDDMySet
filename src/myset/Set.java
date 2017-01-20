package myset;

public class Set {
    private final String[] elements;

    public Set(String[] elements) {
        this.elements = elements;
    }

    public Set() {
        elements = new String[] {};
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }
}
