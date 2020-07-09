import java.util.*;
public class M89 {

    // 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100).
    // The middle two numbers only differ at their highest bit, while the rest numbers of part two are exactly symmetric of part one.
    public List<Integer> grayCode(int n) {
        List<Integer> rs = new ArrayList<Integer>(){{add(0);}};
        for(int i=0;i<n;i++) for(int k=rs.size()-1; k>=0; k--) rs.add(rs.get(k) | 1<<i);
        return rs;
    }

    // Magic
    public List<Integer> grayCode2(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}
