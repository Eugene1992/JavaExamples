package file_stream;

import java.io.*;

/**
 * Created by evgeniy on 15/09/16.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File from = new File("/home/evgeniy/IdeaProjects/test/src/io/file/file_stream/from");
        File to = new File("/home/evgeniy/IdeaProjects/test/src/io/file/file_stream/to");

        FileInputStream in = new FileInputStream(from);
        FileOutputStream out = new FileOutputStream(to);

        // returns the object of FileDescriptor that identifies the connection
        // to the actual file in the file system being used by this FileInputStream.
        FileDescriptor fd = in.getFD();
        boolean isValid = fd.valid();
        System.out.println(isValid);

        in.close();
        out.close();

    }
}
