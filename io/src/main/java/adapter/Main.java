package adapter;

/**
 * Created by Eugene on 20.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        AlphaList listAlpha = AlphaListManager.createList();
        BetaList listBeta = new ListAdapter(listAlpha);
        BetaSaveManager.saveList(listBeta);
    }
}
