package exua_downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
//        http://www.ex.ua/92864682?r=16984,23777 //cats
//        http://www.ex.ua/101115593?r=16984,23777
        download(
                "http://www.ex.ua/101115593?r=16984,23777",
                "C:\\Users\\Eugene\\Desktop\\cats",
                ".jpeg"
        );
    }

    private static Set<String> getUniqueLinks(String url) {
        Set<String> links = new HashSet<>();
        try {
            Document doc = Jsoup.connect(url).get();
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
        System.out.println(links);
        return links;
    }

    public static void download(String url, String path, String extension) {
        for (String link : getUniqueLinks(url)) {
            Thread thread = new Thread(new LoadThread(link, path, extension));
            thread.start();
        }
    }
}
