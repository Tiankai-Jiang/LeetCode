import java.util.*;
public class M378 {

    // Using a priority queue
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for(int i=0; i < matrix.length; ++i) pq.offer(new int[]{0, i, matrix[0][i]});
        for(int i=0; i < k-1; ++i){
            int[] l = pq.poll();
            if(l[0]<matrix.length-1) pq.offer(new int[]{l[0]+1, l[1], matrix[l[0]+1][l[1]]});
        }
        return pq.poll()[2];
    }

    // Binary search
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length, lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2, c = 0;
            for(int i=0, j=n-1; i<n; ++i){
                while(j >= 0 && matrix[i][j] > mid) j--;
                c += (j+1);
            }
            if (c < k) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
}
