import java.util.*;
public class E637 {

    // My solution
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> l = new LinkedList<>();
        LinkedList<Double> a = new LinkedList<>();
        l.offer(root);
        int levelCount = 1, nextLevelCount = 0;
        while(l.size()!=0){
            double avg = 0;
            for(int i = 0; i < levelCount; i++){
                TreeNode n = l.poll();
                avg += n.val;
                if(n.left != null){
                    l.offer(n.left);
                    nextLevelCount++;
                }
                if(n.right != null){
                    l.offer(n.right);
                    nextLevelCount++;
                }
            }
            a.offer(avg/levelCount);
            levelCount = nextLevelCount;
            nextLevelCount = 0;
        }
        return a;
    }

    // levelCount is just the size of the queue, no need to use a variable to track it.
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(sum / n);
        }
        return result;
    }

    // DFS
    public List<Double> averageOfLevels3(TreeNode root) {
        // list answer for sum all value in same level
        List<Double> answer = new ArrayList<Double>();

        // list counter for count number of node in same level
        List<Integer> counter = new ArrayList<Integer>();

        // using dfs to sum all value in same level and count number of node in same level
        dfs(0, root, answer, counter);

        // answer will be answer[level] / counter[level]
        for (int level = 0; level < answer.size(); level++) answer.set(level, answer.get(level) / counter.get(level));
        return answer;
    }

    public void dfs(int level, TreeNode node, List<Double> answer, List<Integer> counter) {
        if (node == null) return;

        if (answer.size() <= level) {
            answer.add(0.0);
            counter.add(0);
        }
        answer.set(level, answer.get(level) + node.val);
        counter.set(level, counter.get(level) + 1);
        // go left node and right node
        dfs(level + 1, node.left, answer, counter);
        dfs(level + 1, node.right, answer, counter);
    }
}
