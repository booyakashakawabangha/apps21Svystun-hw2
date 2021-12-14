package ua.edu.ucu.collections.immutable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {

    private Object[] array;
    private int length;

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public ImmutableArrayList(Object[] elements) {
        this.length = elements.length;
        array = elements.clone();

    }

    public ImmutableArrayList() {
        array = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        return this.add(length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newArray = Arrays.copyOf(array, length + 1);
        for (int idx = this.length; idx > index; idx--) {
            newArray[idx] = newArray[idx - 1];
        }
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        this.indexInRange(index);
        Object[] newArray = Arrays.copyOf(array, length + c.length);
        for (int idx = 0; idx < c.length; idx++) {
            newArray[index + idx] = c[idx];
        }
        for (int idx = index + c.length; idx < newArray.length; idx++) {
            newArray[idx] = array[idx - c.length];
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        this.indexInRange(index);
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) throws IndexOutOfBoundsException {
        this.indexInRange(index);
        Object[] newArray = new Object[length - 1];
        for (int idx = 0; idx < index; idx++) {
            newArray[idx] = array[idx];
        }
        for (int idx = index; idx < length - 1; idx++) {
            newArray[idx] = array[idx + 1];
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        this.indexInRange(index);
        Object[] newArray = Arrays.copyOf(array, length);
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) throws NoSuchElementException {
        for (int idx = 0; idx < length; idx++) {
            if (Objects.equals(e, array[idx])) {
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
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[length];
        for (int idx = 0; idx < length; idx++) {
            newArray[idx] = array[idx];
        }
        return newArray;
    }

    private boolean indexInRange(int index) throws IndexOutOfBoundsException{
        if (index > length || index < 0){
            throw new IndexOutOfBoundsException(
                    "Index is greater than the index of last element");
        }
        return false;
    }
}
