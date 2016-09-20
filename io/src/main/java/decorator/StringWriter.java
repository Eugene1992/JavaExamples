package decorator;

public class StringWriter implements Writable {

    @Override
    public void write(String str) {
        System.out.print(str);
    }
}
