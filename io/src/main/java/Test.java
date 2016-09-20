import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        // An abstract representation of file and directory pathnames.
        File file = new File("test2.txt");
        boolean isCreated;

        // Create new file if it not exists
        if (!file.exists()) {
            isCreated = file.createNewFile();
        }

        // Get file path(file name)
        String path = file.getPath();
        System.out.println(path);

        // Get canonical path(file name)
        String canonicalPath = file.getCanonicalPath();
        System.out.println(canonicalPath);

        // Get absolute path(file name)
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        FileReader fis = new FileReader(file);
        while (fis.ready()) {
            System.out.print((char)fis.read());
        }
        fis.close();
    }
}
