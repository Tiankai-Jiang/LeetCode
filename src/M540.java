public class M540 {

    // My solution
    private int binarySearch(int lo, int hi, int[] nums){
        if(hi-lo==0) return nums[lo];
        int len = (hi-lo)/2, mid = lo+len;
        if(nums[mid]==nums[mid+(2*(len&1)-1)]) return binarySearch(lo, mid-(len&1), nums);
        else if(nums[mid]==nums[mid+(1-2*(len&1))]) return binarySearch(mid+(len&1), hi, nums);
        else return nums[mid];
    }

    public int singleNonDuplicate(int[] nums) {
        return binarySearch(0, nums.length-1, nums);
    }

    // Iterative
    public static int singleNonDuplicate2(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            // We want the first element of the middle pair,
            // which should be at an even index if the left part is sorted.
            // Example:
            // Index: 0 1 2 3 4 5 6
            // Array: 1 1 3 3 4 8 8
            //            ^
            int mid = (start + end) / 2;
            if (mid % 2 == 1) mid--;
            // We didn't find a pair. The single element must be on the left.
            // (pipes mean start & end)
            // Example: |0 1 1 3 3 6 6|
            //               ^ ^
            // Next:    |0 1 1|3 3 6 6
            if (nums[mid] != nums[mid + 1]) end = mid;
                // We found a pair. The single element must be on the right.
                // Example: |1 1 3 3 5 6 6|
                //               ^ ^
                // Next:     1 1 3 3|5 6 6|
            else start = mid + 2;
        }
        // 'start' should always be at the beginning of a pair.
        // When 'start > end', start must be the single element.
        return nums[start];
    }

    // Find the first index whose "partner index" (the index xor 1) holds a different value.
    public int singleNonDuplicate3(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] == nums[mid ^ 1]) lo = mid + 1;
            else hi = mid;
        }
        return nums[lo];
    }
}
