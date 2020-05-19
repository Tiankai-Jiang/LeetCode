import java.util.Arrays;

public class M739 {

    // My solution
    public int[] dailyTemperatures(int[] T) {
        int[] a = new int[T.length], b = new int[101];
        Arrays.fill(b, T.length);
        for(int i = T.length-1; i>= 0; --i){
            int min = T.length;
            for(int j = T[i]+1; j < 101; ++j) min = Math.min(min, b[j]);
            a[i] = (min == T.length ? 0 : min-i);
            b[T[i]] = i;
        }
        return a;
    }

    // Using a "stack" like array
    // Store currently unsolved elements, later if there is a bigger number, withdraw the unsolved elements and get the answer.
    public int[] dailyTemperatures2(int[] T) {
        int[] stack = new int[T.length], ret = new int[T.length];
        int top = -1;
        for(int i = 0; i < T.length; i++) {
            while(top > -1 && T[i] > T[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }
}
