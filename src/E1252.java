public class E1252 {

    // My solution
    public int oddCells(int n, int m, int[][] indices) {
        int[] r = new int[n], c = new int[m];
        int cr = 0, cc = 0;
        for(int[] p : indices){
            r[p[0]]++;
            c[p[1]]++;
        }
        for(int i = 0; i < n; ++i) if(r[i] % 2 == 0) cr++;
        for(int i = 0; i < m; ++i) if(c[i] % 2 == 0) cc++;
        return cr * (m-cc) + (n-cr)*cc;
    }

    // Use boolean or bitset since we only care about odd or even but not the exact number
    public int oddCells2(int n, int m, int[][] indices) {
        boolean[] oddRows = new boolean[n], oddCols = new boolean[m];
        int cntRow = 0, cntCol = 0;
        for (int[] idx : indices) {
            oddRows[idx[0]] ^= true;
            oddCols[idx[1]] ^= true;
            cntRow += oddRows[idx[0]] ? 1 : -1;
            cntCol += oddCols[idx[1]] ? 1 : -1;
        }
        return (m - cntCol) * cntRow + (n - cntRow) * cntCol;
    }
}
