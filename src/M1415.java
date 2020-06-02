import java.util.*;
public class M1415 {

    // My solution, O(n*k)
    public String getHappyString(int n, int k) {
        List<String>[] l = new List[n];
        l[0] = new LinkedList<String>(){{add("a");add("b");add("c");}};
        for(int i =1; i < n; ++i) {
            l[i] = new LinkedList<>();
            for(String s: l[i-1]){
                if(s.charAt(s.length()-1)=='a'){
                    l[i].add(s+"b");
                    l[i].add(s+"c");
                }else if(s.charAt(s.length()-1)=='b'){
                    l[i].add(s+"a");
                    l[i].add(s+"c");
                }else{
                    l[i].add(s+"a");
                    l[i].add(s+"b");
                }
            }
        }
        return k > l[n-1].size() ? "" : l[n-1].get(k-1);
    }

    //DFS
    int kCopy;
    char[] chars = {'a', 'b', 'c'};
    public String getHappyString(int n, int p, char last) {
        if(p==n) --kCopy;
        else{
            for(char c: chars){
                if(c!=last) {
                    String str = getHappyString(n, p+1, c);
                    if(kCopy==0) return c+str;
                }
            }
        }
        return "";
    }
    public String getHappyString2(int n, int k){
        kCopy = k;
        return getHappyString(n, 0, ' ');
    }

    // Math
    // For the string of size n, we can build 3 * pow(2, n - 1) strings. So, if k <= pow(2, n - 1), then the first letter is a, k <= 2 * pow(2, n - 1) - then b, otherwise c. We can also return empty string right away if k > 3 * pow(2, n - 1).
    //
    // We continue building the string using the same approach but now with two choices.
    // Fastest
    public String getHappyString3(int n, int k) {
        int prem = 1 << (n - 1);
        if (k > 3 * prem) return "";
        int ch = 'a' + (k - 1) / prem;
        StringBuilder sb = new StringBuilder(Character.toString((char)ch));
        while (prem > 1) {
            k = (k - 1) % prem + 1;
            prem >>= 1;
            ch = (k - 1) / prem == 0 ? 'a' + (ch == 'a' ? 1 : 0) : 'b' + (ch != 'c' ? 1 : 0);
            sb.append((char)ch);
        }
        return sb.toString();
    }
}
