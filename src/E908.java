public class E908 {

    // My solution
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i: A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return Math.max(0, max-min- 2*K);
    }
}
