public class E806 {

    // My solution
    public int[] numberOfLines(int[] widths, String S) {
        int r = 0, l = 1;
        for(char c: S.toCharArray()) {
            if(r+widths[c-'a']<=100) r+=widths[c-'a'];
            else{
                l++;
                r=widths[c-'a'];
            }
        }
        return new int[]{l, r};
    }
}
