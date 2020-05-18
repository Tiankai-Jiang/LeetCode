public class M1111 {

    // My solution
    public int[] maxDepthAfterSplit(String seq) {
        int c = 0, max = 0;
        int[] a = new int[seq.length()];
        char[] vps = seq.toCharArray();
        for(int i = 0; i < vps.length; ++i){
            if(vps[i] == '('){
                a[i] = ++c;
                if(c>max) max = c;
            }else a[i] = c--;
        }
        for(int i = 0; i < a.length; ++i) a[i] = a[i] > max/2 ? 1 : 0;
        return a;
    }

    // Alternatively Distribute Parentheses
    // Basically, ( is 1 point, ) is -1 point.
    // We try to keep total points of two groups even by distributing parentheses alternatively.
    public int[] maxDepthAfterSplit2(String seq) {
        int res[] = new int[seq.length()];
        for (int i = 0; i < seq.length(); ++i) res[i] = seq.charAt(i) == '(' ? i & 1 : (1 - i & 1);
        return res;
    }

    // Keep Two Group Even
    // Count the number of open parentheses of group A and group B.
    public int[] maxDepthAfterSplit3(String seq) {
        int A = 0, B = 0, n = seq.length();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            if (seq.charAt(i) == '(') {
                if (A < B) ++A;
                else {
                    ++B;
                    res[i] = 1;
                }
            } else {
                if (A > B) --A;
                else {
                    --B;
                    res[i] = 1;
                }
            }
        }
        return res;
    }
}
