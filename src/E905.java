public class E905 {

    // My solution 1, slow
    public int[] sortArrayByParity(int[] A) {
        int[] a = new int[5001], b = new int[A.length];
        for(int i : A) a[i]++;
        int cur = 0;
        for(int i = 0; i < 5001; i+=2) if(a[i]!=0) for(int j = 0; j < a[i]; ++j) b[cur++] = i;
        for(int i = 1; i < 5001; i+=2) if(a[i]!=0) for(int j = 0; j < a[i]; ++j) b[cur++] = i;
        return b;
    }

    // My solution 2, fast
    public int[] sortArrayByParity2(int[] A){
        int i = 0, j = A.length - 1;
        while(i != j){
            if(A[i] % 2 == 0) i++;
            else A[i] = (A[i] + A[j]) - (A[j--] = A[i]);
        }
        return A;
    }
}
