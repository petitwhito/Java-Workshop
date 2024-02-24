package fr.epita.assistants.linkedlist;

public class LinkedList<T extends Comparable<T>> {

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    /**
     * Initializes the list
     **/
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T e) {
        Node<T> newNode = new Node<>(e);
        size++;
        if (head == null || e.compareTo(head.data) <= 0)
        {
            newNode.next = head;
            head = newNode;
        }
        else
        {
            Node<T> current = head;
            while (current.next != null && e.compareTo(current.next.data) > 0)
                current = current.next;
            newNode.next = current.next;
            current.next = newNode;
        }

    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if there is no element at this
     *                                   index.
     **/
    public T get(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException();

        Node<T> current = head;
        for (int j = 0; j < i && current != null; j++)
            current = current.next;

        return current.data;
    }

    /**
     * Removes the first occurrence of the specified element in the list.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove(T e) {
        if (head == null)
            return null;

        if (e.equals(head.data))
        {
            T r = head.data;
            head = head.next;
            size--;
            return r;
        }

        Node<T> current = head;
        while (current.next != null && !e.equals(current.next.data))
            current = current.next;

        if (current.next != null)
        {
            T r = current.next.data;
            current.next = current.next.next;
            size--;
            return r;
        }
        return null;
    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        head = null;
        size = 0;
    }
}