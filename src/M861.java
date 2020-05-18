public class M861 {

    // My solution
    public int matrixScore(int[][] A) {
        int a = 0, len = A[0].length;
        for(int i = 0; i < A.length; ++i){
            if(A[i][0] == 1) continue;
            else for(int j = 0; j < len; ++j) A[i][j] ^= 1;
        }
        for(int j = 1; j < len; ++j){
            int c = 0;
            for(int i = 0; i < A.length; ++i) c+= A[i][j];
            if(c<=A.length/2) for(int i = 0; i < A.length; ++i) A[i][j] ^= 1;
        }
        for(int i = 0; i < A.length; ++i) for(int j = 0; j < len; ++j) if(A[i][j]==1) a+=(A[i][j]<<(len-1-j));
        return a;
    }
}
