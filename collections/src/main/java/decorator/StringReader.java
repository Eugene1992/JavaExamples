package decorator;

public class StringReader extends Reader {

    private String data;
    private int curs = 0;

    public StringReader(String data) {
        this.data = data;
    }

    @Override
    int read() {
        return ready() ? data.charAt(curs++) : -1;
    }

    @Override
    boolean ready() {
        return curs < data.length();
    }
}
