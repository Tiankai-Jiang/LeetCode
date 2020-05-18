public class E832 {

    // My solution
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] a = new int[A.length][A.length];
        for(int i = 0; i < A.length; ++i) for(int j = 0; j < A.length; ++j) a[i][j] = 1 - A[i][A.length - 1 - j];
        return a;
    }

    // Less memory
    public int[][] flipAndInvertImage2(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }
}
