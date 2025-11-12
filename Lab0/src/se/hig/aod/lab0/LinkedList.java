package se.hig.aod.lab0;

public class LinkedList<T> implements List<T> {

    Node<T> head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int numberOfElements() {
        return size;
    }

    public void insertFirst(T t) {
        Node<T> newNode = new Node<>();
        newNode.data = t;
        newNode.next = this.head;

        this.head = newNode;
        this.size++;
    }

    public void insertLast(T t) {
        Node<T> newNode = new Node<>();
        newNode.data = t;
        newNode.next = null;

        if (this.head == null) {
            this.head = newNode;
            this.size++;
            return;
        }
        Node<T> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public T removeFirst() {
        if (head == null)
            throw new ListEmptyException("Den är ju tom ");
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty())
            throw new ListEmptyException("Den är ju tom ");

        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }

        Node<T> current = head;

        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }

    public T getFirst() {
        if (isEmpty())
            throw new ListEmptyException("Den är ju tom ");
        return head.data;
    }

    public T getLast() {
        if (isEmpty())
            throw new ListEmptyException("Den är ju tom ");

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    static class Node<T> {
        T data;
        Node<T> next;
    }

}
