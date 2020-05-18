public class M537 {

    // My solution, avoid using split or indexOf to be faster
    private int[] getAB(String a){
        int i;
        int[] res = new int[2];
        char[] c = a.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(i = 0; c[i] != '+'; ++i) sb.append(c[i]);
        res[0] = Integer.parseInt(sb.toString());
        sb = new StringBuilder();
        for(int j = i+1; c[j] != 'i'; ++j) sb.append(c[j]);
        res[1] = Integer.parseInt(sb.toString());
        return res;
    }

    public String complexNumberMultiply(String a, String b) {
        int[] c1 = getAB(a), c2 = getAB(b);
        StringBuilder sb = new StringBuilder();
        return sb.append(c1[0]*c2[0]-c1[1]*c2[1]).append('+').append(c1[0]*c2[1]+c1[1]*c2[0]).append('i').toString();
    }
}
