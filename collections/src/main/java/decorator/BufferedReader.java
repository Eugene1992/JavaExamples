package decorator;

public class BufferedReader extends Reader {

    private Reader reader;
    private int curs = 0;

    public BufferedReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    int read() {
        return reader.read();
    }

    @Override
    boolean ready() {
        return reader.ready();
    }

    public String readLine() {
        StringBuilder sb = new StringBuilder();
        int cur;
        while (true) {
            cur = read();
            if (cur == -1 || cur == '\n') break;
            sb.append((char)cur);
        }
        return sb.toString();
    }
}
