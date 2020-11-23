package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] array = {};
    private int size = 0;

    public ImmutableArrayList() {    }

    public ImmutableArrayList(Object[] objs) {
        this.array = new Object[objs.length];
        System.arraycopy(objs, 0, this.array, 0, objs.length);
        this.size = objs.length;
    }

    private void indexError(int index, int check) {
        // check we use when we have adding elements
        if ((index < 0) || (this.size + check <= index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return this.add(this.size, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return this.addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return this.addAll(this.size, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        indexError(index, 1);
        Object[] newArray = new Object[this.size + c.length];
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        System.arraycopy(this.array, index,
                newArray, index + c.length, this.size - index);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        indexError(index, 0);
        return this.array[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        indexError(index, 0);
        Object[] newArray = new Object[this.size - 1];
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index + 1,
                newArray, index, this.size - index - 1);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        indexError(index, 0);
        Object[] newArray = new Object[this.size];
        System.arraycopy(this.array, 0, newArray, 0, this.size);
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size; ++i) {
            if (this.array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[this.size];
        System.arraycopy(this.array, 0, newArray, 0, this.size);
        return newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
