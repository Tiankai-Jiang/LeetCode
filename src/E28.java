public class E28 {
    public int strStr(String haystack, String needle) {
        int h = haystack.length(), n=needle.length();
        if(n==0) return 0;
        if(n>h) return -1;
        for(int i=0; i<=h-n; i++) if(haystack.substring(i,i+n+1).equals(needle)) return i;
        return -1;
    }
}
