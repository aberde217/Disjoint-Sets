public class DSQuickUnion implements DisjointSet {
    private int[] ds;

    public DSQuickUnion(int size) {
        ds = new int[size];
        for (int i = 0; i < ds.length; i++) {
            ds[i] = i;
        }
    }

    private int findParent(int val) {
        int next = ds[val];
        while (ds[next] != -1) {
            next = ds[next];
        }
        return next;
    }

    @Override
    public void connect(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);
        ds[yParent] = xParent;
    }

    @Override
    public boolean isConnected(int x, int y) {
        return findParent(x) == findParent(y);
    }
}