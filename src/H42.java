public class H42 {
    public int trap(int[] A){
        if(A.length < 3) return 0;
        int res = 0, l = 0, r = A.length - 1;
        while(l < r){
            int lbound = A[l], rbound = A[r];
            if(lbound <= rbound) while(l < r && lbound >= A[++l]) res += (lbound - A[l]);
            else while(l < r && rbound >= A[--r]) res += (rbound - A[r]);
        }
        return res;
    }

    public int trap2(int[] A) {
        if(A.length < 3) return 0;
        int ans = 0, size = A.length, left_max[] = new int[size], right_max[] = new int[size];
        left_max[0] = A[0];
        for (int i = 1; i < size; i++) left_max[i] = Math.max(A[i], left_max[i - 1]);
        right_max[size - 1] = A[size - 1];
        for (int i = size - 2; i >= 0; i--) right_max[i] = Math.max(A[i], right_max[i + 1]);
        for (int i = 1; i < size - 1; i++) ans += Math.min(left_max[i], right_max[i]) - A[i];
        return ans;
    }
}
