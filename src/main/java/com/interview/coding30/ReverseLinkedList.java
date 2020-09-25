package com.interview.coding30;

import java.util.StringJoiner;

public class ReverseLinkedList<T> {
    private Node head;

    private class Node {
        final T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(T value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
    }

    public void reverse() {
        if (head == null) {
            return;
        }
        Node following = head;
        Node current = head;
        Node prev = null;
        while (current != null) {
            following = following.next;
            current.next = prev;
            prev = current;
            current = following;
        }
        head = prev;
    }

    public boolean remove(T value) {
        if (head == null) {
            return false;
        }
        Node node = head;
        Node prev = null;
        do {
            if (node.value.equals(value)) {
                if (prev == null) {
                    head = node.next;
                } else {
                    prev.next = node.next;
                }
                return true;
            }
            prev = node;
            node = node.next;
        } while (node != null);
        return false;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("->", "[", "]");
        Node last = head;
        while (last != null) {
            joiner.add(last.value.toString());
            last = last.next;
        }
        return joiner.toString();
    }
}
