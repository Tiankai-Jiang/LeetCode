public class M29 {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && Math.abs(divisor) == 1) return divisor == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        boolean sign = (dividend > 0 == divisor > 0);
        long dvnd = Math.abs((long)dividend), dvsr = Math.abs((long)divisor);
        int res = 0, x;
        while(dvsr <= dvnd){
            for(x = 1; dvnd >= dvsr << x; x++);
            res += 1 << (x-1);
            dvnd -= (dvsr << (x-1));
        }
        return sign ? res : -1*res;
    }
}
