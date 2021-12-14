package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {

    private Object[] array;
    private int length;

    @Override
    public String toString() {
        return "ImmutableArrayList = " + Arrays.toString(array) +
                ", length=" + length;
    }

    public ImmutableArrayList(Object[] elements) {
        this.length = elements.length;
        array = new Object[elements.length];
        for (int idx = 0; idx < elements.length; idx++){
            array[idx] = elements[idx];
        }
    }

    public ImmutableArrayList() {
        array = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] newArray = Arrays.copyOf(array, length+1);
        newArray[length] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newArray = Arrays.copyOf(array, length+1);
        for (int idx = this.length; idx > index; idx--){
            newArray[idx] = newArray[idx - 1];
        }
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] newArray = Arrays.copyOf(array, length + c.length);
        for (int idx = 0; idx < c.length; idx++){
            newArray[idx + length] = c[idx];
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) throws NoSuchElementException {
        for (int idx = 0; idx < length; idx++){
            if (Objects.equals(e, array[idx])){
                return idx;
            }
        }
        throw new NoSuchElementException("No such element in array");
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        this.length = 0;
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
