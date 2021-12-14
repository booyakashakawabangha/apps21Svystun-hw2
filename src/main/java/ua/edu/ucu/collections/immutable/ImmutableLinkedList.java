package ua.edu.ucu.collections.immutable;

import java.util.ArrayList;
import java.util.Objects;

public final class ImmutableLinkedList implements ImmutableList {

    private Node head, tail;
    private int length;

    public ImmutableLinkedList(Object[] elements) {
        if (elements.length > 0) {
            Node value = new Node(elements[0]);
            head = value;
            tail = value;

            for (int idx = 1; idx < elements.length; idx++) {
                value = new Node(elements[idx]);
                tail.setNext(value);
                value.setPrevious(tail);
                tail = value;
                tail.setNext(null);
            }
        }
        length = elements.length;
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(length, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        ArrayList<Object> array = new ArrayList<>();
        Node temp = head;
        int idx = 0;
        while (idx != index && temp != null) {
            array.add(temp.getValue());
            temp = temp.getNext();
            idx++;
        }
        for (int inner = 0; inner < c.length; inner++) {
            array.add(c[inner]);
        }
        while (temp != null) {
            array.add(temp.getValue());
            temp = temp.getNext();
        }
        length = array.size();
        return new ImmutableLinkedList(array.toArray());
    }

    @Override
    public Object get(int index) {
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (idx == index) {
                return temp.getValue();
            }
            temp = temp.getNext();
            idx++;
        }
        return -1;
    }

    @Override
    public ImmutableList remove(int index) {
        ArrayList<Object> array = new ArrayList<>();
        Node temp = head;
        int idx = 0;
        while (temp != null){
            if (idx != index) {
                array.add(temp.getValue());
            }
            idx++;
            temp = temp.getNext();
        }
        return new ImmutableLinkedList(array.toArray());
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ArrayList<Object> array = new ArrayList<>();
        Node temp = head;
        int idx = 0;
        while (temp != null){
            if (idx != index) {
                array.add(temp.getValue());
            } else {
                array.add(e);
            }
            idx++;
            temp = temp.getNext();
        }
        return new ImmutableLinkedList(array.toArray());
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (Objects.equals(temp.getValue(), e)){
                return index;
            }
            index++;
            temp = temp.getNext();
        }
        return 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> array = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            array.add(temp.getValue());
            temp = temp.getNext();
        }
        return array.toArray();
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) addAll(0, new Object[] {e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) this.add(e);
    }

    public Node getHead() {
        return new Node(head.getValue());
    }

    public Node getTail() {
        return new Node(tail.getValue());
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size()-1);
    }

    @Override
    public String toString() {
        String result = "[";
        Node temp = head;
        while (temp.getNext() != null) {
            result += temp.getValue().toString() + ", ";
            temp = temp.getNext();
        }
        result += temp.getValue().toString() + "]";
        return result;
    }
}
