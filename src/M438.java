import java.util.*;
public class M438 {
    private boolean sameArr(int[] arrS, int[] arrP){
        for(int i=0; i<26; i++){
            if(arrS[i] != arrP[i]) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;
        int[] arrP = new int[26];
        for(char c: p.toCharArray()){
            arrP[c-'a']++;
        }
        int[] arrS = new int[26];
        for(int i=0; i<p.length(); i++){
            arrS[s.charAt(i)-'a']++;
        }
        if(sameArr(arrS, arrP)) res.add(0);
        for(int i=0; i<s.length()-p.length(); i++){
            arrS[s.charAt(i)-'a']--;
            arrS[s.charAt(i+p.length())-'a']++;
            if(sameArr(arrS, arrP)) res.add(i+1);
        }
        return res;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;
        int[] window = new int[26];
        for(char c: p.toCharArray()){
            window[c-'a']++;
        }
        int count = p.length();
        int windowStart = 0;
        for(int windowEnd=0; windowEnd<s.length(); windowEnd++){
            if(window[s.charAt(windowEnd)-'a']>0){
                count--;
            }
            window[s.charAt(windowEnd)-'a']--;

            if(count == 0){
                res.add(windowStart);
            }

            if(windowEnd-windowStart+1==p.length()){
                if(window[s.charAt(windowStart)-'a']>=0){
                    count++;
                }
                window[s.charAt(windowStart)-'a']++;
                windowStart++;
            }
        }
        return res;
    }
}
