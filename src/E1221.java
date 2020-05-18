import java.util.regex.*;

public class E1221 {

    // My solution
    public int balancedStringSplit(String s) {
        int c = 0, cL = 0, cR = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == 'L') cL++;
            else cR++;
            if(cL == cR){
                c++;
                cL = 0;
                cR = 0;
            }
        }
        return c;
    }

    // one counter is enough
    public int balancedStringSplit2(String s) {
        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == 'L' ? 1 : -1;
            if (cnt == 0) ++res;
        }
        return res;
    }
}
