import java.util.Random;

public class M528 {

    int[] wSum;
    Random r;
    public M528(int[] w) {
        this.r = new Random();
        for(int i=1; i<w.length; ++i) w[i] += w[i-1];
        this.wSum = w;
    }

    public int pickIndex() {
        int len = wSum.length;
        int num = r.nextInt(wSum[len-1]) + 1;
        int left = 0, right = len - 1;
        // search position
        while(left < right){
            int mid = left + (right-left)/2;
            if(wSum[mid] == num) return mid;
            else if(wSum[mid] < num) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
