import java.util.*;

public class M1239 {
    public int maxLength(List<String> arr) {
        return helper(arr, 0, "");
    }

    private int helper(List<String> arr, int index, String cur) {
        if (index == arr.size()) return cur.length();
        int res = cur.length();
        for (int i = index; i < arr.size(); i++) {
            String str = cur + arr.get(i);
            if (isUnique(str)) res = Math.max(res, helper(arr, i + 1, str));
        }
        return res;
    }

    private boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) if (!set.add(c)) return false;
        return true;
    }
}
