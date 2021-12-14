package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList list = new ImmutableLinkedList();

    public void push(Object e) {
        list = list.addLast(e);
    }

    public Object pop() {
        if (list.isEmpty()){
            return null;
        }
        Object last = list.getLast();
        list = list.removeLast();
        return last;
    }

    public Object peek() {
        if (list.isEmpty()){
            return null;
        }
        return list.getTail();
    }
}
