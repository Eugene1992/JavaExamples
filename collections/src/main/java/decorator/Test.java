package decorator;

public class Test {
    public static void main(String[] args)  {

        String str = "Hello\n world!";

        Reader reader = new StringReader(str);

        while (reader.ready()) {
            System.out.print((char)reader.read());
        }

        /*BufferedReader bufReader = new BufferedReader(new StringReader(str));
        System.out.println(bufReader.readLine());*/
    }
}
