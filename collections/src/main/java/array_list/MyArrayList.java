package array_list;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private Object[] elementData;
    private static int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public MyArrayList() {
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elementData = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (checkCapacity() == 0) ensureCapacity();
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int removedIndex = indexOf(o);
        if (removedIndex < 0) {
            return false;
        } else {
            System.arraycopy(elementData, removedIndex + 1, elementData, removedIndex, size - 1 - removedIndex);
            elementData[removedIndex] = null;
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (Object elem : elementData) elem = null;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(o)) index = i;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public void ensureCapacity() {
        final int newCapacity = elementData.length * 3 / 2 + 1;
        Object[] temp = new Object[newCapacity];
        System.arraycopy(elementData, 0, temp, 0, elementData.length);
        elementData = temp;
        temp = null;
    }

    private int checkCapacity() {
        return elementData.length - size;
    }
}
