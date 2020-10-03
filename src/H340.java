public class H340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int m[] = new int[128], i = 0, maxLen = 0, num = 0;
        for(int j=0; j<s.length(); j++){
            if(m[s.charAt(j)]++==0) num++;
            if(num > k){
                while(--m[s.charAt(i++)]>0);
                num--;
            }
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}
