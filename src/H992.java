public class H992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;
        int prefix = 0;
        int[] counts = new int[A.length];
        int count = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < A.length; windowEnd++){
            counts[A[windowEnd]-1]++;
            if(counts[A[windowEnd]-1] == 1){
                count++; //if the number never appears in the window, add count by 1
            }
            if(count > K){ // we extend the window end too much, reduce the window
                counts[A[windowStart]-1]--;
                windowStart++;
                count--;
                prefix = 0;
            }
            while(counts[A[windowStart]-1] > 1){ // search the prefix length
                counts[A[windowStart]-1]--;
                windowStart++;
                prefix++;
            }
            if(count == K){
                res += (prefix + 1);
            }
        }
        return res;
    }
}
