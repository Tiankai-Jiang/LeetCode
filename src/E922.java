public class E922 {

    // My solution
    public int[] sortArrayByParityII(int[] A) {
        int[] a = new int[A.length];
        int e = -2, o = -1;
        for(int n : A){
            if(n%2==0) a[e+=2] = n;
            else a[o+=2] = n;
        }
        return a;
    }

    // In place solution
    public int[] sortArrayByParityII2(int[] A) {
        int i = 0, j = 1, n = A.length;
        while (i < n && j < n) {
            while (i < n && A[i] % 2 == 0) i += 2;
            while (j < n && A[j] % 2 == 1) j += 2;
            if (i < n && j < n) A[i] = (A[i] + A[j]) - (A[j] = A[i]);
        }
        return A;
    }
}
