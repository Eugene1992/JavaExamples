package regex;

import java.util.StringTokenizer;

public class TokenizerTest {
    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer("Hello, world! Hello, planet!");
        while (stringTokenizer.hasMoreElements()) {
            String s = stringTokenizer.nextToken();
            Object o = stringTokenizer.nextElement();
            System.out.println(s);
            System.out.println(o);
        }
    }
}
