package iterator;

import java.util.Iterator;

public class Zoo<T extends Animal> implements Iterable<T>{

    private Object[] animals;
    private int size;

    public Zoo(int capacity) {
        animals = new Object[capacity];
    }

    public void add(T animal) {
        animals[size++] = animal;
    }

    @Override
    public Iterator<T> iterator() {
        return new ZooIterator();
    }

    private class ZooIterator implements Iterator<T> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T)animals[position++];
            }
            return null;
        }
    }
}
