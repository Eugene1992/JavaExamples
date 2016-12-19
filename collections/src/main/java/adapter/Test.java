package adapter;

public class Test {
    public static void main(String[] args) {

        byte[] data = {15, 21, 56, 12, 44, 53, 124};

        InputStream is = null;

        is = new ByteArrayInputStream(data);

        while (is.available() > 0) {
            int aByte = is.read();
            System.out.print(aByte);
        }


    }
}
