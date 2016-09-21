package exua_downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> links = new HashSet<>();
        try {
            Document doc = Jsoup.connect("http://www.ex.ua/101115593?r=16984,23777").get();
            Elements elements = doc.select("a");
            for(Element element : elements){
                String link = element.absUrl("href");
                if (link.contains("load")) {
                    links.add(link);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in;
        OutputStream out;
        int counter = 0;
        String date = LocalDate.now().toString();
        System.out.println(date);
        for (String link : links) {
            try {
                URL url = new URL(link);
                URLConnection conn = url.openConnection();
                in = conn.getInputStream();
                out = new FileOutputStream(new File("C:\\Users\\Eugene\\IdeaProjects\\JavaExamples\\io\\src\\main\\java\\url\\" + date + "_" + ++counter + ".jpg"));
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
