package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolClassTest {

    public static void main(String[] args) {
        System.out.println(test("pizza"));   //true
        System.out.println(test("@pizza"));  //false
        System.out.println(test("pizza3"));  //false
        System.out.println(test("a"));
        System.out.println(test("v"));
    }

    public static boolean test(String testString){
        Pattern p = Pattern.compile("^[a-z]+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
}
