import java.util.*;
public class M1329 {

    // My solution, a diagonal version of quick sort
    private int[] partition(int[][] mat, int ilo, int ihi, int jlo, int jhi) {
        int p = mat[ihi][jhi];
        int i = ilo-1, j = jlo-1;
        for(int k = ilo, l = jlo; k < ihi && l < jhi; ++k, ++l){
            if(mat[k][l] < p){
                i++;
                j++;
                mat[i][j] = (mat[i][j] + mat[k][l]) - (mat[k][l] = mat[i][j]);
            }
        }
        mat[++i][++j] = (mat[i][j] + mat[ihi][jhi]) - (mat[ihi][jhi] = mat[i][j]);
        return new int[]{i,j};
    }

    private void qs(int[][] mat, int ilo, int ihi, int jlo, int jhi){
        if(ilo >= ihi || jlo >= jhi) return;
        int[] p = partition(mat, ilo, ihi, jlo, jhi);
        qs(mat, ilo, p[0]-1, jlo, p[1]-1);
        qs(mat, p[0]+1, ihi, p[1]+1, jhi);
    }

    public int[][] diagonalSort(int[][] mat) {
        if(mat.length <= mat[0].length){
            for(int i = 0, j = mat.length-1; i < mat.length && j >=0; i++, j--) qs(mat, i, mat.length-1, 0, j);
            for(int j = 1; j < mat[0].length - mat.length; ++j) qs(mat, 0, mat.length-1, j, mat.length-1+j);
            for(int i = mat.length-1, j = mat[0].length-mat.length; i>=0 && j < mat[0].length; --i, ++j) qs(mat, 0, i, j, mat[0].length- 1);
        }else{
            for(int i = mat.length-mat[0].length, j = mat[0].length-1; i < mat.length && j >=0; ++i, --j) qs(mat, i, mat.length-1, 0, j);
            for(int i = 1; i < mat.length-mat[0].length; ++i) qs(mat, i, mat[0].length-1+i, 0, mat[0].length-1);
            for(int i = mat[0].length-1, j = 0; j < mat[0].length && i >=0; i--, j++) qs(mat, 0, i, j, mat[0].length- 1);
        }
        return mat;
    }

    // A[i][j] on the same diagonal have same value of i - j
    // For each diagonal,
    // put its elements together, sort, and set them back.
    public int[][] diagonalSort2(int[][] A) {
        int m = A.length, n = A[0].length;
        HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                d.putIfAbsent(i - j, new PriorityQueue<>());
                d.get(i - j).add(A[i][j]);
            }
        }
        for (int i = 0; i < m; ++i) for (int j = 0; j < n; ++j) A[i][j] = d.get(i - j).poll();
        return A;
    }

}
