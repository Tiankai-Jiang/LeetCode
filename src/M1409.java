import java.util.*;
public class M1409 {

    // My solution 1
    public int[] processQueries(int[] queries, int m) {
        int[] a = new int[queries.length];
        LinkedList<Integer> l = new LinkedList<>();
        for(int i = 1; i <= m; ++i) l.offer(i);
        for(int i = 0; i < queries.length; ++i){
            a[i] = l.indexOf(queries[i]);
            int tmp = l.get(a[i]);
            l.remove(a[i]);
            l.addFirst(tmp);
        }
        return a;
    }

    // Use a Fenwick tree
    public int[] processQueries2(int[] queries, int m) {
        int n = queries.length;
         /* The idea is to have put the numbers [1...m] at the back of an array of
        size [n+m] and then when moving elements to the front, fill up the unused
        space at [0..n-1] and keep the 'holes' at the previous position
        The get the current index for the solution, we count the number of elements
        before the element in question */

        // the last m positions of the array are set to 1
        // the rest is left at the default 0
        Fenwick f = new Fenwick(n+m);
        for (int i = 0; i < m; ++i) f.update(n+i, 1);

        // map from values to indices into the array
        Map<Integer, Integer> mp = new HashMap<>(m);
        for (int i = 1; i <= m; ++i) mp.put(i, n+i-1);

        // process queries
        int[] ans = new int[n];
        int cur = n-1;
        for (int i = 0; i < n; ++i) {
            int q = queries[i];

            // "move" q from current index to index cur
            int idx = mp.remove(q);
            mp.put(q, cur);

            // how many elements were in the array to the left of q
            ans[i] = f.getSum(idx-1);

            // q has been moved from idx to cur
            f.update(idx, -1);
            f.update(cur, 1);

            // the next element will get placed at cur-1
            cur--;
        }
        return ans;
    }
}

class Fenwick {

    private int[] arr;
    private final int size;

    public Fenwick(int n) {
        this.size = n+1;
        this.arr = new int[size];
    }

    public Fenwick(int[] nums) {
        this.size = nums.length + 1;
        this.arr = new int[size];
        for (int i = 0; i < nums.length; ++i) {
            this.update(i, nums[i]);
        }
    }

    private int nextIdx(int idx) {
        return idx + (-idx & idx);
    }

    private int getParentIdx(int idx) {
        return idx - (-idx & idx);
    }

    public void update(int index, int val) {
        index++;
        while (index < size) {
            arr[index] += val;
            index = nextIdx(index);
        }
    }

    // get sum of elements arr[0..index], inclusive
    public int getSum(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += arr[index];
            index = getParentIdx(index);
        }
        return sum;
    }
}