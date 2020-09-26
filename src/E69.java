public class E69 {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int lo = 1, hi = x;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if((long)mid * mid > Integer.MAX_VALUE || mid*mid > x) hi = mid - 1;
            else if(mid*mid <= x && ((mid+1)*(mid+1)>x || (long)(mid+1) * (mid+1)>Integer.MAX_VALUE)) return mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
