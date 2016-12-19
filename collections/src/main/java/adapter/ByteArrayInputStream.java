package adapter;

public class ByteArrayInputStream extends InputStream {

    private byte[] data;
    private int curs = 0;

    public ByteArrayInputStream(byte[] data) {
        this.data = data;
    }

    @Override
    int read() {
        return available() > 0 ? data[curs++] : -1;
    }

    @Override
    int available() {
        return curs < data.length ? data.length : -1;
    }
}
