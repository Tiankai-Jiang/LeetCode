import java.util.Collections;

public class E476 {

    // My solution 1, slow
    public int findComplement(int num) {
        return Integer.parseInt(String.join("", Collections.nCopies(Integer.toBinaryString(num).length(), "1")), 2) ^ num;
    }

    // My solution 2, fast
    public int findComplement2(int num){
        String s = Integer.toBinaryString(num);
        int a = 0, l = s.length();
        for(int i = 0; i < l; ++i) if((s.charAt(i) - '0') == 0) a += Math.pow(2, l-1-i);
        return a;
    }

    // Use 11...11 - num
    public int findComplement3(int num) {
        int n = 0;
        while (n < num) n = (n << 1) | 1;
        return n - num;
    }
}
