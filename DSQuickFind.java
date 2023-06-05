public class DSQuickFind implements DisjointSet {
    private int[] ds;
    
    /*Time Complexity: θ(N)*/
    public DSQuickFind(int size) {
        ds = new int[size];
        for (int i = 0; i < ds.length; i++) {
            ds[i] = i;
        }
    }
    /*Time Complexity: θ(N)*/
    @Override
    public void connect(int x, int y) {
        int yRoot = ds[y];
        int xRoot = ds[x];

        for (int i = 0; i < ds.length; i++) {
            if (ds[i] == xRoot)
                ds[i] = yRoot;
        }
    }
    /*Time Complexity: O(1)*/
    @Override
    public boolean isConnected(int x, int y) {
        return ds[y] == ds[x];
    }
}
