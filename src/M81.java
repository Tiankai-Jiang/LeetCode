public class M81 {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) return true;
            if ((nums[start] == nums[mid]) && (nums[end] == nums[mid])) {
                ++start;
                --end;
            } else if (nums[start] <= nums[mid]) { //左半段是有序的
                if (target >= nums[start] && target < nums[mid]) end = mid - 1; //target 在这段里
                else start = mid + 1;
            } else { //右半段是有序的
                if (target > nums[mid] && target <= nums[end]) start = mid + 1; //target 在这段里
                else end = mid - 1;
            }
        }
        return false;
    }
}
