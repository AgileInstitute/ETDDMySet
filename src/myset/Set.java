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

    public boolean contains(String itemToFind) {
        for (String element : elements) {
            if (element.equals(itemToFind))
                return true;
        }
        return false;
    }
}
