public class M8 {
    public int myAtoi(String str) {
        boolean isNumBefore = false, isSignBefore = false;
        long res = 0;
        int sign = 1;
        for(char c: str.toCharArray()){
            if((isSignBefore || isNumBefore) && (c < '0' || c > '9')) break;
            if(!isNumBefore && c == ' ') continue;
            if(!isNumBefore && !(c=='+'||c=='-'||('0'<=c&&'9'>=c))) break;
            if(c == '+' || c == '-') {
                sign = c == '+' ? 1 : -1;
                isSignBefore = true;
                continue;
            }
            isNumBefore = true;
            res = 10*res + c-'0';
            if(res > Integer.MAX_VALUE) break;
        }
        if(!isNumBefore) return 0;
        else{
            if(res > Integer.MAX_VALUE) return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else return sign * (int)res;
        }
    }
}
