import java.util.*;
public class M889 {
    // My solution, WA, deleted

    // Recursive solution
    // Create a node TreeNode(pre[preIndex]) as the root.
    //
    // Because root node will be lastly iterated in post order,
    // if root.val == post[posIndex],
    // it means we have constructed the whole tree,
    //
    // If we haven't completed constructed the whole tree,
    // So we recursively constructFromPrePost for left sub tree and right sub tree.
    //
    // And finally, we'll reach the posIndex that root.val == post[posIndex].
    // We increment posIndex and return our root node.
    int preIndex = 0, posIndex = 0;
    public TreeNode constructFromPrePost(int[]pre, int[]post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex]) root.left = constructFromPrePost(pre, post);
        if (root.val != post[posIndex]) root.right = constructFromPrePost(pre, post);
        posIndex++;
        return root;
    }

    // Iterative solution
    // We will preorder generate TreeNodes, push them to stack and postorder pop them out.
    //
    // Iterate on pre array and construct node one by one.
    // stack save the current path of tree.
    // node = new TreeNode(pre[i]), if not left child, add node to the left. otherwise add it to the right.
    // If we meet a same value in the pre and post, it means we complete the construction for current subtree. We pop it from stack.
    public TreeNode constructFromPrePost2(int[] pre, int[] post) {
        Deque<TreeNode> s = new ArrayDeque<>();
        s.offer(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; ++i) {
            TreeNode node = new TreeNode(pre[i]);
            while (s.getLast().val == post[j]) {
                s.pollLast();
                j++;
            }
            if (s.getLast().left == null) s.getLast().left = node;
            else s.getLast().right = node;
            s.offer(node);
        }
        return s.getFirst();
    }
}
