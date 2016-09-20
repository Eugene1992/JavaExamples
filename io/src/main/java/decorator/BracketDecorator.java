package decorator;

public class BracketDecorator implements Writable {

    private Writable writable;

    public BracketDecorator(Writable writable) {
        this.writable = writable;
    }

    @Override
    public void write(String str) {
        System.out.print("[");
        writable.write(str);
        System.out.print("]");
    }
}
