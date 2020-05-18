public class E944 {

    // My solution
    public int minDeletionSize(String[] A) {
        int a = 0;
        boolean[] b = new boolean[1000];
        for(int i = 0; i < A.length - 1; ++i){
            for(int j = 0; j < A[0].length(); ++j){
                if(A[i+1].charAt(j)-A[i].charAt(j)<0 && !b[j]){
                    a++;
                    b[j] = true;
                }
            }
        }
        return a;
    }

    // Switch two for loops, so we don't need that array to record
    public int minDeletionSize2(String[] A) {
        if(A.length <= 1 || A[0].length() <= 1) return 0;
        int res = 0;
        for(int i = 0; i < A[0].length(); i++){
            for(int j = 1; j < A.length; j++){
                if(A[j].charAt(i) < A[j-1].charAt(i)){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
