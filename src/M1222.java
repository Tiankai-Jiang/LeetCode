import java.util.*;
public class M1222 {

    // My solution
    private boolean inArray(int[][] queens, int x, int y){
        for(int[] a : queens) if(a[0]==x && a[1]==y) return true;
        return false;
    }

    private void add(List<List<Integer>> a, int i, int j){
        a.add(new ArrayList<Integer>(){{add(i);add(j);}});
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> a = new ArrayList<>();
        int x = king[0], y = king[1];
        for(int i = x-1, j = y-1; i>=0&&j>=0; --i, --j) if(inArray(queens, i, j)) { add(a, i, j);break; }
        for(int i = x-1; i >=0; --i) if(inArray(queens, i, y)) { add(a,i,y);break; }
        for(int i = x-1, j = y+1; i>=0&&j<8; --i, ++j) if(inArray(queens, i, j)) { add(a, i, j);break; }
        for(int i = y-1; i >=0; --i) if(inArray(queens, x, i)) { add(a,x,i);break; }
        for(int i = y+1; i <8; ++i) if(inArray(queens, x, i)) { add(a,x,i);break; }
        for(int i = x+1, j = y-1; i<8&&j>=0; ++i, --j) if(inArray(queens, i, j)) { add(a, i, j);break; }
        for(int i = x+1; i <8; ++i) if(inArray(queens, i, y)) { add(a,i,y);break; }
        for(int i = x+1, j = y+1; i<8&&j<8; ++i, ++j) if(inArray(queens, i, j)) { add(a, i, j);break; }
        return a;
    }

    // Simpler implementation, slower
    public List<List<Integer>> queensAttacktheKing2(int[][] queens, int[] king) {
        List<List<Integer>> a = new ArrayList<>();
        Set<String> s = new HashSet<>();
        for(int[] q:queens) s.add(q[0] + "" + q[1]);
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                for(int k = 1; k <= 8; k++){
                    if (s.contains((king[0] + i*k) + "" + (king[1] + j*k))){
                        a.add(Arrays.asList(king[0] + i*k, king[1] + j*k));
                        break;
                    }
                }
            }
        }
        return a;
    }
}
