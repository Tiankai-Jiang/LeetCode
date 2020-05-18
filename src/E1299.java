public class E1299 {

    // My solution
    public int[] replaceElements(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int m = arr[arr.length-1];
        int[] a = new int[arr.length];
        for(int i = arr.length - 2; i >= 0; --i) m = a[i] = Math.max(arr[i+1], m);
        a[a.length-1] = -1;
        return a;
    }

    // Inplace
    public int[] replaceElements2(int[] A) {
        for (int i = A.length - 1, mx = -1; i >= 0; --i) mx = Math.max(A[i], A[i] = mx);
        return A;
    }
}
