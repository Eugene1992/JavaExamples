public class StringHashTest {
    public static void main(String[] args) {
        String str1 = "Meeting for the final time as peers, Obama and Merkel had a series of bilateral meetings, which involved talks about Russian sanctions, the fight against Islamic State, and the future of the EU-US trade agreement in the aftermath of Trump’s election victory.";
        String str2 = "Meeting for the final time as peers, Obama and Merkel had a series of bilateral meetings, which involved talks about Russian sanctions, the fight against Islamic State, and the future of the EU-US trade agreement in the aftermath of Trump’s election victoryu.";
        long start = System.nanoTime();
        str1.equals(str2);
        long end = System.nanoTime();
        System.out.println(end - start);

        String hash1 = hash(str1);
        long start2 = System.nanoTime();
        hash1.equals(hash(str2));
        long end2 = System.nanoTime();
        System.out.println(end2 - start2);
    }

    public static String hash(String str) {
        int hash = 0;
        for (char c : str.toCharArray()) {
            hash = hash * 31 + c;
        }
        return Integer.toHexString(hash);
    }
}
