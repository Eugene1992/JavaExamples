import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamExample {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/evgeniy/IdeaProjects/test/src/io/file/test");
        InputStream inputStream = new FileInputStream(file);
        byte[] buf = new byte[20];
        while (inputStream.available() > 0) {
            int oneByte = inputStream.read(buf);
            char[] chars = new char[20];
            for (int i = 0; i < buf.length; i++) {
                chars[i] = (char)buf[i];
            }
            System.out.println(Arrays.toString(chars));
        }
        inputStream.close();
    }
}
