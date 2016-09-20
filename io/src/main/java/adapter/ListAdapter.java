package adapter;

/**
 * Created by Eugene on 20.09.2016.
 */
public class ListAdapter implements BetaList {
    private AlphaList list;

    public ListAdapter(AlphaList list) {
        this.list = list;
    }

    public int getValue(int index) {
        return this.list.get(index);
    }

    public void setValue(int index, int value) {
        this.list.set(index, value);
    }

    public int getSize() {
        return this.list.count();
    }

}
