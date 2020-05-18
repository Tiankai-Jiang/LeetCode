import java.util.*;

public class M1395 {

    // My solution, O(n^2)
    public int numTeams(int[] rating) {
        int a = 0;
        Map<Integer, List<Integer>> m = new HashMap<>(), m2 = new HashMap<>();
        for (int i = 0; i < rating.length; ++i) {
            m.put(rating[i], new LinkedList<>());
            m2.put(rating[i], new LinkedList<>());
            for (int j = i + 1; j < rating.length; ++j) {
                if (rating[j] > rating[i]) m.get(rating[i]).add(rating[j]);
                else m2.get(rating[i]).add(rating[j]);
            }
        }
        for (int i = 0; i < rating.length; ++i) {
            for(int j : m.get(rating[i])) a+=m.get(j).size();
            for(int j : m2.get(rating[i])) a+=m2.get(j).size();
        }
        return a;
    }

    // Another O(n^2) solution
    // For each soldier, count how many soldiers on the left and right have less and greater ratings.
    //
    //This soldier can form less[left] * greater[right] + greater[left] * less[right] teams.
    public int numTeams2(int[] rating) {
        int res = 0;
        for (int i = 1; i < rating.length - 1; ++i) {
            int less[] = new int[2], greater[] = new int[2];
            for (int j = 0; j < rating.length; ++j) {
                if (rating[i] < rating[j]) ++less[j > i ? 1 : 0];
                if (rating[i] > rating[j]) ++greater[j > i ? 1 : 0];
            }
            res += less[0] * greater[1] + greater[0] * less[1];
        }
        return res;
    }

    // Use a tree to achieve O(nlogn)
}
