public class DSQuickUnion implements DisjointSet {
    private int[] ds;
    
    /*Time Complexity: θ(N)*/
    public DSQuickUnion(int size) {
        ds = new int[size];
        for (int i = 0; i < ds.length; i++) {
            ds[i] = -1;
        }
    }

    private int findParent(int val) {
        int next = ds[val];
        while (ds[next] != -1) {
            next = ds[next];
        }
        return next;
    }
    
    /*Time Complexity: θ(N)*/
    @Override
    public void connect(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);
        ds[yParent] = xParent;
    }
    
    /*Time Complexity: θ(N)*/
    @Override
    public boolean isConnected(int x, int y) {
        return findParent(x) == findParent(y);
    }
}
