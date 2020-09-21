public class E7 {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        long res = Long.parseLong(new StringBuilder(String.valueOf(Math.abs((long)x))).reverse().toString());
        if(res <= Integer.MAX_VALUE && res >= Integer.MIN_VALUE) return sign*(int)res;
        return 0;
    }

    public int reverse2(int x) {
        long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x /= 10;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int)res;
    }
}
