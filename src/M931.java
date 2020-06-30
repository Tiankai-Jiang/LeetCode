public class M931 {

    // My solution
    public int minFallingPathSum(int[][] A) {
        for(int i = 1; i < A.length; ++i){
            for(int j = 0; j < A.length; ++j){
                int min = 10001;
                for(int k : new int[]{-1, 0, 1}) if(j+k>=0&&j+k<A.length) min = Math.min(min, A[i-1][j+k]+A[i][j]);
                A[i][j] = min;
            }
        }
        int a = 10001;
        for(int i=0;i<A.length;++i) a = Math.min(a, A[A.length-1][i]);
        return a;
    }
}
