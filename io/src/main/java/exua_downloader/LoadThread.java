package exua_downloader;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadThread implements Runnable {

    private String link;
    private InputStream in;
    private OutputStream out;
    private String path;
    private String extension;
    private static AtomicInteger counter = new AtomicInteger(0);

    public LoadThread(String link, String path, String extension) {
        this.extension = extension;
        this.path = path;
        this.link = link;
    }

    @Override
    public void run() {
        try {
            String filename = String.format("%s\\%s_%d.%s", path, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy_hh-mm-ss", new Locale("de"))), counter.incrementAndGet(), extension);
            in = new URL(link).openConnection().getInputStream();
            out = new FileOutputStream(new File(filename));
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buf)) > 0) {
                out.write(buf, 0, bytesRead);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
