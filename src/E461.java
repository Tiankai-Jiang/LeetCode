import com.sun.deploy.util.StringUtils;

public class E461 {

    // My solution 1, slow
    public int hammingDistance(int x, int y) {
        int z = x ^ y, a = 0;
        while(z != 0){
            if((z & 1) == 1) ++a;
            z >>= 1;
        }
        return a;
    }

    // My solution 2, slower...
    public int hammingDistance2(int x, int y) {
        return Integer.toBinaryString(x ^ y).replace("0", "").length();
    }

    // Using bitcount...
    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
