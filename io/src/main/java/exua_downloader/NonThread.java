package exua_downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class NonThread {
    public static void main(String[] args) {

        final String DOWNLOAD_URL = "http://www.ex.ua/104013112?r=904,23777";
        final String PATH = "C:\\Users\\Eugene\\Desktop\\cats";
        final String EXTENSION = "jpeg";

        Set<String> links = new HashSet<>();
        try {
            Document doc = Jsoup.connect(DOWNLOAD_URL).get();
            Elements elements = doc.select("a");
            for(Element element : elements){
                String link = element.absUrl("href");
                if (link.contains("load") && !link.contains("id")) {
                    links.add(link);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in;
        OutputStream out;
        int counter = 0;
        for (String link : links) {
            try {
                URL url = new URL(link);
                URLConnection conn = url.openConnection();
                String filename = String.format("%s\\%s_%d.%s", PATH, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy_hh-mm-ss")), ++counter, EXTENSION);
                in = conn.getInputStream();
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
}
