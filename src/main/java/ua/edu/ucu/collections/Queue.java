package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList list = new ImmutableLinkedList();

    public Object peek() {
        if (list.isEmpty()){
            return null;
        }
        return list.getHead().getValue();
    }

    public Object dequeue() {
        if (list.isEmpty()){
            return null;
        }
        Object first = list.getFirst();
        list = list.removeFirst();
        return first;
    }

    public void enqueue(Object e) {
        list = list.addLast(e);
    }
}
