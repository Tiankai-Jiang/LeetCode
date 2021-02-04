public class M1540 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        int[] moves = new int[26];
        for(int i=0; i<s.length(); i++){
            int diff = t.charAt(i) - s.charAt(i);
            if(diff < 0) diff += 26;
            if(diff != 0) moves[diff-1]++;
        }
        for(int i=0; i<26; i++){
            if((moves[i]-1)*26 + i + 1 > k) return false;
        }
        return true;
    }
}

