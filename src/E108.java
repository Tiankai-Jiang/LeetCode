public class E108 {

    // My solution
    public TreeNode soredArrayToBST(int l, int r, int[] nums){
        if(l>r) return null;
        int ind = l+(r - l)/2;
        TreeNode root = new TreeNode(nums[ind]);
        root.left = soredArrayToBST(l, ind-1, nums);
        root.right = soredArrayToBST(ind + 1, r, nums);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return soredArrayToBST(0, nums.length-1, nums);
    }
}
