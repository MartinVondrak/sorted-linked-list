package cz.martinvondrak.sortedlinkedlist;

public class SortedLinkedList<T extends Comparable<T>> {
    private Item<T> head;

    public void add(T value) {
        Item<T> item = new Item<>(value);

        if (head == null) {
            head = item;
            return;
        }

        Item<T> current = head;
        Item<T> previous = null;

        while (current != null && current.getValue().compareTo(value) < 0) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            item.setNext(head);
            head = item;
        } else {
            previous.setNext(item);
            item.setNext(current);
        }
    }

    public T get(int index) {
        Item<T> current = head;
        int i = 0;

        while (current != null && i < index) {
            current = current.getNext();
            i++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException();
        }

        return current.getValue();
    }

    public T remove(int index) {
        Item<T> current = head;
        Item<T> previous = null;
        int i = 0;

        while (current != null && i < index) {
            previous = current;
            current = current.getNext();
            i++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException();
        }

        if (previous == null) {
            head = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }

        return current.getValue();
    }

    public boolean remove(T value) {
        Item<T> current = head;
        Item<T> previous = null;

        while (current != null && !current.getValue().equals(value)) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            return false;
        }

        if (previous == null) {
            head = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }

        return true;
    }
}
