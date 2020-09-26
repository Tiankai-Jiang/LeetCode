import java.util.*;
public class E202 {

    private int getSum(int n){
        int res = 0;
        while(n != 0){
            res += (n%10)*(n%10);
            n /= 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while(true){
            n = getSum(n);
            if(n==1) return true;
            else {
                if(s.contains(n)) return false;
                s.add(n);
            }
        }
    }

    public boolean isHappy2(int n) {
        int x = n, y = n;
        while(x>1){
            x = getSum(x) ;
            if(x==1) return true;
            y = getSum(getSum(y));
            if(y==1) return true;
            if(x==y) return false;
        }
        return true;
    }
}
