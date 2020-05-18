public class M260 {

    /**
     In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find.
     Note that since the two numbers are distinct,so there must be a set bit (that is, the bit with value '1') in the XOR result.
     Find out an arbitrary set bit (for example, the rightmost set bit).

     In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementioned bit unset.
     Two different numbers we need to find must fall into the two distinct groups. XOR numbers in each group, we can find a number in either group.
     * */
    public int[] singleNumber(int[] nums) {
        // Get the XOR of the two numbers we need to find
        int d = 0;
        for (int i : nums) d ^= i;
        // Get its last set bit
        d &= -d;
        int[] r = {0, 0};
        for (int i : nums) r[(i & d) == 0 ? 0 : 1] ^= i;
        return r;
    }
}
