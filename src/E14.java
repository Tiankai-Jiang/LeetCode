public class E14 {

    private boolean allSame(String[] strs, int i){
        boolean same = true;
        char c = strs[0].charAt(i);
        for(int j=1; j<strs.length; j++){
            if(strs[j].charAt(i) != c){
                same = false;
                break;
            }
        }
        return same;
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int minLen = Integer.MAX_VALUE;
        for(String str: strs) minLen = Math.min(minLen, str.length());
        int i=0;
        for(;i<minLen;i++) if(!allSame(strs, i)) break;
        return strs[0].substring(0,i);
    }
}
