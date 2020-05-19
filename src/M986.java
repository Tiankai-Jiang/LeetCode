import java.util.*;

public class M986 {

    // My solution
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> a = new ArrayList<>();
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            if(A[i][1] < B[j][0]) i++;
            else if(B[j][1] < A[i][0]) j++;
            else if(A[i][0] == B[j][0]){
                if(A[i][1]>B[j][1]) a.add(new int[]{B[j][0], B[j++][1]});
                else if(A[i][1]==B[j][1]) a.add(new int[]{A[i++][0], B[j++][1]});
                else a.add(new int[]{A[i][0], A[i++][1]});
            }else if(A[i][0] < B[j][0]){
                if(A[i][1]>B[j][1]) a.add(new int[]{B[j][0], B[j++][1]});
                else if(A[i][1]==B[j][1]) {
                    a.add(new int[]{B[j][0], B[j++][1]});
                    i++;
                }else a.add(new int[]{B[j][0], A[i++][1]});
            }else if(A[i][0] > B[j][0]){
                if(A[i][1]<B[j][1]) a.add(new int[]{A[i][0], A[i++][1]});
                else if(A[i][1]==B[j][1]){
                    a.add(new int[]{A[i][0], A[i++][1]});
                    j++;
                }else a.add(new int[]{A[i][0], B[j++][1]});
            }
        }
        return a.toArray(new int[a.size()][]);
    }

    // A more concise version
    public int[][] intervalIntersection2(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0) return new int[][]{};
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0, startMax, endMin;
        while(i < A.length && j < B.length){
            startMax = Math.max(A[i][0], B[j][0]);
            endMin = Math.min(A[i][1], B[j][1]);
            if(endMin >= startMax) res.add(new int[]{startMax, endMin});
            if(A[i][1] == endMin) i++;
            if(B[j][1] == endMin) j++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
