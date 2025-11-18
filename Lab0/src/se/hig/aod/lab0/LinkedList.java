package se.hig.aod.lab0;

public class LinkedList<T> implements PrintableList<T> {

	private Node head;
	private int size;

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
		Node newNode = new Node(t);
		newNode.next = head;
		head = newNode;
		size++;
	}

	public void insertLast(T t) {
		Node newNode = new Node(t);

		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}

		size++;
	}

	public T removeFirst() {
		if (isEmpty()) {
			throw new ListEmptyException("List is empty");
		}

		T data = head.data;
		head = head.next;
		size--;
		return data;
	}

	public T removeLast() {
		if (isEmpty()) {
			throw new ListEmptyException("List is empty");
		}

		if (head.next == null) {
			T data = head.data;
			head = null;
			size--;
			return data;
		}

		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}

		T data = current.next.data;
		current.next = null;
		size--;
		return data;
	}

	public T getFirst() {
		if (isEmpty()) {
			throw new ListEmptyException("List is empty");
		}
		return head.data;
	}

	public T getLast() {
		if (isEmpty()) {
			throw new ListEmptyException("List is empty");
		}

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}

		return current.data;
	}

	private class Node {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	@Override
	public String toStringRecursive() {
		return "[" + toStringRec(head, false) + "]";
	}

	@Override
	public String toStringReverseRecursive() {
		return "[" + toStringRec(head, true) + "]";
	}

	private String toStringRec(Node n, boolean reverse) {
		if (n == null)
			return "";
		if (n.next == null)
			return n.data.toString();

		if (reverse)
			return toStringRec(n.next, true) + "," + n.data;

		return n.data + "," + toStringRec(n.next, false);
	}
}
