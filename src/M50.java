public class M50 {

    private double helper(double x, int n){
        if(n==0) return 1;
        if((n & 1) == 1) return x * helper(x, n-1);
        else return helper(x*x, n/2);
    }

    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE) return 1/helper(x*x, -(n/2));
        return n >= 0? helper(x, n) : 1/helper(x, -n);
    }


}
