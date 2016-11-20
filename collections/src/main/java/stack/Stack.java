package stack;

public class Stack<T> {
    private Object[] data;
    private int cursor = -1;

    public Stack(int capacity) {
        data = new Object[capacity];
    }

    public void add(T elem) {
        data[++cursor] = elem;
    }

    public T get() {
        return (T) data[cursor--];
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>(3);
        stringStack.add("Hello1");
        stringStack.add("Hello2");
        stringStack.add("Hello3");

        System.out.println(stringStack.get());
        System.out.println(stringStack.get());
        System.out.println(stringStack.get());
    }
}
