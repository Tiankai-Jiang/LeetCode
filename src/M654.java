import java.util.*;
public class M654 {

    // My solution， O(n2)
    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int h){
        if(l>h) return null;
        int max = Integer.MIN_VALUE, maxInd = -1;
        for(int i = l; i <=h; ++i) {
            if(nums[i]>max){
                max = nums[i];
                maxInd = i;
            }
        }
        TreeNode n = new TreeNode(max);
        n.left = constructMaximumBinaryTree(nums, l, maxInd-1);
        n.right = constructMaximumBinaryTree(nums, maxInd+1, h);
        return n;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    // When I see solution like this, I always doubt the meaning of my life
    // https://leetcode.com/problems/maximum-binary-tree/discuss/106156/Java-worst-case-O(N)-solution
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) curr.left = stack.pop();
            if(!stack.isEmpty()) stack.peek().right = curr;
            stack.push(curr);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }
}
