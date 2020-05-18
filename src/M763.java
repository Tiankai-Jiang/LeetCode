import java.util.*;

public class M763 {

    // My solution, failed
    public List<Integer> partitionLabels(String S) {
        LinkedList<Integer> a = new LinkedList<>();
        int[][] occ = new int[26][2];
        int start = 0;
        for(int i = 0; i < 26; ++i) occ[i][0] = occ[i][1] = -1;
        for(int i = 0; i < S.length(); ++i){
            int ind = S.charAt(i)-'a';
            if(occ[ind][0] == -1) {
                occ[ind][0] = occ[ind][1] = i;
                start ++;
            }
            else occ[ind][1] = i;
        }
        Arrays.sort(occ, Comparator.comparingInt(o->o[1]));
        if(start == 1) a.add(S.length());
        else{
            int l = occ[25][0], r = occ[25][1], i = 25;
            for(int j=i-1; j>=26-start; --j){
                if(occ[j][1]<occ[i][0]){
                    a.addFirst(r-l+1);
                    l = occ[j][0];
                    r = occ[j][1];
                    i=j;
                }else{
                    l = Math.min(occ[j][0], l);
                }
            }
            if(l==0) a.addFirst(r-l+1);
        }
        return a;
    }

    public List<Integer> partitionLabels2(String S) {
        if(S == null || S.length() == 0) return null;
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char
        for(int i = 0; i < S.length(); i++) map[S.charAt(i)-'a'] = i;

        // record the end index of the current sub string
        int last = 0, start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
