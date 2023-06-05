public class DSQuickFind implements DisjointSet {
    private int[] ds;

    public DSQuickFind(int size) {
        ds = new int[size];
        for (int i = 0; i < ds.length; i++) {
            ds[i] = i;
        }
    }
    @Override
    public void connect(int x, int y) {
        int yRoot = ds[y];
        int xRoot = ds[x];

        for (int i = 0; i < ds.length; i++) {
            if (ds[i] == xRoot)
                ds[i] = yRoot;
        }
    }
    @Override
    public boolean isConnected(int x, int y) {
        return ds[y] == ds[x];
    }
}
