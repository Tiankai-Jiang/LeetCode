import java.util.*;
public class M93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()>12 || s.length() < 4) return res;
        for(int i=1; i<=3; i++){
            for(int j=i+1; j<s.length() && j<=i+3; j++){
                for(int k=j+1; k<s.length() && k<=j+3; k++){
                    String fst = s.substring(0, i), snd = s.substring(i, j), thd = s.substring(j, k), lst = s.substring(k);
                    if(fst.length() != 1 && fst.charAt(0) == '0') return res;
                    if((snd.length() != 1 && snd.charAt(0) == '0') || (thd.length() != 1 && thd.charAt(0) == '0') || (lst.length() != 1 && lst.charAt(0) == '0') || lst.length() > 3) continue;
                    int a = Integer.parseInt(fst), b = Integer.parseInt(snd), c = Integer.parseInt(thd), d = Integer.parseInt(lst);
                    if(a >=0 && a<256 && b>=0 && b<256 && c >=0 && c<256 && d>=0 && d<256)
                        res.add(new StringBuilder().append(a).append('.').append(b).append('.').append(c).append('.').append(d).toString());
                }
            }
        }
        return res;
    }
}
