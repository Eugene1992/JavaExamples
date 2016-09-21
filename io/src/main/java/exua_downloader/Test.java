package exua_downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eugene on 21.09.2016.
 */
public class Test {
    public static void main(String[] args) {
        Set<String> links = new HashSet<>();
        try {
            Document doc = Jsoup.connect("http://www.ex.ua/101115593?r=16984,23777").get();
            Elements elements = doc.select("a");
            for(Element element : elements){
                String link = element.absUrl("href");
                if (link.contains("load")) links.add(link);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String link : links) {
            Thread thread = new Thread(new LoadThread(link, "C:\\Users\\Eugene\\IdeaProjects\\JavaExamples\\io\\src\\main\\java\\exua_downloader", "jpg"));
            thread.start();
        }
    }
}
