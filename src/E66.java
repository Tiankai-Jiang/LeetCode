public class E66 {
    public int[] plusOne(int[] digits) {
        int cur = digits.length-1;
        while(cur>=0 && digits[cur]==9) digits[cur--] = 0;
        if(cur==-1){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }else{
            digits[cur]++;
            return digits;
        }
    }
}
