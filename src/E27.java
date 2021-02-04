public class E27 {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0] == val ? 0: 1;
        int lo = 0, hi = nums.length-1;
        while(lo < hi){
            while(lo < nums.length && nums[lo]!=val) lo++;
            while(hi >= 0 && nums[hi]==val) hi--;
            if(lo<hi) nums[lo] = nums[lo] + nums[hi] - (nums[hi] = nums[lo]);
        }
        return lo;
    }

    int removeElement2(int A[], int elem) {
        int begin=0;
        for(int i=0;i<A.length;i++) if(A[i]!=elem) A[begin++]=A[i];
        return begin;
    }
}
