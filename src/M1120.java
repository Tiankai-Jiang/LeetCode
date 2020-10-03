public class M1120 {

    double max = Integer.MIN_VALUE;

    private double[] helper(TreeNode root){
        if(root == null) return new double[]{0, 0};
        double[] left = helper(root.left), right = helper(root.right);
        double count = 1 + left[1] + right[1], newAvg = (1/count)*root.val + (left[1]/count)*left[0] + (right[1]/count)*right[0];
        max = Math.max(max, newAvg);
        return new double[]{newAvg, count};
    }

    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;
    }
}
