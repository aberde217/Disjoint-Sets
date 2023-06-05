public class DSWeightedQuickUnion implements DisjointSet {
    private int ds[];
    private int setSize[];
    public DSWeightedQuickUnion(int size) {
        ds = new int[size];
        setSize = new int[size];
        for (int i = 0; i < size; i++) {
            ds[i] = -1;
            setSize[i] = 1;
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

        if (setSize[xParent] < setSize[yParent]) {
            ds[xParent] = yParent;
            setSize[yParent] += setSize[xParent];
        } else {
            ds[yParent] = xParent;
            setSize[xParent] += setSize[yParent];
        }

    }

    @Override
    public boolean isConnected(int x, int y) {
        return findParent(x) == findParent(y);
    }

}
