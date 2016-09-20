package byte_array;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[]{72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33};
        String filePath = "/home/evgeniy/IdeaProjects/test/src/io/file/byte_array/file";
        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        FileOutputStream out = new FileOutputStream(filePath);

        while (in.available() > 0) {
            int aByte = in.read();
            System.out.print((char)aByte);
            out.write(aByte);
        }

        out.close();
        in.close();
    }
}
