import java.util.*;

public class E771 {
    // My solution
    public int numJewelsInStones(String J, String S) {
        Set<Character> s = new HashSet<>();
        for(char c : J.toCharArray()){
            s.add(c);
        }
        int count = 0;
        for(char c : S.toCharArray()){
            if(s.contains(c)){
                count ++;
            }
        }
        return count;
    }

    // regex
    public int numJewelsInStones2(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }
}
