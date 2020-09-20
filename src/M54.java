import java.util.*;
public class M54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0) return res;
        int left = 0, right = matrix[0].length-1, upper = 0, lower = matrix.length-1, cur = 0;
        while(left<=right && upper<=lower){
            switch (cur%4){
                case 0:
                    for(int i=left; i<=right;i++) res.add(matrix[upper][i]);
                    upper++;
                    break;
                case 1:
                    for(int i=upper; i<=lower;i++) res.add(matrix[i][right]);
                    right--;
                    break;
                case 2:
                    for(int i=right; i>=left; i--) res.add(matrix[lower][i]);
                    lower--;
                    break;
                default:
                    for(int i=lower; i>=upper; i--) res.add(matrix[i][left]);
                    left++;
            }
            cur++;
        }
        return res;
    }
}
