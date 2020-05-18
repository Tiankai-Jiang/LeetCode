public class M1347 {

    // My solution
    public int minSteps(String s, String t) {
        int a = 0;
        int[] S = new int[26], T = new int[26];
        for(char c: s.toCharArray()) S[c-'a']++;
        for(char c: t.toCharArray()) T[c-'a']++;
        for(int i = 0; i < 26; ++i) if(S[i]<T[i]) a+= (T[i]-S[i]);
        return a;
    }
}
