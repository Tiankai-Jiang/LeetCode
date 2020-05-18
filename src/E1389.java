import java.util.LinkedList;
public class E1389 {

    // My O(n^2) solution
    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> a = new LinkedList<>();
        for(int i = 0; i < nums.length; ++i) a.add(index[i], nums[i]);
        return a.stream().mapToInt(i->i).toArray();
    }

    /**
     For each index i, if there are j indices on the left, which is >= i, all those j needs to bump 1.
     In other words, for each index i, if there are x indices on the right which are <= i, i needs to bump x.
     e.g., nums = [0,1,2,3,4], index = [0,1,2,2,1].
     Number of elements on the right which is <= the current element: [0, 1, 2, 1, 0],
     Then add to the original index to get [0, 2, 4, 3, 1], which is the final index to set nums.

     Finding number of elements on the right <= self, can be found in O(nlogn) using merge sort.
     * */
    public int[] createTargetArray2(int[] nums, int[] index) {
        int n = nums.length;
        int[] a = new int[n];
        for(int i = 0; i < n; ++i) a[i] = i;
        helper(a, 0, n, index, new int[n]);
        int[] result = new int[n];
        for(int i = 0; i < n; ++i) result[index[i]] = nums[i];
        return result;
    }

    static void helper(int[] a, int i, int j, int[] index, int[] tmp) {
        if (j - i <= 1) return;
        int k = (i + j) >>> 1;
        helper(a, i, k, index, tmp);
        helper(a, k, j, index, tmp);
        int x = i, y = k, z = 0, count = 0;
        while(x < k && y < j) {
            while(y < j && index[a[y]] <= index[a[x]] + count) {
                ++count;
                tmp[z++] = a[y++];
            }
            index[a[x]] += count;
            tmp[z++] = a[x++];
        }
        while(x < k) {
            index[a[x]] += count;
            tmp[z++] = a[x++];
        }
        while(y < j) tmp[z++] = a[y++];
        for(int p = i, q = 0; p < j; ++p, ++q) a[p] = tmp[q];
    }
}
