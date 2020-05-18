public class M791 {

    // My solution
    public String customSortString(String S, String T) {
        int[] t = new int[26];
        for(char c : T.toCharArray()) t[c-'a']++;
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()) for(int i = 0; i < t[c-'a']--;) sb.append(c);
        for(int i=0; i < 26; ++i) for(int j = 0; j < t[i]; ++j) sb.append((char)('a'+i));
        return sb.toString();
    }
}
