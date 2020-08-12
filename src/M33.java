public class M33 {
    public int search(int[] nums, int target) {
        int n = nums.length, l = 0, h = n-1;
        while(l < h){
            int mid = l + (h-l)/2;
            if(nums[mid] > nums[h]) l = mid+1;
            else h = mid;
        }

        int rot=l;
        l=0;
        h=n-1;
        while(l<=h){
            int mid=(l+h)/2, m2 =(mid+rot)%n;
            if(nums[m2]==target) return m2;
            if(nums[m2]<target)l= mid+1;
            else h=mid-1;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2, num;
            if ((nums[mid] < nums[0]) == (target < nums[0])) num = nums[mid]; //nums [ mid ] 和 target 在同一段
            else num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE; //nums [ mid ] 和 target 不在同一段，同时还要考虑下变成 -inf 还是 inf

            if (num < target) lo = mid + 1;
            else if (num > target) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    // 我们可以先找到哪一段是有序的 (只要判断端点即可)，然后看 target 在不在这一段里，如果在，那么就把另一半丢弃。如果不在，那么就把这一段丢弃。
    public int search3(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) return mid;
            if (nums[start] <= nums[mid]) { //左半段是有序的
                if (target >= nums[start] && target < nums[mid]) end = mid - 1; //target 在这段里
                else start = mid + 1;
            } else { //右半段是有序的
                if (target > nums[mid] && target <= nums[end]) start = mid + 1; //target 在这段里
                else end = mid - 1;
            }
        }
        return -1;
    }
}
