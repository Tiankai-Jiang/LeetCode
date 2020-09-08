import java.util.*;
public class M3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int res = 0, chars[] = new int[128];
        for(int i=0, j=0; i<s.length(); i++){
            if(chars[s.charAt(i)] > 0) j = Math.max(j, chars[s.charAt(i)]);
            chars[s.charAt(i)] = i+1;
            res = Math.max(res, i-j+1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

