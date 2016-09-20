package decorator;

public class Test {
    public static void main(String[] args) {
        StringWriter stringWriter = new StringWriter();
        //stringWriter.write("Hello world!");

        BracketDecorator quoteDecorator = new BracketDecorator(new QuoteDecorator(stringWriter));
        quoteDecorator.write("Hello world!");
    }
}
