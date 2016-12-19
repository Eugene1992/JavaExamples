package array_list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    private MyArrayList<String> myArrayList;
    private String testData = "Hello";

    @Before
    public void setUp() {
        myArrayList = new MyArrayList<>();
    }

    @Test
    public void size() throws Exception {
        final int EMPTY_ARRAY_LIST_SIZE = 0;
        assertEquals(EMPTY_ARRAY_LIST_SIZE, myArrayList.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void contains() throws Exception {
        myArrayList.add(testData);
        boolean result = myArrayList.contains(testData);
        assertTrue(result);
    }

    @Test
    public void add() throws Exception {
        boolean result = myArrayList.add(testData);
        assertTrue(result);
        assertEquals(1, myArrayList.size());
    }

    @Test
    public void ensureCapacity() throws Exception {
        for (int i = 0; i < 16; i++) {
            myArrayList.add(testData);
        }
        final int ENSURED_SIZE = 16;
        int result = myArrayList.size();
        assertEquals(result, ENSURED_SIZE);
    }

    @Test
    public void remove() throws Exception {
        for (int i = 0; i < 10; i++) {
            myArrayList.add(String.valueOf(i));
        }
        myArrayList.remove("4");
        System.out.println(myArrayList.get(4));
    }
}