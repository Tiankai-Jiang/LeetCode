import java.util.*;
public class E728 {

    // My solution
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> a = new ArrayList<>();
        for(int o = left; o <= right; ++o){
            int i = o;
            boolean b = true;
            while(i > 0){
                if(i%10 == 0 || o%(i%10) != 0) {
                    b = false;
                    break;
                }
                i /= 10;
            }
            if(b) a.add(o);
        }
        return a;
    }

    // j will be 0 at the end
    public List<Integer> selfDividingNumbers2(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if ((j % 10 == 0) || (i % (j % 10) != 0)) break;
            }
            if (j == 0) list.add(i);
        }
        return list;
    }
}
