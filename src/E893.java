import java.util.*;

public class E893 {

    // My solution
    public String sort(String s){
        if(s.length()<=2) return s;
        int[] e = new int[26], o = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            if(i%2==0) e[s.charAt(i)-'a']++;
            else o[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int cur1 = 0, cur2 = 0, c = 0;
        while(true){
            while (e[cur1]==0) cur1++;
            sb.append((char)('a'+cur1));
            e[cur1]--;
            if(++c == s.length()) break;
            while (o[cur2]==0) cur2++;
            sb.append((char)('a'+cur2));
            o[cur2]--;
            if(++c == s.length()) break;
        }
        return sb.toString();
    }

    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for(String s : A) set.add(sort(s));
        return set.size();
    }

    // Generate a unique signature for a string is enough, I am so stupid..
    public int numSpecialEquivGroups2(String[] A) {
        Set<String> set= new HashSet<>();
        for (String s: A){
            int[] odd= new int[26];
            int[] even= new int[26];
            for (int i=0; i<s.length(); i++){
                if (i%2==1) odd[s.charAt(i)-'a']++;
                else even[s.charAt(i)-'a']++;
            }
            String sig= Arrays.toString(odd)+Arrays.toString(even);
            set.add(sig);
        }
        return set.size();
    }
}
